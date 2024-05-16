package project.web.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShowNPDTO {
//    native-page 보여주기 dto
    private Long paNum; // 식별번호
    private String paCapacity; // 방 인원수 ex_ 2인실
    private Long paCost; // 비용
    private Boolean paRes; // 예약 되었는지 안되었는지 true false값으로
    private String paName; // 방 이름 ex_ 듀렉스 플렉스 방
    private String paInfo; // 방 정보
    private String paFacility; // 방 편의시설 ex_ 금연방, 헤어드라이기 유무
    private String paBed; // 침대 갯수
    private String paType; // ?
    private String paNo; // 방 번호 ex_ 201호

    public ShowNPDTO(Long paNum, String paCapacity, Long paCost, boolean paRes, String paName,
                     String paInfo, String paFacility, String paBed, String paType, String paNo) {
        this.paNum = paNum;
        this.paCapacity = paCapacity;
        this.paCost = paCost;
        this.paRes = paRes;
        this.paName = paName;
        this.paInfo = paInfo;
        this.paFacility = paFacility;
        this.paBed = paBed;
        this.paType = paType;
        this.paNo = paNo;
    }

}
