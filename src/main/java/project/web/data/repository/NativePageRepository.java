package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.NativePage;
import project.web.data.dto.NativePageDTO;

import java.util.List;

public interface NativePageRepository extends JpaRepository<NativePage, Long> {

    @Query("select np from NativePage np join np.hotel h where h.hNum = :hNum")
    List<NativePageDTO> findRoomByHotel(Long hNum);
}
