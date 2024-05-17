package project.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.web.data.domain.City;
import project.web.data.domain.NativePage;
import project.web.data.domain.Room;
import project.web.data.domain.User;
import project.web.data.dto.*;
import project.web.data.service.NativePage.NativePageService;
import project.web.data.service.city.CityService;
import project.web.data.service.hotel.HotelService;
import project.web.data.service.reservation.ReservationService;
import project.web.data.service.review.ReviewService;
import project.web.data.service.room.RoomService;
import project.web.data.service.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/detail")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
public class DetailHotelController {
    private final HotelService hotelService;
    private final ReviewService reviewService;
    private final CityService cityService;
    private final RoomService roomService;
    private final UserService userService;
    private final NativePageService nativePageService;
    private final ReservationService reservationService;



    //    해당 호텔을 클릭시 호텔의 자세한 정보를 가져오기위한 메서드. 1개의 호텔의 정보를 가져옴
    @PostMapping(value = "/hotel")
    public DetailHotelDTO getHotel(@RequestParam Long hNum) {
        DetailHotelDTO detailHotelDTO = hotelService.getDetailHotel(hNum);

        return detailHotelDTO;
    }

//    해당 호텔의 사진을 얻기위한 메서드
    @PostMapping(value = "/hotel-picture")
    public List<PicDTO> getHotelPic(@RequestParam Long hNum) {
        List<PicDTO> hotelPicDTOS = hotelService.getHotelPic(hNum);

        return hotelPicDTOS;
    }

//    해당 호텔에 작성한 모든 리뷰를 보여주는 메서드
//    type은 정렬 순서를 정함, ex) 1 -> 날짜순 2 -> 별점순 등등 더 추가 가능
    @GetMapping(value = "/hotel-review")
    public List<ShowReviewDTO> getReview(@RequestParam Long hNum, @RequestParam(defaultValue = "1") int type) {
        List<ShowReviewDTO> reviews = reviewService.getReviewByHotel(hNum, type);

        return reviews;
    }

//    하나의 호텔에 들어갔을 때 같은 지역에 있는 호텔을 추천해주는 메서드
//    아직 지역만 추가함 -> 별점, 비슷한 조건을 추가 못함
    @PostMapping(value = "/similar-hotel")
    public List<RecommendHotelDTO> getSimilarHotel(@RequestParam Long hNum) {
//        해당 호텔이 있는 지역을 가져오기위해 cityService 에서 해당 City 데이터를 가져옴
        City city = cityService.getCityInHotel(hNum);

        return hotelService.getSimilarHotel(city);
    }

//    해당 호텔에 현지인이 올린 room을 전부 가져옴
    @PostMapping(value = "/room")
    public List<ShowRoomDTO> getRoomByHotel(@RequestParam Long hNum) {
        return roomService.getAllRoom(hNum);
    }

//    예약하기
    @PostMapping(value = "/reservation")
    public String reservation(HttpServletRequest request, Long paNum) {
        HttpSession session = request.getSession();
//        로그인 정보가 없다면 오류(문자열)을 리턴
        if (session.getAttribute("id") == null) {
            return "로그인 정보가 없습니다. ";
        } else {
//            로그인 정보가 있다면 user 정보를 가져오고 예약하려는 상품을 올린 nativePage의 정보를 가져옴
            String id = (String) session.getAttribute("id");
            User user = userService.getUser(id);
            NativePage nativePage = nativePageService.getNp(paNum);
//            예약서비스에 user정보와 nativePage의 정보를 주며 예약 db에 저장
            reservationService.insertRes(user, nativePage);
//            해당 상품이 예약되면 nativePage - paRes 를 ture로 변경하여 다른 유저에게 안보이게 함
            nativePageService.updateResG(paNum);
        }

        return "예약 완료";
    }

}
