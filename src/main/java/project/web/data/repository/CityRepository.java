package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.web.data.domain.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {

    //    지윤
    List<City> findAllBycName(String name);

    @Query("select c from City c where c.cName like %:name%")
    List<City> findCityByName(@Param("name") String name);

    //  남욱
    boolean existsBycName(String name);

    @Query("select c from City c join c.hotelList ch where ch.hNum = :hNum")
    City findCityInHotel(Long hNum);
}
