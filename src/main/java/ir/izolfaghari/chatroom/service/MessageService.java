package ir.izolfaghari.chatroom.service;

import ir.izolfaghari.chatroom.domain.entity.Message;

import java.util.List;

/**
 * Created by iman on 2/24/16.
 */

public interface MessageService {
    Message save(Message message);

    List<Message> loadAllAfterId(Long id);
}
