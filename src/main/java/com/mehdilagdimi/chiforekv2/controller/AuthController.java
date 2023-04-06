package com.mehdilagdimi.chiforekv2.controller;


import com.google.gson.Gson;
import com.mehdilagdimi.chiforekv2.exception.UserAlreadyExistAuthenticationException;
import com.mehdilagdimi.chiforekv2.model.AuthRequest;
import com.mehdilagdimi.chiforekv2.model.SignupRequest;
import com.mehdilagdimi.chiforekv2.model.entity.User;
import com.mehdilagdimi.chiforekv2.service.UserService;
import com.mehdilagdimi.chiforekv2.util.JwtHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtHandler jwtHandler;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody AuthRequest authRequest) throws JSONException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.email(),
                        authRequest.password()));
        final User user = (User) authentication.getPrincipal();

        if (user != null) {
            String jwt = jwtHandler.generateToken(user);
            final Gson gson = new Gson();
            return ResponseEntity.ok().body(gson.toJson(jwt));
        }

            System.out.println(" after user not null ");
        return ResponseEntity.status(401).build();
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signup(
            @RequestBody SignupRequest signupRequest) {
        System.out.println(" inside ");
        if (signupRequest.getRole().toString().equals("ROLE_ADMIN")) throw new IllegalArgumentException();
        User user = userService.addUser(signupRequest);
        String jwt = jwtHandler.generateToken(user);

        return ResponseEntity.status(201).body(jwt);
    }



    @ExceptionHandler(UserAlreadyExistAuthenticationException.class)
    public ResponseEntity<?> userAlreadyExists(){
        return ResponseEntity.status(403).build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegateArgument(){
        return ResponseEntity.status(401).build();
    }

}
