package project.web.data.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "native")
public class Native {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_num")
    private Integer nNum; // 현지인 식별 번호

    @Column(nullable = false, name = "n_id")
    private String nId; // 아이디

    @Column(nullable = false, name = "n_pw")
    private String nPw; // 비밀번호

    @Column(nullable = false, name = "n_gender")
    private String nGender; // 성별

    @Column(nullable = false, name = "n_phone")
    private String nPhone; // 전화번호

    @Column(nullable = false, name = "n_email")
    private String nEmail; // 이메일

    @Column(nullable = false, name = "n_location")
    private String nLocation; // 사는 지역

    @Column(name = "n_profile")
    private String nProfile; // 프로필사진

}
