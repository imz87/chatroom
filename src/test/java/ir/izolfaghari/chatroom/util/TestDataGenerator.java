package ir.izolfaghari.chatroom.util;

import ir.izolfaghari.chatroom.domain.entity.Message;

import java.util.Date;

/**
 * Created by Iman Zolfaghari on 2017/09/21.
 */
public class TestDataGenerator {
    public static Message createMessage(int uid) {
        Message message = new Message();
        message.setDate(new Date());
        message.setText("chera!!!");
        message.setUid(uid);
        return message;
    }

}
