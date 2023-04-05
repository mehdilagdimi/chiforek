package com.mehdilagdimi.chiforekv2.service;


import com.mehdilagdimi.chiforekv2.exception.UserNotFoundException;
import com.mehdilagdimi.chiforekv2.model.ErrandDTO;
import com.mehdilagdimi.chiforekv2.model.ErrandRequest;
import com.mehdilagdimi.chiforekv2.model.entity.Errand;
import com.mehdilagdimi.chiforekv2.repository.ErrandRepository;
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

    private final ErrandRepository errandRepository;

    public ErrandDTO save(ErrandRequest errandRequest){
        Errand errand =
                Errand.builder()
                    ._from(errandRequest._from())
                    ._to(errandRequest._to())
                    .description(errandRequest.description())
                    .meantype(errandRequest.meantype())
                    .service(errandRequest.service())
                    .build();

        errandRepository.save(errand);

        return toDTO(errand);
    }


    public Page<ErrandDTO> getAllErrands(Integer page, Integer maxItems){
        Pageable pageable =
                PageRequest
                        .of(page, maxItems, Sort.by("created_at").descending());

        Page<Errand> errands = errandRepository.findAll(pageable);

        return toPageOfDTO(errands);

    }
    public ErrandDTO getErrandById(Long id){
        Errand errand =
                errandRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("Invalid User ID"));

        return toDTO(errand);

    }

    private ErrandDTO toDTO(Errand errand){
        return
            ErrandDTO
                .builder()
                    ._from(errand.get_from())
                    ._to(errand.get_to())
                    .created_at(errand.getCreatedAt())
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
