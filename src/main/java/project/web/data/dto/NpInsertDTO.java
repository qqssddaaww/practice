package project.web.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.web.data.domain.Hotel;
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
    private String capacity;
    private Long cost;
    private String name;
    private String facility;
    private String bed;
    private String type;
    private String no;

    public NativePage nativePage(Hotel hotel, Native aNative) {
        return NativePage.builder()
                .paCon(this.content)
                .paFacility(this.facility)
                .paDate(LocalDate.now())
                .paRes(false)
                .hotel(hotel)
                .aNative(aNative)
                .build();
    }

    public Room room() {
        return Room.builder()
                .rName(this.name)
                .rBed(this.bed)
                .rNo(this.no)
                .rCost(this.cost)
                .rCapacity(this.capacity)
                .rType(this.type)
                .build();
    }

}
