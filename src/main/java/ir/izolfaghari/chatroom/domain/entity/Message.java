package ir.izolfaghari.chatroom.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mybb_ajaxchat")
public class Message extends BaseEntity {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, nullable = false)
    private int uid;

    @Column(updatable = false, nullable = false)
    private Date date;

    @Column(name = "message", updatable = false, nullable = false)
    private String text;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
}
