package com.vulinh.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.vulinh.utils.PropertyConstant;

/**
 * Kafka Producer configuration. This class will define all Kafka's required beans to operate Kafka Producer.
 *
 * @author Nguyen Vu Linh
 */
@Configuration
public class KafkaProducerConfig {

    /**
     * <p>
     * Define ProducerFactory bean.
     * </p>
     *
     * @return the ProducerFactory bean object managed by Spring IoC container.
     * @throws ClassNotFoundException
     *             if the class canonical name is wrong, or the program lacks required libraries.
     */
    @Bean
    public ProducerFactory<String, String> kafkaProducerFactory() throws ClassNotFoundException {
        Map<String, Object> kafkaConfigMap = new HashMap<>();
        kafkaConfigMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        kafkaConfigMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Class.forName(keySerializerClassName));
        kafkaConfigMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Class.forName(valueSerializerClassName));
        return new DefaultKafkaProducerFactory<>(kafkaConfigMap);
    }

    /**
     * <p>
     * Define KafkaTemplate bean.
     * </p>
     *
     * @return the KafkaTemplate bean object managed by Spring IoC.
     * @throws ClassNotFoundException
     *             if the class canonical name is wrong or lack required library.
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() throws ClassNotFoundException {
        return new KafkaTemplate<>(kafkaProducerFactory());
    }

    @Value(PropertyConstant.PRODUCER_KEY_SERIALIZER)
    private String keySerializerClassName;

    @Value(PropertyConstant.PRODUCER_VALUE_SERIALIZER)
    private String valueSerializerClassName;

    @Value(PropertyConstant.BOOTSTRAP_SERVERS)
    private String bootstrapServers;

}
