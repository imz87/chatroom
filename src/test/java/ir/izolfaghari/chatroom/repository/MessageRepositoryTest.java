package ir.izolfaghari.chatroom.repository;

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
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void messageSaveTest() {
        Message message = TestDataGenerator.createMessage(1379);
        Message message1 = messageRepository.save(message);
        Assert.assertNotNull(message1);
        Assert.assertNotNull(message1.getId());
        Assert.assertTrue(message1.getId() > 0);
        messageRepository.delete(message1);
    }

    @Test
    public void loadAllAfterIdTest() {
        Message message1 = messageRepository.save(TestDataGenerator.createMessage(1379));
        Message message2 = messageRepository.save(TestDataGenerator.createMessage(1380));
        Message message3 = messageRepository.save(TestDataGenerator.createMessage(1381));

        List<Message> messageList = messageRepository.loadAllAfterId(message2.getId());
        Assert.assertNotNull(messageList);
        Assert.assertEquals(1, messageList.size());
        Assert.assertEquals(messageList.get(0).getId(), message3.getId());
    }

}
