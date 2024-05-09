package project.web.controller;

import org.springframework.web.bind.annotation.*;
import project.web.data.domain.City;
import project.web.data.domain.Hotel;
import project.web.data.dto.CityDTO;
import project.web.data.service.city.CityService;
import project.web.data.service.hotel.HotelService;

import java.util.List;


@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
public class  SearchController {
    private final HotelService hotelService;
    private final CityService cityService;

    public SearchController(HotelService hotelService, CityService cityService) {
        this.hotelService = hotelService;
        this.cityService = cityService;
    }
    //  도시 이름으로 검색
    @GetMapping(value = "/search")
    public CityDTO getCityByName(String cityName) {
        return cityService.getOneCity(cityName);
    }
    //  전체 도시 검색
    @GetMapping(value = "/all-city")
    public List<City> getAllCity(){
        return cityService.getCityAll();
    }
    //  전체 호텔 검색
    @GetMapping(value = "/all-hotel")
    public List<Hotel> getAllHotel() {
        return hotelService.getAllHotel();
    }
    //  이름으로 호텔 뽑기, 이름이 같은 호텔이 있을 수 있기 떄문에 List타입으로 받음
    @GetMapping(value = "/name-hotel")
    public List<Hotel> getHotelByName(@RequestParam String name) {
        return hotelService.getHotelByName(name);
    }


}
