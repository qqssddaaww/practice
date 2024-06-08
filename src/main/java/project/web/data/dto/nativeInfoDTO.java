package project.web.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class nativeInfoDTO {
    private String npName;
    private String npProfile;
    private String npPhone;

    public nativeInfoDTO(String npName, String npProfile, String npPhone) {
        this.npName = npName;
        this.npProfile = npProfile;
        this.npPhone = npPhone;
    }
}
