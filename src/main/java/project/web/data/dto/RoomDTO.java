package project.web.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import project.web.data.domain.Hotel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private Hotel hNum;
    private String guest;
    private Long cost;
    private String resInfo;

}
