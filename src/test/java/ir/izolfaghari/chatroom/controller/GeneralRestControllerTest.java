package ir.izolfaghari.chatroom.controller;

import ir.izolfaghari.chatroom.Startup;
import ir.izolfaghari.chatroom.domain.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@Transactional
@SpringApplicationConfiguration(classes = Startup.class)
@IntegrationTest("server.port:0")
@WebAppConfiguration
public class GeneralRestControllerTest {

    @Value("${local.server.port}")
    private int port;
    @Value("${server.contextPath}")
    private String contextPath;
    @Value("${ir.izolfaghari.chatroom.message.save}")
    private String urlMessageSave;
    @Value("${ir.izolfaghari.chatroom.message.load}")
    private String urlMessageLoad;

    private RestTemplate template = new TestRestTemplate();

    @Test
    public void saveTest() {
        int uid = 1390;
        String text = "chera rafti?";
        ResponseEntity<Long> response = saveMessage(uid, text);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Long id = response.getBody();
        assertNotNull(id);
        assertTrue(id > 0);
    }

    private ResponseEntity<Long> saveMessage(int uid, String text) {
        return template.getForEntity("http://localhost:" + port + contextPath +
                urlMessageSave, Long.class, uid, text);
    }

    @Test
    public void loadAllAfterIdTest() {
        int uid1 = 13901;
        String text1 = "chera rafti?_1";
        ResponseEntity<Long> response1 = saveMessage(uid1, text1);

        int uid2 = 13902;
        String text2 = "chera rafti?_2";
        ResponseEntity<Long> response2 = saveMessage(uid2, text2);

        int uid3 = 13903;
        String text3 = "chera rafti?_3";
        ResponseEntity<Long> response3 = saveMessage(uid3, text3);

        Long id = response2.getBody();
        assertNotNull(id);

        Message[] messages = template.getForObject("http://localhost:" + port + contextPath + urlMessageLoad,
                Message[].class, id);
        assertNotNull(messages);
        assertEquals(messages.length, 1);
        assertEquals(messages[0].getUid(), uid3);
        assertEquals(messages[0].getText(), text3);

    }
}
