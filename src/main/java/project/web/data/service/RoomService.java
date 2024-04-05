package project.web.data.service;


import project.web.data.domain.Room;
import project.web.data.dto.RoomDTO;

import java.util.*;

public interface RoomService {

    List<Room> AllRoom(String name);

    RoomDTO getOne(Integer id);


}
