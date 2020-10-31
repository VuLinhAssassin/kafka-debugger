package com.vulinh.frame;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vulinh.service.KafkaProducerService;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class KafkaDebugFrame extends JFrame {

    // Stupid Eclipse
    private static final long serialVersionUID = 848018704682881804L;
    // The bean required for this form here
    private final String debugTopic;
    private final transient KafkaProducerService kafkaProducerService;
    private final ObjectMapper objectMapper;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBeautify;
    private javax.swing.JButton buttonMinify;
    private javax.swing.JButton buttonSendMessage;
    private javax.swing.JCheckBox checkUseDebugTopic;
    private javax.swing.JCheckBox checkWordWrap;
    private javax.swing.JPanel panelFormat;
    private javax.swing.JPanel panelKafkaMessage;
    private javax.swing.JPanel panelKafkaTopic;
    private javax.swing.JPanel panelSend;
    private javax.swing.JScrollPane scrollPane1;
    private javax.swing.JTextArea textKafkaMessage;
    private javax.swing.JTextField textKafkaTopic;
    public KafkaDebugFrame(org.springframework.context.ConfigurableApplicationContext context) {
        initComponents();

        /*
         * Since the way to bind this class as a spring bean is not very elegant, we can use
         * ConfigurableApplicationContext object passed from main method to get the Spring bean we need.
         */
        kafkaProducerService = context.getBean(KafkaProducerService.class);
        debugTopic = kafkaProducerService.getDebugTopic();
        objectMapper = new ObjectMapper();

        /*
         * Some post-constructor variable assignment
         */
        textKafkaTopic.setText(debugTopic);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelKafkaTopic = new javax.swing.JPanel();
        textKafkaTopic = new javax.swing.JTextField();
        checkUseDebugTopic = new javax.swing.JCheckBox();
        panelKafkaMessage = new javax.swing.JPanel();
        scrollPane1 = new javax.swing.JScrollPane();
        textKafkaMessage = new javax.swing.JTextArea();
        checkWordWrap = new javax.swing.JCheckBox();
        panelFormat = new javax.swing.JPanel();
        buttonMinify = new javax.swing.JButton();
        buttonBeautify = new javax.swing.JButton();
        panelSend = new javax.swing.JPanel();
        buttonSendMessage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kafka Message Sender");

        panelKafkaTopic.setBorder(javax.swing.BorderFactory.createTitledBorder("Kafka topic"));

        textKafkaTopic.setEditable(false);

        checkUseDebugTopic.setSelected(true);
        checkUseDebugTopic.setText("Use default topic");
        checkUseDebugTopic.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkUseDebugTopicMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelKafkaTopicLayout = new javax.swing.GroupLayout(panelKafkaTopic);
        panelKafkaTopic.setLayout(panelKafkaTopicLayout);
        panelKafkaTopicLayout.setHorizontalGroup(panelKafkaTopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textKafkaTopic)
            .addGroup(panelKafkaTopicLayout.createSequentialGroup()
                .addComponent(checkUseDebugTopic)
                .addGap(0, 0,
                    Short.MAX_VALUE)));
        panelKafkaTopicLayout.setVerticalGroup(panelKafkaTopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKafkaTopicLayout.createSequentialGroup()
                .addComponent(textKafkaTopic,
                    javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkUseDebugTopic)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                    Short.MAX_VALUE)));

        panelKafkaMessage.setBorder(javax.swing.BorderFactory.createTitledBorder("Kafka message (text)"));

        textKafkaMessage.setColumns(20);
        textKafkaMessage.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        textKafkaMessage.setRows(5);
        scrollPane1.setViewportView(textKafkaMessage);

        checkWordWrap.setText("Word wrap");
        checkWordWrap.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkWordWrapMouseClicked(evt);
            }
        });

        panelFormat.setBorder(javax.swing.BorderFactory.createTitledBorder("Format JSON"));
        panelFormat.setLayout(new java.awt.GridLayout(1, 0));

        buttonMinify.setText("Minify!");
        buttonMinify.addActionListener(this::buttonMinifyActionPerformed);
        panelFormat.add(buttonMinify);

        buttonBeautify.setText("Beautify!");
        buttonBeautify.addActionListener(this::buttonBeautifyActionPerformed);
        panelFormat.add(buttonBeautify);

        javax.swing.GroupLayout panelKafkaMessageLayout = new javax.swing.GroupLayout(panelKafkaMessage);
        panelKafkaMessage.setLayout(panelKafkaMessageLayout);
        panelKafkaMessageLayout.setHorizontalGroup(panelKafkaMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane1)
            .addComponent(panelFormat,
                javax.swing.GroupLayout.DEFAULT_SIZE, 538,
                Short.MAX_VALUE)
            .addGroup(panelKafkaMessageLayout.createSequentialGroup()
                .addComponent(checkWordWrap)
                .addGap(0, 0,
                    Short.MAX_VALUE)));
        panelKafkaMessageLayout.setVerticalGroup(panelKafkaMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKafkaMessageLayout.createSequentialGroup()
                .addComponent(checkWordWrap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane1,
                    javax.swing.GroupLayout.DEFAULT_SIZE,
                    414,
                    Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFormat,
                    javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)));

        panelSend.setBorder(javax.swing.BorderFactory.createTitledBorder("Send message here"));
        panelSend.setLayout(new java.awt.GridLayout(1, 0));

        buttonSendMessage.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        buttonSendMessage.setText("Send message!");
        buttonSendMessage.addActionListener(this::buttonSendMessageActionPerformed);
        panelSend.add(buttonSendMessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelKafkaMessage, javax.swing.GroupLayout.Alignment.TRAILING,
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
            .addComponent(panelKafkaTopic, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelSend, javax.swing.GroupLayout.Alignment.TRAILING,
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelKafkaTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelKafkaMessage, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSend, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                    javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkUseDebugTopicMouseClicked(java.awt.event.MouseEvent evt) {
        showLog(evt);
        boolean isSelected = checkUseDebugTopic.isSelected();
        textKafkaTopic.setEditable(!isSelected);
        textKafkaTopic.setText(isSelected ? debugTopic : StringUtils.EMPTY);
    }
    // End of variables declaration//GEN-END:variables

    private void buttonSendMessageActionPerformed(java.awt.event.ActionEvent evt) {
        showLog(evt);
        kafkaProducerService.sendMessage(textKafkaTopic.getText(), textKafkaMessage.getText());
    }

    private void buttonBeautifyActionPerformed(java.awt.event.ActionEvent evt) {
        showLog(evt);
        formatJson(textKafkaMessage, true);
    }

    private void checkWordWrapMouseClicked(java.awt.event.MouseEvent evt) {
        showLog(evt);
        textKafkaMessage.setLineWrap(checkWordWrap.isSelected());
    }

    private void buttonMinifyActionPerformed(java.awt.event.ActionEvent evt) {
        showLog(evt);
        formatJson(textKafkaMessage, false);
    }

    // Some utility methods here
    private void formatJson(JTextArea source, boolean isBeautiful) {
        try {
            JsonNode jsonNode = objectMapper.readTree(source.getText());
            source.setText(isBeautiful ? jsonNode.toPrettyString() : jsonNode.toString());
        } catch (JsonProcessingException ex) {
            log.error("Error while parsing JSON:", ex);
            showError("Not a valid JSON message!");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Make some stupid logging
    private void showLog(java.awt.AWTEvent event) {
        log.info("Source: 0x{}", Integer.toHexString(event.getSource().hashCode()).toUpperCase());
    }

}
