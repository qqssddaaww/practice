package project.web.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecommendHotelDTO {
    private String hName; // hotel - 호텔이름
    private String hpUrl; // hotelPicture - url 이름
    private Long hNum; // hotel - 식별번호
    public RecommendHotelDTO(Long hNum, String hName, String hpUrl) {
        this.hNum = hNum;
        this.hName = hName;
        this.hpUrl = hpUrl;
    }

}
