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


    //  Type 매개변수를 받아 1 번 기준 쿼리
    @Query("select new project.web.data.dto.MainHotelDTO (h.hNum, h.hName, h.hType, hp.hPicUrl, min(r.rCost), r.rCapacity) from Hotel h join h.hotelPictureList hp join h.roomList r "+
            "where h.hType = :type and hp.hPicUrl like '%main%' group by h.hName" )
    List<MainHotelDTO> findByHotelType(Integer type);

    @Query("select new project.web.data.dto.RecommendHotelDTO(h.hNum, h.hName,hp.hPicUrl) from Hotel h join h.hotelPictureList hp where h.hType = :type group by h.hName")
    List<RecommendHotelDTO> findByHotelNameUrl(Integer type);
    Hotel findByhNum(Long num);
    @Query("select new project.web.data.dto.RecommendHotelDTO(h.hNum, h.hNum, hp.hPicUrl) from Hotel h join h.hotelPictureList hp" +
            " where h.city = :city and hp.hPicUrl like '%main%' ")
    List<RecommendHotelDTO> findSimilarHotel(City city);

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
