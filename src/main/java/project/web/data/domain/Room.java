package project.web.data.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_num")
    private Long rNum; // 방 식별 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "h_num")
    @JsonManagedReference
    private Hotel hotel; // hotel 과 외래키

    @Column(name = "r_guest ")
    private Integer rGuest; // 객실 인원 수

    @Column(name = "r_cost")
    private Long rCost; // 객실 비용

    @Column(name = "r_resinfo")
    private String rResInfo; // 객실 정보

    @Column(name = "r_name")
    private String rName; // 객실명

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Reservation> reservationList;

    public void setHotel(Hotel hotel){
        this.hotel = hotel;
        hotel.getRoomList().add(this);
    }
}
