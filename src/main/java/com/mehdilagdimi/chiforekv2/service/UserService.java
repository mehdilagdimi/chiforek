package com.mehdilagdimi.chiforekv2.service;


import com.mehdilagdimi.chiforekv2.exception.UserAlreadyExistAuthenticationException;
import com.mehdilagdimi.chiforekv2.exception.UserNotFoundException;
import com.mehdilagdimi.chiforekv2.model.SignupRequest;
import com.mehdilagdimi.chiforekv2.model.UserDTO;
import com.mehdilagdimi.chiforekv2.model.entity.Admin;
import com.mehdilagdimi.chiforekv2.model.entity.Recipient;
import com.mehdilagdimi.chiforekv2.model.entity.ServiceProvider;
import com.mehdilagdimi.chiforekv2.model.entity.User;
import com.mehdilagdimi.chiforekv2.repository.AdminRepository;
import com.mehdilagdimi.chiforekv2.repository.RecipientRepository;
import com.mehdilagdimi.chiforekv2.repository.ServiceProviderRepository;
import com.mehdilagdimi.chiforekv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{

    private final UserRepository userRepository;

    private final AdminRepository adminRepository;
    private final ServiceProviderRepository serviceProviderRepository;
    private final RecipientRepository recipientRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found......"));
    }

    public User addUser(SignupRequest signupReq) throws UserAlreadyExistAuthenticationException {
        if(userRepository.findByEmail(signupReq.getEmail()).isPresent())
            throw new UserAlreadyExistAuthenticationException("User already exist");

        //creating user object and setting its authorities
        User user = new User(
                signupReq.getEmail(), signupReq.getUsername(), signupReq.getTele(), signupReq.getRole(),
                passwordEncoder.encode(signupReq.getPassword())
        );

        switch (user.getRole().toString()){
            case "ROLE_ADMIN":
                adminRepository.save(new Admin(user));
                break;
            case "ROLE_RECIPIENT":
                recipientRepository.save(new Recipient(user));
                break;
            case "ROLE_PROVIDER":
                serviceProviderRepository.save(new ServiceProvider(user));
                break;
        }
        return user;
    }


    public Page<UserDTO> getAll(int requestedPage, int maxItems){
        Pageable pageableUsers = PageRequest.of(
                requestedPage, maxItems,
                Sort.by("createdAt").descending().and(Sort.by("isEnabled").descending())
        );
        Page<User> users = userRepository.findAll(pageableUsers);

        Page<UserDTO> userDTOS = users.map(this::convertToUserResponse);

        return userDTOS;
    }

    public UserDTO getById(Long id){
        return convertToUserResponse(
                userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not found"))
        );
    }

    public Recipient getRecipient(Long id){
        return recipientRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public UserDTO convertToUserResponse(User user){
        return
                new UserDTO(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getTele(),
                        user.isEnabled(),
                        user.getCreatedAt()
                );
    }

}
