package project.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.web.data.domain.Hotel;
import project.web.data.domain.Review;
import project.web.data.domain.User;
import project.web.data.dto.*;
import project.web.data.service.hotel.HotelService;
import project.web.data.service.reservation.ReservationService;
import project.web.data.service.review.ReviewService;
import project.web.data.service.user.UserService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@RequestMapping("/my-page")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
public class MyPageController {
    private static final String UPLOAD_DIR = "./uploads/";
    private final UserService userService;
    private final ReservationService reservationService;
    private final HotelService hotelService;
    private final ReviewService reviewService;

    public MyPageController(UserService userService, ReservationService reservationService, HotelService hotelService, ReviewService reviewService) {
        this.userService = userService;
        this.reservationService = reservationService;
        this.hotelService = hotelService;
        this.reviewService = reviewService;
    }

    public String sessionId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        return id;
    }

    @PostMapping(value = "/update-pw")
    public String updatePw(@RequestBody UpdatePwDTO updatePwDTO, HttpServletRequest request){
//        세션정보를 가져와 자신의 pw 를 변경
        String id = sessionId(request);
//        자신의 아이디와 변경 pw를 service에 넣어 pw 변경
        return userService.updatePw(updatePwDTO, id);
    }

    @GetMapping(value = "/user-info")
    public MyPageUserDTO getUserInfo(HttpServletRequest request){
//        세션정보를 가져와 해당 id에 해당하는 유저 정보를 가져옴
        String id = sessionId(request);

        MyPageUserDTO user = userService.getUserInfo(id);

        return user;
    }


    @GetMapping(value = "/res-info")
    public List<MyResInfoDTO> getResInfo(HttpServletRequest request) {
//        세션정보를 가져와 해당 id에 해당하는 예약정보를 가져옴
        String id = sessionId(request);

        return reservationService.getResInfo(id);
    }

    
    @PostMapping(value = "/res-delete")
    public String deleteRes(@RequestParam Long resNum) {
        // 예약 번호를 받아와 해당 예약일정을 삭제
        reservationService.deleteRes(resNum);
        return "삭제완료";

    }


    //    리뷰 작성 ( img x )
    @PostMapping(value = "/write-review")
    public String writeReview(@RequestParam Long hNum, @RequestBody ReviewDTO reviewDTO, HttpServletRequest request) {
        String id = sessionId(request);
        User user = userService.getUser(id);
        Hotel hotel = hotelService.getHotel(hNum);
//      리뷰 작성시에 user 정보와 hotel 정보를 얻기위해 각 service에서 정보를 얻어온 뒤 매개변수로 넘겨줌
        reviewService.insertReview(reviewDTO, user, hotel);


        return "리뷰작성성공";
    }

//    작성 리뷰 사진업로드 및 db 저장
    @PostMapping(value = "/insert-reviewImg")
    public String uploadReviewImg(@RequestBody List<MultipartFile> files, HttpServletRequest request) {
        String id = sessionId(request);
        User user = userService.getUser(id);
        List<String> url = new ArrayList<>();
        try {
            if (files.isEmpty()) {
                return "업로드 파일이 비었습니다.";
            }
            for (int i = 0; i < files.size(); i++) {
                if (!files.get(i).getContentType().startsWith("image/")) {
                    return "이미지 파일만 업로드할 수 있습니다.";
                }
                Path uploadDirPath = Paths.get(UPLOAD_DIR);
                if(!Files.exists(uploadDirPath)) {
                    Files.createDirectories(uploadDirPath);
                }

                Path path ;
                path = Paths.get(UPLOAD_DIR + files.get(i).getOriginalFilename());
                url.add(path.toString());
                Files.copy(files.get(i).getInputStream(), path);
            }
            reviewService.insertReviewPic(url, user);

            return "리뷰사진 업로드 성공";

        } catch (Exception e) {
            e.printStackTrace();
            return "업로드 에러 " + e.getMessage();
        }
    }

    //    리뷰 삭제
    @PostMapping(value = "/delete-review")
    public String deleteReview(@RequestParam Long revNum, HttpServletRequest request) {
        String id = sessionId(request);
        User user = userService.getUser(id);
//      자신이 작성한것인지 알기 위해 user 엔티티를 매개변수로 넘겨줌
        return reviewService.deleteReview(revNum, user);
    }

    @PostMapping(value = "/update-review")
    public String updateReview(@RequestParam Long revNum, @RequestBody ReviewDTO reviewDTO, HttpServletRequest request) {
        String id = sessionId(request);
        User user = userService.getUser(id);
        reviewService.updateReview(reviewDTO ,revNum, user);

        return "수정완료";
    }



}
