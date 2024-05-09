package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {

    City findBycName(String name);
    @Query("select c.cName, h from City c join c.cNum h where c.cName = :name")
    List<Object> findByOneCityAndHotel(String name);

    @Query("select c from City c join c.hotelList ch where ch.hNum = :hNum")
    City findCityInHotel(Long hNum);

}
