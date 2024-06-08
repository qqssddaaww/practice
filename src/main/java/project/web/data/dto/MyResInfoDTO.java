package project.web.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MyResInfoDTO {

    private Long resNum; // 예약 번호
    private Long paNum; // 예약을 한 페이지의 식별번호
    private Integer guest; // 예약 인원
    private LocalDate resDate; // 예약 날짜
    private Long rCost; // 방 비용
    private String rName; // 객실명
    private String hName; // 호텔 이름
    private String hUrl; // 호텔 사진

    public MyResInfoDTO(Long resNum,Long paNum, Integer guest, LocalDate resDate, Long rCost, String rName, String hName, String hUrl) {
        this.resNum = resNum;
        this.paNum = paNum;
        this.guest = guest;
        this.resDate = resDate;
        this.rCost = rCost;
        this.rName = rName;
        this.hName = hName ;
        this.hUrl = hUrl;
    }
}
