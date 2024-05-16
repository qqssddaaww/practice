package project.web.controller;

import org.springframework.web.bind.annotation.*;
import project.web.data.dto.MainHotelDTO;
import project.web.data.dto.RecommendHotelDTO;
import project.web.data.service.hotel.HotelService;

import java.util.*;

@RestController
@RequestMapping("/main")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
public class MainController {
    private final HotelService hotelService;

    public MainController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // 중복된 코드(매개변수 type 을 받아 type 이 있는 hotel 을 뽑음) 메서드로 만듬
    private List<MainHotelDTO> getHotelByType(Integer type) {
        List<MainHotelDTO> getType = hotelService.getHotelType(type);
        return getType;
    }

    //  특가 호텔 type-1
    @GetMapping(value = "/get-hotel")
    public List<MainHotelDTO> getHotelTypeOne(@RequestParam Integer type){
        return getHotelByType(type);
    }
}
