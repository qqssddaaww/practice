package project.web.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainRateDTO {
    private Long hNum;
    private String hName;
    private String hUrl;
    private Double rate;

    public MainRateDTO(Long hNum,String hName, String hUrl, Double rate) {
        this.hNum = hNum;
        this.hName = hName;
        this.hUrl = hUrl;
        this.rate = rate;
    }
}
