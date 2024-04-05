package project.web.data.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import project.web.data.domain.Hotel;
import project.web.data.dto.HotelDTO;
import project.web.data.repository.HotelRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    private HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> allHotel() {
        List<Hotel> all = hotelRepository.findAll();

        return all;
    }

    @Override
    public List<Hotel> getHotel(String name) {
        List<Hotel> selectHotel = hotelRepository.findAllByhName(name);

//        List<Double> position = new ArrayList<>();
//        position.add(selectHotel.getHLong());
//        position.add(selectHotel.getHLat());
//
//        HotelDTO getHotel = new HotelDTO();
//        getHotel.setName(selectHotel.getHName());
//        getHotel.setPhone(selectHotel.getHPhone());
//        getHotel.setEmail(selectHotel.getHEmail());
//        getHotel.setSite(selectHotel.getHSite());
////        getHotel.setLat(selectHotel.getHLat());
////        getHotel.setLong(selectHotel.getHLong());
//        getHotel.setPosition(position);
//        getHotel.setType(selectHotel.getHType());
//        getHotel.setAddr(selectHotel.getHAddr());
//        getHotel.setNum(selectHotel.getCNum());

        return selectHotel;
    }
}
