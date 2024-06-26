package project.web.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chat")
public class Chat {
    @Id
    @Column(name = "u_num")
    private Integer uNum; // 회원 식별 번호 - user와 외래키

    @Id
    @Column(name = "n_num")
    private Integer nNum; // 현지인 식별 번호 - native와 외래키
//    u_num, n_num은 왜래키 이자 기본키

    @Column(name = "chat_con")
    private String chatCon; // 채팅 내용

    @Column(name = "chatDate")
    private LocalDate chatDate; // 채팅 날짜
}
