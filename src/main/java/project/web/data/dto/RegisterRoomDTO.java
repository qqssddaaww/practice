package project.web.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class RegisterRoomDTO {
    private Long paNum; // 현지인이 올린 상품 개별번호
    private String hName; // 호텔 이름
    private Long rCost; // 자신이 올린 방 원가 가격
    private String hUrl; // 호텔 사진을 뽑을지 방 사진을 뽑을지 고민중
    private LocalDate paDate; // 상품 등록일

    public RegisterRoomDTO(Long paNum,String hName, Long rCost, String hUrl, LocalDate paDate) {
        this.paNum = paNum;
        this.hName = hName;
        this.rCost = rCost;
        this.hUrl = hUrl;
        this.paDate = paDate;
    }
}
