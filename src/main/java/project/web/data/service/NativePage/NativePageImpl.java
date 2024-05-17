package project.web.data.service.NativePage;

import org.springframework.stereotype.Service;
import project.web.data.domain.Hotel;
import project.web.data.domain.Native;
import project.web.data.domain.NativePage;
import project.web.data.dto.NpInsertDTO;
import project.web.data.dto.ShowNPDTO;
import project.web.data.repository.NativePageRepository;

import java.util.List;

@Service
public class NativePageImpl implements NativePageService{

    private final NativePageRepository nativePageRepository ;

    public NativePageImpl(NativePageRepository nativePageRepository) {
        this.nativePageRepository = nativePageRepository;
    }

    @Override
    public List<ShowNPDTO> getRoom(Long hNum) {
        return nativePageRepository.findRoomByHotel(hNum);
    }

    @Override
    public void insertRoom(NpInsertDTO npInsertDTO, Hotel hotel, Native aNative) {
        NativePage nativePage = npInsertDTO.nativePage(hotel, aNative);
        nativePageRepository.save(nativePage);
    }

    @Override
    public void updatePage(NpInsertDTO npInsertDTO) {

    }
}
