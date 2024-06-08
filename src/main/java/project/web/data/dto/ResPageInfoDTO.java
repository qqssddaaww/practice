package project.web.data.dto;

import lombok.*;
import project.web.data.domain.Hotel;
import project.web.data.domain.NativePage;
import project.web.data.domain.Room;
import project.web.data.domain.User;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResPageInfoDTO {
    private String hName; // 호텔 이름
    private String rName; // 방 이름
    private Long rCost; // 가격
    private Integer paCharge; // 수수료
    private String paFacility; // 방 상세 정보
    private String uPhone; // 사용자 전화번호
    private String uName; // 사용자 이름
    private String uEmail; // 사용자 이메일
    private LocalDate resDate; // 예약 시간

    public ResPageInfoDTO resPageInfo(User user, Hotel hotel, Room room, NativePage page) {
        return ResPageInfoDTO.builder()
                .hName(hotel.getHName())
                .rName(room.getRName())
                .rCost(room.getRCost())
                .paCharge(page.getPaCharge())
                .paFacility(page.getPaFacility())
                .uPhone(user.getUPhone())
                .uName(user.getUName())
                .uEmail(user.getUEmail())
                .resDate(LocalDate.now())
                .build();
    }

}
