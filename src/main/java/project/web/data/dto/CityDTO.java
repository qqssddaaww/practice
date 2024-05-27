package project.web.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.web.data.domain.City;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
    private String name;
    private Double lng;
    private Double lat;
    private String info;
    private String pic;

    public City city() {
        return City.builder()
                .cName(this.name)
                .cLong(this.lng)
                .cLat(this.lat)
                .cInfo(this.info)
                .cPic(this.pic).build();
    }

}
