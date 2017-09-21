package ir.izolfaghari.chatroom.service;

import ir.izolfaghari.chatroom.Startup;
import ir.izolfaghari.chatroom.domain.entity.Message;
import ir.izolfaghari.chatroom.util.TestDataGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Iman Zolfaghari on 2017/09/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@Transactional
@SpringApplicationConfiguration(classes = Startup.class)
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Test
    public void messageSaveTest() {
        Message message = TestDataGenerator.createMessage(1385);
        Message message1 = messageService.save(message);
        Assert.assertNotNull(message1);
        Assert.assertNotNull(message1.getId());
        Assert.assertTrue(message1.getId() > 0);
    }

    @Test
    public void loadAllAfterIdTest() {
        Message message1 = messageService.save(TestDataGenerator.createMessage(1379));
        Message message2 = messageService.save(TestDataGenerator.createMessage(1380));
        Message message3 = messageService.save(TestDataGenerator.createMessage(1381));

        List<Message> messageList = messageService.loadAllAfterId(message2.getId());

        Assert.assertNotNull(messageList);
        Assert.assertEquals(1, messageList.size());
        Assert.assertEquals(messageList.get(0).getId(), message3.getId());
    }

}
