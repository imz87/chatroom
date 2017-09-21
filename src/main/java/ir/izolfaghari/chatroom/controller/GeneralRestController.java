package ir.izolfaghari.chatroom.controller;

import ir.izolfaghari.chatroom.domain.entity.Message;
import ir.izolfaghari.chatroom.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Iman Zolfaghari on 2017/06/27.
 */
@RestController
public class GeneralRestController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("${ir.izolfaghari.chatroom.message.save}")
    @ResponseBody
    public Long saveText(@PathVariable Integer uid, @PathVariable String text) {
        Message message = new Message();
        message.setUid(uid);
        message.setText(text);
        message.setDate((new Date()));
        Message message1 = messageService.save(message);
        return message1.getId();
    }

    @RequestMapping("${ir.izolfaghari.chatroom.message.load}")
    @ResponseBody
    public Message[] loadAllAfterId(@PathVariable Long id) {
        List<Message> messageList = messageService.loadAllAfterId(id);
        return messageList.toArray(new Message[messageList.size()]);
    }

}
