package project.web.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShowRoomDTO {
    private Long paNum; // 방 식별 번호가 아닌 해당 객실을 올린 현지인페이지의 식별번호를 가져옴
    private String rCapacity; // 방 인원수 ex_ 2인실
    private Long rCost; // 비용
    private String rName; // 방 이름 ex_ 듀렉스 플렉스 방
    private String rFacility; // 방 편의시설 ex_ 금연방, 헤어드라이기 유무
    private String rBed; // 침대 갯수
    private String rType; // ?
    private String rNo; // 방 번호 ex_ 201호


    public ShowRoomDTO(Long paNum, String rCapacity, Long rCost, String rName, String rFacility, String rBed, String rType, String rNo) {
        this.paNum = paNum;
        this.rCapacity = rCapacity;
        this.rCost = rCost;
        this.rName = rName;
        this.rFacility = rFacility;
        this.rBed = rBed;
        this.rType = rType;
        this.rNo = rNo;
    }
}
