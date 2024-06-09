package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.Native;
import project.web.data.domain.NativePage;
import project.web.data.dto.MainNativePageDTO;
import project.web.data.dto.PicDTO;
import project.web.data.dto.RegisterRoomDTO;
import project.web.data.dto.nativeInfoDTO;

import java.util.List;

public interface NativePageRepository extends JpaRepository<NativePage, Long> {

    @Query("select np from NativePage np where np.paNum = :paNum")
    NativePage findNp(Long paNum);

    @Query("select new project.web.data.dto.RegisterRoomDTO(np.paNum ,h.hName, r.rCost, npp.paPicUrl, np.paDate, r.rName, np.paCharge) " +
            "from NativePage np join np.room r join r.hotel h join np.nativePagePictures npp where np.aNative = :aNative and npp.paPicUrl like '%main%'")
    List<RegisterRoomDTO> findRegisterByNative(Native aNative);

    @Query("select new project.web.data.dto.PicDTO(npp.paPicUrl) from NativePage np join np.nativePagePictures npp where npp.nativePage.paNum = :paNum")
    List<PicDTO> findNpPic(Long paNum);

    @Query("select new project.web.data.dto.nativeInfoDTO(n.nName, n.nProfile, n.nPhone) from NativePage np join np.aNative n where np.paNum = :paNum")
    nativeInfoDTO findNative(Long paNum);

    @Query("select new project.web.data.dto.MainNativePageDTO" +
            "(npp.paPicUrl, h.hName, r.rName, r.rCost, np.paCharge) " +
            "from Native n join n.nativePageList np join np.nativePagePictures npp join np.room r join r.hotel h " +
            "group by r.rName order by r.rCost")
    List<MainNativePageDTO> getNativePage();
}
