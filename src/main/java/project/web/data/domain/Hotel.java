package project.web.data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "h_num")
    private Integer hNum; // 호텔식별번호 - room 과 외래키 ( 부모 )

    @Column(name = "h_name")
    private String hName; // 이름

    @Column(name = "h_phone")
    private String hPhone; // 전화번호

    @Column(name = "h_email")
    private String hEmail; // 이메일

    @Column(name = "h_site")
    private String hSite; // 사이트

    @Column(name = "h_lat")
    private Double hLat; // 위도

    @Column(name = "h_long")
    private Double hLong; // 경도

    @Column(name = "h_type")
    private String hType; // 상태 - ex) 봄 여행 특가, 한정 특가등

    @Column(name = "h_addr")
    private String hAddr; // 주소

    @Column(name = "c_num")
    private String cNum; // 도시식별번호 - city의 기본키
}
