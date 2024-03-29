package com.mehdilagdimi.chiforekv2.service;


import com.mehdilagdimi.chiforekv2.exception.ErrandNotFoundException;
import com.mehdilagdimi.chiforekv2.model.ErrandDTO;
import com.mehdilagdimi.chiforekv2.model.ErrandRequest;
import com.mehdilagdimi.chiforekv2.model.entity.Errand;
import com.mehdilagdimi.chiforekv2.model.entity.Recipient;
import com.mehdilagdimi.chiforekv2.model.entity.ServiceProvider;
import com.mehdilagdimi.chiforekv2.model.entity.User;
import com.mehdilagdimi.chiforekv2.repository.ErrandRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ErrandService {

    private final EntityManager entityManager;
    private final ErrandRepository errandRepository;

    public ErrandDTO save(ErrandRequest errandRequest, User serviceProvider) throws IllegalAccessException {
        if(serviceProvider instanceof Recipient) throw new IllegalAccessException("User Not Allowed to Create Errand");
        Errand errand =
                Errand.builder()
                    ._from(errandRequest._from())
                    ._to(errandRequest._to())
                    .description(errandRequest.description())
                    .meantype(errandRequest.meantype())
                    .service(errandRequest.service())
                    .build();


        errand.setServiceProvider( (ServiceProvider) serviceProvider );
        errandRepository.save(errand);
        entityManager.flush();
        return toDTO(errand);
    }


    public Page<ErrandDTO> getAll(Integer page, Integer maxItems){
        Pageable pageable =
                PageRequest
                        .of(page, maxItems, Sort.by("createdAt").descending());

        Page<Errand> errands = errandRepository.findAll(pageable);

        return toPageOfDTO(errands);

    }
    public Page<ErrandDTO> getAllByProvider(Long providerId, Integer page, Integer maxItems, User serviceProvider){
        Pageable pageable =
                PageRequest
                        .of(page, maxItems, Sort.by("createdAt").descending());

        Page<Errand> errands =
                errandRepository
                        .findAllByServiceProviderId(
                                providerId != null ? providerId : serviceProvider.getId(),
                                pageable);

        return toPageOfDTO(errands);

    }


    public Errand getById(Long id){
        Errand errand =
                errandRepository.findById(id)
                        .orElseThrow(() -> new ErrandNotFoundException("Invalid Errand ID"));
        return errand;

    }

    public synchronized void deleteById(Long id) throws ErrandNotFoundException {
        if(!errandRepository.existsById(id)){
            throw new ErrandNotFoundException("Invalid Errand ID");
        }

        errandRepository.deleteById(id);
    }

    public ErrandDTO toDTO(Errand errand){
        return
            ErrandDTO
                .builder()
                    .id(errand.getId())
                    .username(errand.getServiceProvider().getUsername())
                    .from(errand.get_from())
                    .to(errand.get_to())
                    .createdAt(errand.getCreatedAt())
                    .description(errand.getDescription())
                    .meantype(errand.getMeantype())
                    .service(errand.getService())
                    .build();
    }

    private Page<ErrandDTO> toPageOfDTO(Page<Errand> errandPage){
        return errandPage
                .map( errand -> toDTO(errand) );
    }
}
