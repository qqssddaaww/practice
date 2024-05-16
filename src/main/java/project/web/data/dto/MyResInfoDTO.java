package project.web.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MyResInfoDTO {

    private Long resNum; // 예약 번호
    private Integer guest; // 예약 인원
    private LocalDate resDate; // 예약 날짜
    private Long paCost; // 방 비용
    private String paName; // 객실명

    public MyResInfoDTO(Long resNum, Integer guest, LocalDate resDate, Long paCost, String paName) {
        this.resNum = resNum;
        this.guest = guest;
        this.resDate = resDate;
        this.paCost = paCost;
        this.paName = paName;
    }
}
