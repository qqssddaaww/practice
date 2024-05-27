package project.web.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchHotelDto {

    private String hName;

    private String hpUrl;

    private double hRate;

    private String cName;

    public SearchHotelDto(String hName, String hPicUrl, double hRate, String cName) {
        this.hName = hName;
        this.hpUrl = hPicUrl;
        this.hRate = hRate;
        this.cName = cName;
    }

}
