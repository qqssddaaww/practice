package project.web.data.service.NativePage;

import project.web.data.domain.Hotel;
import project.web.data.domain.Native;
import project.web.data.dto.NpInsertDTO;
import project.web.data.dto.ShowNPDTO;

import java.util.List;

public interface NativePageService {
    List<ShowNPDTO> getRoom(Long hNum);
    void insertRoom(NpInsertDTO npInsertDTO, Hotel hotel, Native aNative);
}
