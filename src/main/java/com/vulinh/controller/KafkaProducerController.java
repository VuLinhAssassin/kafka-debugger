package com.vulinh.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vulinh.service.KafkaProducerService;

import lombok.RequiredArgsConstructor;

/**
 * <p>
 * The Kakfa Producer controller bean. This class will allow application such as Postman to directly send a Kafka
 * message (with or without topic name).
 * </p>
 *
 * @author Nguyen Vu Linh
 */
@RestController
@RequestMapping("/kafka-message")
@RequiredArgsConstructor
public class KafkaProducerController {

    @PostMapping("/send")
    public Object sendMessage(@RequestParam(name = "topic",
                                            required = false) String topic,
                              @RequestBody String data) {
        return kafkaProducerService.sendMessage(topic, data);
    }

    private final KafkaProducerService kafkaProducerService;
}
