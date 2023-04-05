package com.mehdilagdimi.chiforekv2.service;


import com.mehdilagdimi.chiforekv2.exception.ErrandNotFoundException;
import com.mehdilagdimi.chiforekv2.model.ErrandDTO;
import com.mehdilagdimi.chiforekv2.model.ErrandRequest;
import com.mehdilagdimi.chiforekv2.model.ReservationDTO;
import com.mehdilagdimi.chiforekv2.model.ReservationRequest;
import com.mehdilagdimi.chiforekv2.model.entity.*;
import com.mehdilagdimi.chiforekv2.repository.ReservationRepository;
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
public class ReservationService {

    private final EntityManager entityManager;
    private final ErrandService errandService;
    private final ReservationRepository reservationRepository;

    public ReservationDTO save(ReservationRequest reservationRequest, User recipient) throws IllegalAccessException {
        if(recipient instanceof ServiceProvider) throw new IllegalAccessException("User Not Allowed to Create Reservation");

        Errand errand = errandService.getById( reservationRequest.errandId() );

        Reservation reservation =
                Reservation.builder()
                    .errand( errand )
                    .recipient( (Recipient) recipient )
                    .build();

        reservationRepository.save( reservation );
        entityManager.flush();

        return toDTO( reservation );
    }


    public Page<ReservationDTO> getAll(Integer page, Integer maxItems){
        Pageable pageable =
                PageRequest
                        .of(page, maxItems, Sort.by("createdAt").descending());

        Page<Reservation> reservations = reservationRepository.findAll(pageable);

        return toPageOfDTO(reservations);

    }
    public ReservationDTO getById(Long id){
        Reservation reservation =
                reservationRepository.findById(id)
                        .orElseThrow(() -> new ErrandNotFoundException("Invalid Errand ID"));
        return toDTO(reservation);

    }

    public synchronized void deleteById(Long id) throws ErrandNotFoundException {
        if(!reservationRepository.existsById(id)){
            throw new ErrandNotFoundException("Invalid Errand ID");
        }

        reservationRepository.deleteById(id);
    }

    private ReservationDTO toDTO(Reservation reservation){
        return
            ReservationDTO
                .builder()
                    .id( reservation.getId() )
                    .errandId( reservation.getErrand().getId() )
                    .from( reservation.getErrand().get_from() )
                    .to( reservation.getErrand().get_to() )
                    .recipientEmail( reservation.getRecipient().getEmail() )
                    .providerEmail( reservation.getErrand().getServiceProvider().getEmail() )
                    .service( reservation.getErrand().getService() )
                    .meantype( reservation.getErrand().getMeantype() )
                    .createdAt( reservation.getCreatedAt() )
                    .build();
    }

    private Page<ReservationDTO> toPageOfDTO(Page<Reservation> reservationPage){
        return reservationPage
                .map( reservation -> toDTO(reservation) );
    }
}
