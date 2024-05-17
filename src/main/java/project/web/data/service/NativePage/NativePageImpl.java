package project.web.data.service.NativePage;

import org.springframework.stereotype.Service;
import project.web.data.domain.Native;
import project.web.data.domain.NativePage;
import project.web.data.domain.Room;
import project.web.data.dto.NpInsertDTO;
import project.web.data.dto.ShowRoomDTO;
import project.web.data.repository.NativePageRepository;

import java.util.List;

@Service
public class NativePageImpl implements NativePageService{

    private final NativePageRepository nativePageRepository ;

    public NativePageImpl(NativePageRepository nativePageRepository) {
        this.nativePageRepository = nativePageRepository;
    }



    @Override
    public void insertNativePage(NpInsertDTO npInsertDTO, Native aNative, Room room) {
        NativePage nativePage = npInsertDTO.nativePage(aNative, room);
        nativePageRepository.save(nativePage);
    }

    @Override
    public void updatePage(NpInsertDTO npInsertDTO) {

    }

//    해당 NativePage를 리턴
    @Override
    public NativePage getNp(Long paNum) {
        return nativePageRepository.findNp(paNum);
    }

//    해당 NativePage가 예약되면 paRes(에약 여부)를 ture로 바꿔줌
    @Override
    public void updateResG(Long paNum) {
        NativePage nativePage = nativePageRepository.findNp(paNum);
        nativePage.setPaRes(true);
        nativePageRepository.save(nativePage);
    }

    @Override
    public void updateResB(Long paNum) {
        NativePage nativePage = nativePageRepository.findNp(paNum);
        nativePage.setPaRes(false);
        nativePageRepository.save(nativePage);
    }
}
