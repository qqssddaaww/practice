package project.web.data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reservation")
public class Reservation {
    @Id
    @Column(name = "res_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resNum; // 예약 번호

    @Column(name = "res_date")
    private LocalDate resDate; // 예약 날짜

    @Column(name = "res_people", nullable = true)
    private Integer resPeople; // 예약 수

    @Column(name = "r_num")
    private Long rNum; // 객실식별번호 - room과 외래키

    @Column(name = "h_num")
    private Long hNum; // 호텔식별번호 - room과 외래키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_num")
    private User uNum; // 회원식별번호 - user와 외래키
}
