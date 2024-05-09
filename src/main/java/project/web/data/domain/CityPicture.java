package project.web.data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city_picture")
public class CityPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpic_num")
    private Long cPic_num;

    @Id
    @Column(name = "c_num")
    private Integer cNum;

    @Column(name = "cpic_url")
    private String cPicUrl;
}
