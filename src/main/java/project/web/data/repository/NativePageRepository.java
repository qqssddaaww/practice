package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.NativePage;
import project.web.data.dto.ShowNPDTO;

import java.util.List;

public interface NativePageRepository extends JpaRepository<NativePage, Long> {

    @Query("select new project.web.data.dto.ShowNPDTO" +
            "(np.paNum, np.paCapacity, np.paCost, np.paRes, np.paName, np.paInfo, np.paFacility, np.paBed, np.paType, np.paNo) " +
            "from NativePage np join np.hotel h where h.hNum = :hNum and " +
            "np.paCost = (select min(np2.paCost) from NativePage np2 where " +
            "np2.hotel.hNum = h.hNum and np2.paCapacity = np.paCapacity) order by np.paCapacity")
    List<ShowNPDTO> findRoomByHotel(Long hNum);
}
