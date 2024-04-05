package project.web.data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_num")
    private Long uNum; // 회원식별번호

    @OneToMany(mappedBy = "uNum", fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    @Column(unique = true, nullable = false, name = "u_id")
    private String uId; // 아이디

    @Column(nullable = false,  name = "u_pw")
    private String uPw; // 비밀번호

    //    @Column(nullable = false ,  name = "u_birth")
//    private LocalDate uBirth; // 생년월일

    @Column(unique = true, nullable = false,  name = "u_phone")
    private String uPhone; // 전화번호

    @Column(nullable = false, name = "u_gender")
    private String uGender; // 성별

    @Column(nullable = false, name = "u_name")
    private String uName; // 이름

    @Column(unique = true,nullable = false ,  name = "u_email")
    private String uEmail; // 이메일

    private String sns; // 소셜로그인 여부 - o x 로만
}
