package project.web.data.dto;

import lombok.Getter;
import lombok.Setter;
import project.web.data.domain.Native;

@Getter
@Setter
public class NativeDTO {
    private String id;
    private String pw;
    private String gender;
    private String phone;
    private String email;
    private String location;
    private String profile;

    public Native nativeBuild() {
        return Native.builder()
                .nId(this.id)
                .nPw(this.pw)
                .nGender(this.gender)
                .nEmail(this.email)
                .nLocation(this.location)
                .nProfile(this.profile)
                .nPhone(this.phone)
                .build();
    }
}
