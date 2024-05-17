package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.NativePage;
import project.web.data.dto.ShowNPDTO;

import java.util.List;

public interface NativePageRepository extends JpaRepository<NativePage, Long> {

    @Query("select new project.web.data.dto.ShowNPDTO" +
            "(np.paNum, r.rCapacity, r.rCost, np.paRes, r.rName, np.paCon, np.paFacility, r.rBed, r.rType, r.rNo) " +
            "from NativePage np join np.hotel h join np.room r where h.hNum = :hNum and " +
            "r.rCost = (select min(r.rCost) from NativePage np2 where np2.hotel.hNum = h.hNum) order by r.rCapacity")
    List<ShowNPDTO> findRoomByHotel(Long hNum);
}
