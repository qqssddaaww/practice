package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.NativePage;
import java.util.List;

public interface NativePageRepository extends JpaRepository<NativePage, Long> {

    @Query("select np from NativePage np where np.paNum = :paNum")
    NativePage findNp(Long paNum);

}
