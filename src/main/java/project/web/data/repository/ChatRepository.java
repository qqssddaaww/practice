package project.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.web.data.domain.Chat;
import project.web.data.dto.ChatConDTO;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    @Query(value = "select new project.web.data.dto.ChatConDTO(u.uName, n.nName, c.content, c.sender) from Chat c join c.user u join c.aNative n where c.user.uId = :uId and c.aNative.nId = :nId ")
    List<ChatConDTO> getMessages(String uId, String nId);

}