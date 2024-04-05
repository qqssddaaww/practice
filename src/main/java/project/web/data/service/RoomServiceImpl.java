package project.web.data.service;

import org.springframework.data.web.config.SpringDataJacksonModules;
import org.springframework.stereotype.Service;
import project.web.data.domain.Hotel;
import project.web.data.domain.Room;
import project.web.data.dto.RoomDTO;
import project.web.data.repository.RoomRepository;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> AllRoom(String name) {
        List<Room> all = roomRepository.findByHotelRoom(name);

        return all;
    }


    @Override
    public RoomDTO getOne(Integer id) {
        Room selectOne = roomRepository.getOne(id);
        Hotel one = roomRepository.findByHotel(id);

        RoomDTO getOneRoom = new RoomDTO();

        getOneRoom.setCost(selectOne.getRCost());

        getOneRoom.setHNum(one);

        getOneRoom.setPeople(selectOne.getRPeople());
        getOneRoom.setResInfo(selectOne.getRResInfo());

        return getOneRoom;
    }
}
