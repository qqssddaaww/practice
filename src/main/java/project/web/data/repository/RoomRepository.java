package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.Room;

import java.util.*;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("select r from Room r join r.hotel h where h.hName = :name")
    List<Room> findByHotelRoom(String name);

}
