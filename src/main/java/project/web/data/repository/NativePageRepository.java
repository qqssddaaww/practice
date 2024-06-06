package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.Native;
import project.web.data.domain.NativePage;
import project.web.data.dto.MainNativePageDTO;
import project.web.data.dto.RegisterRoomDTO;

import java.util.List;

public interface NativePageRepository extends JpaRepository<NativePage, Long> {

    @Query("select np from NativePage np where np.paNum = :paNum")
    NativePage findNp(Long paNum);

    @Query("select new project.web.data.dto.RegisterRoomDTO(np.paNum ,h.hName, r.rCost,npp.paPicUrl, np.paDate) " +
            "from NativePage np join np.room r join r.hotel h join np.nativePagePictures npp where np.aNative = :aNative and npp.paPicUrl like '%main%'")
    List<RegisterRoomDTO> findRegisterByNative(Native aNative);

    @Query("select new project.web.data.dto.RegisterRoomDTO(np.paNum ,h.hName, r.rCost, np.paDate) " +
            "from NativePage np join np.room r join r.hotel h where np.aNative = :aNative")
    List<RegisterRoomDTO> findRegisterByNative1(Native aNative);

    @Query("select new project.web.data.dto.MainNativePageDTO" +
            "(npp.paPicUrl, h.hName, r.rName, r.rCost, np.paCharge) " +
            "from Native n join n.nativePageList np join np.nativePagePictures npp join np.room r join r.hotel h " +
            "group by r.rName order by r.rCost")
    List<MainNativePageDTO> getNativePage();
}
