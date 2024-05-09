package project.web.data.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
// Hotel 과 Picture 를 가져오기 위해 DTO 생성, 4.18
// Room 도 가져오기 위해 고쳐야함
public class MainHotelDTO {
    private Long hNum; // hotel - 식별번호
    private String hName; // hotel - 호텔이름
    private Integer hType; // hotel - 타입
    private String hpUrl ; // hotelPicture - url 이름
    private Long rCost; // room - 비용
    private Integer rGuest; // room - 투숙인원



    public MainHotelDTO(Long hNum,String hName, Integer hType, String hpUrl, Long rCost, Integer rGuest) {
        this.hNum = hNum;
        this.hName = hName;
        this.hType = hType;
        this.hpUrl = hpUrl;
        this.rCost = rCost;
        this.rGuest = rGuest;
    }

    public MainHotelDTO(String hName, Integer hType) {
        this.hName = hName;
        this.hType = hType;
    }

}
