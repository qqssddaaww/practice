package project.web.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.web.data.domain.Native;
import project.web.data.domain.NativePage;
import project.web.data.domain.Room;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NpInsertDTO {
    private String content;
    private String facility;

    public NativePage nativePage(Native aNative, Room room) {
        return NativePage.builder()
                .paCon(this.content)
                .paFacility(this.facility)
                .paDate(LocalDate.now())
                .paRes(false)
                .aNative(aNative)
                .room(room)
//                일단 Charge 고정값넣어놈 변경
                .paCharge(2.2)
                .build();
    }

}
