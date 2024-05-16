package project.web.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.web.data.domain.Hotel;
import project.web.data.domain.Native;
import project.web.data.domain.NativePage;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NpInsertDTO {
    private String title;
    private String writer;
    private String content;
    private String capacity;
    private Long cost;
    private String info;
    private String name;
    private String facility;
    private String bed;
    private String type;
    private String no;

    public NativePage nativePage(Hotel hotel, Native aNative) {
        return NativePage.builder()
                .paTitle(this.title)
                .paWriter(this.writer)
                .paCon(this.content)
                .paCapacity(this.capacity)
                .paCost(this.cost)
                .paInfo(this.info)
                .paName(this.name)
                .paFacility(this.facility)
                .paBed(this.bed)
                .paType(this.type)
                .paNo(this.no)
                .paDate(LocalDate.now())
                .paRes(false)
                .hotel(hotel)
                .aNative(aNative)
                .build();
    }


}
