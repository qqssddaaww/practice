package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.WishList;
import project.web.data.dto.WishListDTO;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    @Query("select new project.web.data.dto.WishListDTO(np.paNum, h.hName, r.rName, hp.hPicUrl) " +
            "from WishList w join w.user u join w.nativePage np join np.room r join r.hotel h join h.hotelPictureList hp " +
            "where u.uId = :uId")
    List<WishListDTO> getWishListByuId(String uId);
}
