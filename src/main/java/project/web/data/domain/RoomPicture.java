package project.web.data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room_picture")
public class RoomPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpic_num")
    private Integer cPic_num;

    @Id
    @Column(name = "r_num")
    private Integer rNum;

    @Id
    @Column(name = "h_num")
    private Integer hNum;

    @Column(name = "rpic_url")
    private String cPicUrl;
}
