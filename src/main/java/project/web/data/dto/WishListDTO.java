package project.web.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WishListDTO {
    private Long paNum;
    private String hName;
    private String rName;
    private String hPicUrl;

    public WishListDTO(Long paNum, String hName, String rName, String hPicUrl) {
        this.paNum = paNum;
        this.hName = hName;
        this.rName = rName;
        this.hPicUrl = hPicUrl;
    }
}
