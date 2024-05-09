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

    // 중복된 코드(매개변수 type을 받아 type이 있는 hotel을 뽑음) 메서드로 만듬
    private List<MainHotelDTO> getHotelByType(Integer type) {
        List<MainHotelDTO> getType = hotelService.getHotelType(type);
        return getType;
    }
    private List<RecommendHotelDTO> getHotelRecommend(Integer type) {
        List<RecommendHotelDTO> getRecommend = hotelService.getHotelRecommend(type);
        return getRecommend;
    }

    //  특가 호텔 type-1
    @GetMapping(value = "/sale-hotel")
    public List<MainHotelDTO> getHotelTypeOne(@RequestParam(required = false, defaultValue = "1") Integer type){
        return getHotelByType(type);
    }

    //   추천 호텔 type-2
    @GetMapping(value = "/recommend1-hotel")
    public List<RecommendHotelDTO> getHotelTypeTwo(@RequestParam(required = false, defaultValue = "2") Integer type){
        return getHotelRecommend(type);
    }

    //    추천 호텔 type-3
    @GetMapping(value = "/recommend2-hotel")
    public List<RecommendHotelDTO> getHotelTypeThree(@RequestParam(required = false, defaultValue = "3") Integer type){
        return getHotelRecommend(type);
    }

    //    추천 호텔 type-4
    @GetMapping(value = "/recommend3-hotel")
    public List<MainHotelDTO> getHotelTypeFour(@RequestParam(required = false, defaultValue = "4") Integer type){
        return getHotelByType(type);
    }

    //    추천 호텔 type-5
    @GetMapping(value = "/recommend4-hotel")
    public List<MainHotelDTO> getHotelTypeFive(@RequestParam(required = false, defaultValue = "5") Integer type){
        return getHotelByType(type);
    }








}
