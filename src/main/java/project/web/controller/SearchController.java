package project.web.controller;

import org.springframework.web.bind.annotation.*;
import project.web.data.dto.CityDTO;
import project.web.data.dto.NativeDTO;
import project.web.data.dto.SearchHotelDto;
import project.web.data.service.city.CityService;
import project.web.data.service.hotel.HotelService;
import project.web.data.service.nativeP.NativeService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
public class  SearchController {
    private final HotelService hotelService;
    private final CityService cityService;
    private final NativeService nativeService;

    public SearchController(HotelService hotelService, CityService cityService, NativeService nativeService) {
        this.hotelService = hotelService;
        this.cityService = cityService;
        this.nativeService = nativeService;
    }
    //     지윤
    @GetMapping("/getCity-all")
    public List<CityDTO> getAllCity() {
        return cityService.getCityAll();
    }
    @GetMapping("/getCity")
    public CityDTO getCity(String cName) {
        return cityService.getCity(cName);
    }

    //     남욱
    @GetMapping(value = "/city-hotels")
    public List<SearchHotelDto> getCityHotel(@RequestParam("city") String name) {
        return hotelService.getHotelBycName(name);
    }

    @GetMapping(value = "/hotel/city/{sort}")
    public List<SearchHotelDto> getHotelByCityNameOrderByRoomCost(@RequestParam(name = "city") String name,
                                                                  @PathVariable(name = "sort") String sort) throws IllegalArgumentException {

        if(!(cityService.existsCity(name))) {
            throw new IllegalArgumentException("City not found in City Entity: " + name);
        }

        List<SearchHotelDto> hotelCost;

        switch (sort) {
            case "price_a" -> hotelCost = hotelService.getHotelBycNameOrderByRoomCostDesc(name);
            case "price_b" -> hotelCost = hotelService.getHotelBycNameOrderByRoomCostAsc(name);
            default -> throw new IllegalArgumentException("Invalid sort: " + sort);
        }

        return hotelCost;
    }

    @GetMapping(value = "/hotel/city/nation")
    public List<SearchHotelDto> getHotelByNationName(@RequestParam(name = "nation") String name) {

        Optional<List<SearchHotelDto>> hotelByNationName = hotelService.getHotelBynName(name);

        return hotelByNationName.orElseThrow(() -> new IllegalArgumentException("Not found Nation"));
    }

    @GetMapping(value = "/native-list")
    public List<NativeDTO> getNativeList() {
        return nativeService.getNativeList();
    }

    @GetMapping(value = "/native-list-find")
    public List<NativeDTO> findByNativeList(@RequestParam Long num) {
        return nativeService.findbyNativeList(num);
    }
}
