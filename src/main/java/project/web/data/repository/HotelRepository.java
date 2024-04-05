package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.Hotel;
import java.util.*;
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    List<Hotel> findAllByhName(String name);


}
