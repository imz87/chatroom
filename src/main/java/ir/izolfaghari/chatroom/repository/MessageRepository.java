package ir.izolfaghari.chatroom.repository;

import ir.izolfaghari.chatroom.domain.entity.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends MyJpaRepository<Message> {

    @Query("SELECT c FROM Message c WHERE c.id > :id")
    List<Message> loadAllAfterId(@Param("id") Long id);

}