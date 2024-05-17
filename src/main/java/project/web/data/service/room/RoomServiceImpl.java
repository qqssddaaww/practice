package project.web.data.service.room;

import org.springframework.stereotype.Service;
import project.web.data.domain.Room;
import project.web.data.dto.ShowRoomDTO;
import project.web.data.repository.RoomRepository;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room getOneRoom(Long rNum) {
        Room room = roomRepository.getById(rNum);
        return room;
    }

    @Override
    public List<ShowRoomDTO> getAllRoom(Long hNum) {
        return roomRepository.findRoomByHotel(hNum);
    }
}
