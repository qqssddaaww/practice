package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.Hotel;
import project.web.data.domain.Review;
import project.web.data.domain.User;
import project.web.data.dto.ShowReviewDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select new project.web.data.dto.ShowReviewDTO(r.revNum,u.uName, r.revRate, r.revCon, r.revDate, ur.resDate) " +
            "from Review r join r.user u join r.hotel h join u.reservationList ur where h.hNum = :hNum order by r.revDate desc")
    List<ShowReviewDTO> getReviewDescDate(Long hNum);

    @Query("select new project.web.data.dto.ShowReviewDTO(r.revNum,u.uName, r.revRate, r.revCon, r.revDate, ur.resDate) " +
            "from Review r join r.user u join r.hotel h join u.reservationList ur where h.hNum = :hNum order by r.revRate desc, r.revDate desc")
    List<ShowReviewDTO> getReviewDescRate(Long hNum);

    @Query("select count(u.uId) > 0 from Review r join r.user u where u.uNum = :uNum")
    boolean existsUser(Long uNum);

    @Query("select r from Review r join r.user u where r.user.uNum = :uNum order by r.revNum desc limit 1")
    Review findReviewRecent(Long uNum);

}
