package project.web.data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel_picture")
public class HotelPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hpic_num")
    private Integer hPic_num;

    @Id
    @Column(name = "h_num")
    private Integer hNum;

    @Column(name = "hpic_url")
    private String hPicUrl;
}
