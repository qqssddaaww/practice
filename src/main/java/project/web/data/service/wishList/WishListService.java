package project.web.data.service.wishList;

import project.web.data.domain.User;
import project.web.data.dto.WishListDTO;

import java.util.List;

public interface WishListService {
    List<WishListDTO> getWishList(String id);
}
