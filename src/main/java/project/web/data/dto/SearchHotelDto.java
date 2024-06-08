package project.web.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchHotelDto {

    private String hName; // 호텔이름
    private String hpUrl; // 호텔사진
    private double hRate; // 호텔별점
    private String cName; // 도시이름

    public SearchHotelDto(String hName, String hPicUrl, double hRate, String cName) {
        this.hName = hName;
        this.hpUrl = hPicUrl;
        this.hRate = hRate;
        this.cName = cName;
    }

}
