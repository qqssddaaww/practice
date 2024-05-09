package project.web.data.service.reservation;

import project.web.data.dto.MyResInfoDTO;

import java.util.List;

public interface ReservationService {

    List<MyResInfoDTO> getResInfo(String id);
    void deleteRes(Long num);
}
