package project.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.web.data.dto.MainHotelDTO;
import project.web.data.service.hotel.HotelService;

import java.util.*;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
public class MainController {

    private final HotelService hotelService;

    private List<MainHotelDTO> getHotelByType(Integer type) {
        List<MainHotelDTO> getType = hotelService.getHotelType(type);
        return getType;
    }

    //  호텔 뽑기
    @GetMapping(value = "/get-hotel")
    public List<MainHotelDTO> getHotelTypeOne(@RequestParam Integer type){
        return getHotelByType(type);
    }
}
