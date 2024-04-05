package project.web.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_num")
    private Integer rNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "h_num")
    private Hotel hNum ;

    @Column(name = "r_people")
    private String rPeople;

    @Column(name = "r_cost")
    private Long rCost;

    @Column(name = "r_resinfo")
    private String rResInfo;
}
