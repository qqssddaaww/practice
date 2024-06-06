package project.web.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import project.web.data.domain.Native;
import project.web.data.domain.User;

import java.time.LocalDate;

@Getter
@Setter
//
public class LoginDTORequest {

    @NotBlank(message = "아이디가 비어 있습니다.")
    private String id; // user, native - id
    @NotBlank(message = "비밀번호가 비어 있습니다.")
    private String pw; // user, native - pw
    private LocalDate birth; // user - 생년월일
    @NotBlank(message = "전화번호가 비어 있습니다.")
    private String phone; // user, native - phone
    @NotBlank(message = "성별이 비어 있습니다.")
    private String gender; // user, native - gender
    @NotBlank(message = "이름이 비어 있습니다.")
    private String name; // user, native - name
    @NotBlank(message = "이메일이 비어 있습니다.")
    private String email; // user, native - email

    private String profile; // native 프로필
    private String location; // native 사는 지역

    public User user() {
        return User.builder().
                uId(this.id).
                uPw(this.pw).
                uBirth(this.birth).
                uPhone(this.phone).
                uGender(this.gender).
                uName(this.name).
                uEmail(this.email).
                build();
    }
    public Native aNative() {
        return Native.builder().
                nId(this.id).
                nPw(this.pw).
                nPhone(this.phone).
                nEmail(this.email).
                nProfile(this.profile).
                nLocation(this.location).
                nName(this.name).
                build();
    }

}
