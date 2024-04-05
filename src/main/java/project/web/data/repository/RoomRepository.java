package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.Hotel;
import project.web.data.domain.Room;

import java.util.*;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("select r from Room r join r.hNum h where h.hName = :name")
    List<Room> findByHotelRoom(String name);

    @Query("select h from Room r join r.hNum h where r.rNum = :id")
    Hotel findByHotel(Integer id);
}
