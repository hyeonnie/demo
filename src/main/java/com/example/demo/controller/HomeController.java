package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final String topicName = "test";

    private final KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/kafka")
    public void kafka(String msg) {
        LocalDateTime date = LocalDateTime.now();
        String dateStr = date.format(fmt);
        kafkaTemplate.send(topicName, "8080 send " + dateStr + " : " + msg);
    }

    @KafkaListener(topics = topicName, groupId = "foo")
    public void listen(String message) {
        System.out.println("Received Msg jjjwodls " + message);
    }

    /**
     * groupId 를 다르게 하여 내용을 보여주기 위해 일부로 다르게 설정하였음.
     * @param headers header에 담긴 내용을 보여준다.
     * @param payload 넘어온 문자열에 대해 보여줌.
     */
    @KafkaListener(topics = topicName, groupId = "bar")
    public void listen2(@Headers MessageHeaders headers, @Payload String payload ) {
        System.out.println("=======================================");
        System.out.println("Consume Headers : " + headers.toString());
        System.out.println("=======================================");
        System.out.println("PayLoad : " + payload);
        System.out.println("=======================================");
    }

}
