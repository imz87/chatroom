package ir.izolfaghari.chatroom.repository;

import ir.izolfaghari.chatroom.domain.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by iman on 2/27/16.
 */
@NoRepositoryBean
public interface MyJpaRepository<E extends BaseEntity> extends JpaRepository<E, Long> {
}
