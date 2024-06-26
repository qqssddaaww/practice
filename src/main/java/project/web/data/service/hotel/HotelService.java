package project.web.data.service.hotel;

import project.web.data.domain.City;
import project.web.data.domain.Hotel;
import project.web.data.dto.*;

import java.util.*;

public interface HotelService {

    List<MainHotelDTO> getHotelType(Integer type);
    List<RecommendHotelDTO> getHotelRecommend(Integer type);
    List<Hotel> getAllHotel();
    List<Hotel> getHotelByName(String name);
    void insertHotelPic(List<String> url, Long hotelNum);
    List<TestDTO> getUrl();
    DetailHotelDTO getDetailHotel(Long num);
    List<PicDTO> getHotelPic(Long hNum);
    Hotel getHotel(Long num);
    List<RecommendHotelDTO> getSimilarHotel(City city);
}
