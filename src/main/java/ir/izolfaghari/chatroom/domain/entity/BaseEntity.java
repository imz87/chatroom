package ir.izolfaghari.chatroom.domain.entity;

/**
 * Created by iman on 2/22/16.
 */

public abstract class BaseEntity {

    public abstract Long getId();

    public abstract void setId(Long id);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getId() == null || getClass() != o.getClass()) return false;
        BaseEntity baseEntity = (BaseEntity) o;
        return getId().equals(baseEntity.getId());
    }


    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + getId() +
                '}';
    }
}
