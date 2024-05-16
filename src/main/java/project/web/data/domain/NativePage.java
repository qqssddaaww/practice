package project.web.data.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "native_page")
public class NativePage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pa_num")
    private Long paNum; // 페이지 식별번호

    @Column(name = "pa_title")
    private String paTitle; // 제목

    @Column(name = "pa_writer")
    private String paWriter ; // 작성자

    @Column(name = "pa_con")
    private String paCon; // 내용

    @Column(name = "pa_date")
    private LocalDate paDate; // 작성일자

    @Column(name = "pa_res")
    private boolean paRes; // 예약 여부

    @Column(name = "pa_capacity")
    private String paCapacity; // 객실 인원 수

    @Column(name = "pa_cost")
    private Long paCost; // 객실 비용

    @Column(name = "pa_resinfo")
    private String paResInfo; // 객실 정보

    @Column(name = "pa_name")
    private String paName; // 객실명

    @Column(name = "pa_facility")
    private String paFacility; // 시설 및 서비스

    @Column(name = "pa_bed")
    private String paBed; // 침대 수

    @Column(name = "pa_type")
    private String paType; // 객실유형

    @Column(name = "pa_no")
    private String paNo; // 객실번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "h_num")
    @JsonManagedReference
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "n_num")
    @JsonManagedReference
    private Native aNative; // 현지인 식별번호 - native와 외래키

    @OneToMany(mappedBy = "nativePage",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Reservation> reservationList = new ArrayList<>();

}
