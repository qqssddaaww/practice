package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.web.data.domain.NativePage;

public interface NativePageRepository extends JpaRepository<NativePage, Long> {
}
