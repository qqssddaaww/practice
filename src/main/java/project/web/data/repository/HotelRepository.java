package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.City;
import project.web.data.domain.Hotel;
import project.web.data.dto.MainHotelDTO;
import project.web.data.dto.RecommendHotelDTO;
import project.web.data.dto.SearchHotelDto;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    List<Hotel> findAllByhName(String name);


    @Query("select new project.web.data.dto.MainHotelDTO (h.hNum, h.hName, h.hType, hp.hPicUrl, h.hRate) from Hotel h join h.hotelPictureList hp  "+
            "where h.hType = :type" )
    List<MainHotelDTO> findByHotelType(Integer type);

    @Query("select new project.web.data.dto.RecommendHotelDTO(h.hNum, h.hName,hp.hPicUrl) from Hotel h join h.hotelPictureList hp where h.hType = :type group by h.hName")
    List<RecommendHotelDTO> findByHotelNameUrl(Integer type);
    Hotel findByhNum(Long num);
    @Query("select new project.web.data.dto.RecommendHotelDTO(h.hNum, h.hNum, hp.hPicUrl) from Hotel h join h.hotelPictureList hp" +
            " where h.city = :city")
    List<RecommendHotelDTO> findSimilarHotel(City city);

    @Query("select count(h) from Hotel h join h.city c where c.cName = :cName")
    int findHotelCount(String cName);
    //    남욱
    @Query("select new project.web.data.dto.SearchHotelDto(h.hName, hp.hPicUrl, h.hRate, c.cName) " +
            "from Hotel h join h.city c join h.hotelPictureList hp " +
            "where c.cName = :name")
    List<SearchHotelDto> findHotelBycName(String name);
    @Query(value = "select new project.web.data.dto.SearchHotelDto(h.hName, hp.hPicUrl, h.hRate, c.cName) " +
            "from Hotel h " +
            "join h.city c " +
            "join h.hotelPictureList hp " +
            "join h.hotelRoomList r " +
            "where c.cName = :name " +
            "order by r.rCost desc")
    List<SearchHotelDto> findHotelBycNameOrderByRoomCostDesc(String name);
    @Query(value = "select new project.web.data.dto.SearchHotelDto(h.hName, hp.hPicUrl, h.hRate, c.cName) " +
            "from Hotel h " +
            "join h.city c " +
            "join h.hotelPictureList hp " +
            "join h.hotelRoomList r " +
            "where c.cName = :name " +
            "order by r.rCost asc")
    List<SearchHotelDto> findHotelBycNameOrderByRoomCostAsc(String name);
    @Query(value = "select new project.web.data.dto.SearchHotelDto(h.hName, hp.hPicUrl, h.hRate, c.cName) " +
            "from Hotel h " +
            "join h.city c " +
            "join c.nation n " +
            "join h.hotelPictureList hp " +
            "join h.hotelRoomList r " +
            "where n.nName = :name")
    List<SearchHotelDto> findHotelBynName(String name);
}
