package project.web.data.service.review;

import project.web.data.domain.Hotel;
import project.web.data.domain.User;
import project.web.data.dto.ReviewDTO;
import project.web.data.dto.ShowReviewDTO;

import java.util.List;

public interface ReviewService {

    List<ShowReviewDTO> getReviewByHotel(Long hNum, int type);
    void insertReview(ReviewDTO reviewDTO, User user, Hotel hotel);
    String deleteReview(Long revNum, User user);
    void insertReviewPic(List<String> url, User user);
}
