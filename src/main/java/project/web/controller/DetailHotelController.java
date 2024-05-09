package project.web.controller;

import org.springframework.web.bind.annotation.*;
import project.web.data.domain.City;
import project.web.data.dto.DetailHotelDTO;
import project.web.data.dto.PicDTO;
import project.web.data.dto.RecommendHotelDTO;
import project.web.data.dto.ShowReviewDTO;
import project.web.data.service.city.CityService;
import project.web.data.service.hotel.HotelService;
import project.web.data.service.review.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/detail")
public class DetailHotelController {
    private final HotelService hotelService;
    private final ReviewService reviewService;
    private final CityService cityService;

    public DetailHotelController(HotelService hotelService, ReviewService reviewService, CityService cityService) {
        this.hotelService = hotelService;
        this.reviewService = reviewService;
        this.cityService = cityService;
    }

    //    해당 호텔을 클릭시 호텔의 자세한 정보를 가져오기위한 메서드. 1개의 호텔의 정보를 가져옴
    @GetMapping(value = "/hotel")
    public DetailHotelDTO getHotel(@RequestParam Long hNum) {
        DetailHotelDTO detailHotelDTO = hotelService.getDetailHotel(hNum);

        return detailHotelDTO;
    }

//    해당 호텔의 사진을 얻기위한 메서드
    @GetMapping(value = "/hotel-picture")
    public List<PicDTO> getHotelPic(@RequestParam Long hNum) {
        List<PicDTO> hotelPicDTOS = hotelService.getHotelPic(hNum);

        return hotelPicDTOS;
    }

//    해당 호텔에 작성한 모든 리뷰를 보여주는 메서드
    @GetMapping(value = "/hotel-review")
    public List<ShowReviewDTO> getReview(@RequestParam Long hNum, int type) {
        List<ShowReviewDTO> reviews = reviewService.getReviewByHotel(hNum, type);

        return reviews;
    }

//    하나의 호텔에 들어갔을 때 같은 지역에 있는 호텔을 추천해주는 메서드
//    아직 지역만 추가함, 아직 별점, 비슷한 조건을 추가 못함
    @PostMapping(value = "/similar-hotel")
    public List<RecommendHotelDTO> getSimilarHotel(@RequestParam Long hNum) {
//        해당 호텔이 있는 지역을 가져오기위해 cityService 에서 해당 City 데이터를 가져옴
        City city = cityService.getCityInHotel(hNum);

        return hotelService.getSimilarHotel(city);
    }
}
