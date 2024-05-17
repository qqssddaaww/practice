package project.web.data.service.NativePage;

import org.springframework.stereotype.Service;
import project.web.data.domain.Hotel;
import project.web.data.domain.Native;
import project.web.data.domain.NativePage;
import project.web.data.domain.Room;
import project.web.data.dto.NpInsertDTO;
import project.web.data.dto.ShowNPDTO;
import project.web.data.repository.NativePageRepository;
import project.web.data.repository.RoomRepository;

import java.util.List;

@Service
public class NativePageImpl implements NativePageService{

    private final NativePageRepository nativePageRepository ;
    private final RoomRepository roomRepository;

    public NativePageImpl(NativePageRepository nativePageRepository, RoomRepository roomRepository) {
        this.nativePageRepository = nativePageRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<ShowNPDTO> getRoom(Long hNum) {
        return nativePageRepository.findRoomByHotel(hNum);
    }

    @Override
    public void insertRoom(NpInsertDTO npInsertDTO, Hotel hotel, Native aNative) {
        NativePage nativePage = npInsertDTO.nativePage(hotel, aNative);
        Room room = npInsertDTO.room();
        nativePage.setRoom(room);
        nativePageRepository.save(nativePage);
        roomRepository.save(room);
    }

    @Override
    public void updatePage(NpInsertDTO npInsertDTO) {

    }
}
