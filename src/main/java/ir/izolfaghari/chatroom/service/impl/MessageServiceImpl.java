package ir.izolfaghari.chatroom.service.impl;

import ir.izolfaghari.chatroom.domain.entity.Message;
import ir.izolfaghari.chatroom.repository.MessageRepository;
import ir.izolfaghari.chatroom.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by iman on 2/24/16.
 */
@Service
public class MessageServiceImpl extends BaseServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message save(Message message) {
        log.info("Saving message : " + message);
        return messageRepository.save(message);
    }

    @Override
    public List<Message> loadAllAfterId(Long id) {
        log.info("Loading messages with id after " + id);
        List<Message> messageList = messageRepository.loadAllAfterId(id);
        log.info("Loaded messages with id after " + id + " is : " + messageList);
        return messageList;
    }

}
