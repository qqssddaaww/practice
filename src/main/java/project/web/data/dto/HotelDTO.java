package project.web.data.dto;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    private String Name;

    private String Phone;

    private String Email;

    private String Site;

    private List<Double> position;

    private String Type;

    private String Addr;

    private String Num;

}
