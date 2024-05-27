package project.web.data.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nation")
@Data
public class Nation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_num", nullable = false)
    private Long nNum;

    @Column(name = "n_name")
    private String nName;

    @OneToMany(mappedBy = "nation", fetch = FetchType.LAZY)
    private List<City> NationCityList = new ArrayList<>();
}