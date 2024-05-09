package project.web.data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @Column(name = "n_num")
    private Integer nNum; // 현지인 식별번호 - native와 외래키
}
