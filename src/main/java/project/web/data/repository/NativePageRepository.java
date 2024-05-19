package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.Native;
import project.web.data.domain.NativePage;
import project.web.data.dto.RegisterRoomDTO;

import java.util.List;

public interface NativePageRepository extends JpaRepository<NativePage, Long> {

    @Query("select np from NativePage np where np.paNum = :paNum")
    NativePage findNp(Long paNum);

    @Query("select new project.web.data.dto.RegisterRoomDTO(np.paNum ,h.hName, r.rCost,hp.hPicUrl, np.paDate) " +
            "from NativePage np join np.room r join r.hotel h join h.hotelPictureList hp where np.aNative = :aNative and hp.hPicUrl like '%main%'")
    List<RegisterRoomDTO> findRegisterByNative(Native aNative);

}
