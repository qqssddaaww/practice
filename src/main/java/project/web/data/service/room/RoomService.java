package project.web.data.service.room;

import project.web.data.domain.Room;
import project.web.data.dto.ShowRoomDTO;

import java.util.List;

public interface RoomService {

    Room getOneRoom(Long rNum);
    List<ShowRoomDTO> getAllRoom(Long hNum);

}
