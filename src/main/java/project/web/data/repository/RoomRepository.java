package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.web.data.domain.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
