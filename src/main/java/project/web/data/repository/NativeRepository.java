package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.web.data.domain.Native;

public interface NativeRepository extends JpaRepository<Native, Long> {

    Native findBynId(String id);
    Boolean existsBynId(String id);
    Boolean existsBynEmail(String email);
    Boolean existsBynPhone(String phone);
}
