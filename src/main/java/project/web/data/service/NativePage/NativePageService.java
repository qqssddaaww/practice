package project.web.data.service.NativePage;

import project.web.data.domain.Native;
import project.web.data.domain.NativePage;
import project.web.data.domain.Room;
import project.web.data.dto.NpInsertDTO;
import project.web.data.dto.RegisterRoomDTO;
import project.web.data.dto.ShowRoomDTO;

import java.util.List;

public interface NativePageService {
    void insertNativePage(NpInsertDTO npInsertDTO, Native aNative, Room room);
    void updatePage(NpInsertDTO npInsertDTO, Native aNative);
    NativePage getNp(Long paNum);
    void updateResG(Long paNum);
    void updateResB(Long paNum);
    List<RegisterRoomDTO> getRegisterRoom(Native aNative);
}
