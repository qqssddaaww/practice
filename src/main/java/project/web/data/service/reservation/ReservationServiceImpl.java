package project.web.data.service.reservation;

import org.springframework.stereotype.Service;
import project.web.data.dto.MyResInfoDTO;
import project.web.data.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<MyResInfoDTO> getResInfo(String id) {
        return reservationRepository.findResInfoByUser(id);
    }

    @Override
    public void deleteRes(Long num) {
        reservationRepository.deleteById(num);
    }
}
