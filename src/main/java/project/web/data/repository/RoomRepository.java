package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.Room;
import project.web.data.dto.ShowRoomDTO;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("select new project.web.data.dto.ShowRoomDTO" +
            "(np.paNum, r.rCapacity, r.rCost , r.rName, np.paFacility, r.rBed, r.rType, r.rNo) " +
            "from Room r join r.hotel h join r.nativePageList np where h.hNum = :hNum and " +
            "r.rCost = (select min(r2.rCost) from Room r2 where r2.hotel.hNum = h.hNum and r2.rName = r.rName) " +
            "and np.paRes = false order by r.rCapacity")
    List<ShowRoomDTO> findRoomByHotel(Long hNum);

    @Query("select r from Room r join r.hotel h where h.hNum = :hNum")
    List<Room> findRoom(Long hNum);
}
