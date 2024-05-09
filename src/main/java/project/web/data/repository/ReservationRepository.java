package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.Reservation;
import project.web.data.dto.MyResInfoDTO;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

//    Mypage -> 예약정보 보이기
    @Query("select new project.web.data.dto.MyResInfoDTO(res.resNum, res.resGuest, res.resDate, r.rCost, r.rName) " +
            "from Reservation res join res.user u join res.room r where res.user.uId = :id")
    List<MyResInfoDTO> findResInfoByUser(String id);
}
