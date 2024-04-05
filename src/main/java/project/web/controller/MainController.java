package project.web.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.web.data.domain.Hotel;
import project.web.data.domain.Room;
import project.web.data.dto.HotelDTO;
import project.web.data.dto.RoomDTO;
import project.web.data.service.HotelService;
import project.web.data.service.RoomService;

import java.util.*;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private RoomService roomService;

    public MainController(HotelService hotelService, RoomService roomService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    @GetMapping(value = "/hotel-all")
    public List<Hotel> getAllHotel() {
        List<Hotel> getAll = hotelService.allHotel();

        return getAll;
    }

//    @GetMapping(value = "hotel-one")
//    public HotelDTO getOneHotel(String name) {
//        HotelDTO getOne = hotelService.getHotel(name);
//
//        return getOne;
//    }

    @GetMapping(value = "hotel-one")
    public List<Hotel> getHotelName(String name) {
        List<Hotel> getOne = hotelService.getHotel(name);

//        HotelDTO getOne = hotelService.getHotel(name);

        return getOne;
    }

    @GetMapping(value = "/room-all")
    public List<Room> getAllRoom(String name) {
        List<Room> getAll = roomService.AllRoom(name);

        return getAll;
    }

    @GetMapping(value = "/room-one")
    public RoomDTO getOneRoom(Integer id) {
        RoomDTO getOne = roomService.getOne(id);

        return getOne;
    }
}
