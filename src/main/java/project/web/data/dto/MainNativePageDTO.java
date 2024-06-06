package project.web.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class MainNativePageDTO {
    String paPicUrl;
    String hName;
    String rName;
    Integer paPrice;  // room의 기본가격에서 수수료를 계산한 값

    public MainNativePageDTO(String paPicUrl, String hName, String rName, Long rCost, Integer paCharge) {
        this.paPicUrl = paPicUrl;
        this.hName = hName;
        this.rName = rName;
        this.paPrice = (int)(rCost * (1 + paCharge/100.0));  // room의 기본가격에서 수수료를 계산한 값
    }
}
