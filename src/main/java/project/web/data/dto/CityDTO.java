package project.web.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.web.data.domain.City;
import project.web.data.domain.Nation;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
    private Long num;
    private String name;
    private Double lng;
    private Double lat;
    private String info;
    private String pic;
    private Nation nation;

    public City city() {
        return City.builder()
                .cName(this.name)
                .cLong(this.lng)
                .cLat(this.lat)
                .cInfo(this.info)
                .cPic(this.pic)
                .nation(this.nation).build();
    }

}
