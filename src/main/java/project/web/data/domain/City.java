package project.web.data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_num")
    private Integer cNum; // 도시 식별 번호

    @Column(nullable = false, name = "c_name")
    private String cName; // 도시명

    @Column(nullable = false, name = "c_long")
    private Double clong; // 위도

    @Column(nullable = false, name = "c_lat")
    private Double clat; // 경도

    @Column(name = "c_info")
    private String cInfo;
}
