package com.vulinh.service;

import com.vulinh.utils.PropertyConstant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 * The Kafka Producer service bean.
 * </p>
 *
 * @author Nguyen Vu Linh
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Getter
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value(PropertyConstant.DEBUG_TOPIC)
    private String debugTopic;

    /**
     * <p>
     * Send a Kafka message to a specific topic.
     * </p>
     *
     * @param topic the topic to send message.
     * @param data  the message to send, in this case, a string.
     * @return something to the controller, indicates that the sending operation was successful.
     */
    public Object sendMessage(String topic, String data) {
        String destinationTopic = StringUtils.isBlank(topic) ? debugTopic : topic;
        kafkaTemplate.send(destinationTopic, data);
        log.info("Message sent to topic [{}]:\n\n{}", destinationTopic, data);
        return "OK";
    }

}
