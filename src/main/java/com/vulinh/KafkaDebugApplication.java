package com.vulinh;

import com.vulinh.frame.KafkaDebugFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * The Main class of Spring Boot application.
 *
 * @author Nguyen Vu Linh
 */
@SpringBootApplication
@Slf4j
public class KafkaDebugApplication {

    /**
     * <p>
     * The main method. The passed argument can be used to change some of the application's properties listed in application.properties file. Ideal if you want
     * to deploy a stand-alone application that anyone with JVM (version 8 or above) can just run anywhere.
     * </p>
     * <p>
     * For example, if you wish to change Kafka's bootstrap server, just type in the command line:
     * </p>
     *
     * <pre>
     * --app.kafka.bootstrap-servers=[address:port]
     * </pre>
     * <p>
     * For example:
     * </p>
     *
     * <pre>
     * java -jar KafkaDebugApplication --app.kakfa.boostrap-servers=192.168.0.100:9092
     * </pre>
     * <p>
     * <code>KafkaDebugApplication</code>: the name of this app's jar package.
     * </p>
     * <p>
     * By default, this address will be set to <code>localhost:9092</code>, as if you are running Kafka in your local computer.
     * </p>
     * <p>
     * <p>
     * To enable Windows Look And Feel, just add Use-Windows-Look-And-Feel argument. This should not conflict with Spring arguments in any way.
     * </p>
     *
     * @param args the array that contains list of argument passed via command line.
     */
    public static void main(String... args) {

        /*
         * Retrive application context to use Spring Bean
         */
        ConfigurableApplicationContext applicationContext =
            new SpringApplicationBuilder(KafkaDebugApplication.class).headless(false)
                .run(args);

        for (String arg : args) {
            if ("Windows-Look-And-Feel".equals(arg)) {
                log.info("Trying to init Windows Look And Feel...");
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (ClassNotFoundException ex) {
                    log.error("WindowsLookAndFeel class not found!", ex);
                } catch (InstantiationException ex) {
                    log.error("WindowsLookAndFeel cannot be initialized!", ex);
                } catch (IllegalAccessException ex) {
                    log.error("Illegal access error:", ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    log.error("WindowsLookAndFeel not supported on your platform!", ex);
                }
                break;
            }
        }

        /*
         * Display the GUI in Windows Look And Feel
         */
        KafkaDebugFrame frame = new KafkaDebugFrame(applicationContext);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
