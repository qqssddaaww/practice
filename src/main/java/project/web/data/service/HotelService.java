package project.web.data.service;

import project.web.data.domain.Hotel;
import project.web.data.dto.HotelDTO;

import java.util.*;

public interface HotelService {
    List<Hotel> allHotel() ;
//    HotelDTO getHotel(String name);
    List<Hotel> getHotel(String name);
}
