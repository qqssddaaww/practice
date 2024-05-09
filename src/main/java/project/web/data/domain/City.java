package project.web.data.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_num")
    private Long cNum; // 도시 식별 번호

    @Column(nullable = false, name = "c_name")
    private String cName; // 도시명

    @Column(nullable = false, name = "c_long")
    private Double cLong; // 위도

    @Column(nullable = false, name = "c_lat")
    private Double cLat; // 경도

    @Column(name = "c_info")
    private String cInfo;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)

    @JsonBackReference
    private List<Hotel> hotelList;
}
