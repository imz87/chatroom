package ir.izolfaghari.chatroom;

import ir.izolfaghari.chatroom.security.WebSecurityConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by Iman Zolfaghari on 2017/09/21.
 */
@SpringBootApplication
@PropertySource(value = "classpath:application.properties")
public class Startup {


    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
    }

    @Configuration
    @EnableWebSecurity
    @Order(-20)
    public static class WebSecurityConfigurer1 extends WebSecurityConfigurer {
    }
}
