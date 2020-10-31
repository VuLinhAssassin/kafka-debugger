package com.vulinh.utils;

import lombok.experimental.UtilityClass;

/**
 * <p>
 * This "utility" class contains constants that hold the key names from application.yaml. It uses
 * <code>@UtilityClass</code> from lombok, so everything here will be static. It might look different in bytecode
 * though.
 * </p>
 *
 * @author Nguyen Vu Linh
 */
@UtilityClass
public class PropertyConstant {

    /**
     * <p>
     * Kafka Bootstrap Server key name.
     * </p>
     */
    public final String BOOTSTRAP_SERVERS = "${app.kafka.bootstrap-servers}";
    /**
     * <p>
     * Kafka debug topic key name (the default topic when the request does not contain "topic" parameter).
     * </p>
     */
    public final String DEBUG_TOPIC = "${app.kafka.debug-topic}";
    /**
     * <p>
     * Kafka Producer's Key Serializer class key name.
     * </p>
     */
    public final String PRODUCER_KEY_SERIALIZER = "${app.kafka.producer.key-serializer}";
    /**
     * <p>
     * Kafka Producer's Value Serializer class key name.
     * </p>
     */
    public final String PRODUCER_VALUE_SERIALIZER = "${app.kafka.producer.value-serializer}";

}
