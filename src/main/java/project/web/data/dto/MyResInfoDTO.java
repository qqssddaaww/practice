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
    private Long roomCost; // 방 비용
    private String roomName; // 객실명

    public MyResInfoDTO(Long resNum, Integer guest, LocalDate resDate, Long roomCost, String roomName) {
        this.resNum = resNum;
        this.guest = guest;
        this.resDate = resDate;
        this.roomCost = roomCost;
        this.roomName = roomName;
    }
}
