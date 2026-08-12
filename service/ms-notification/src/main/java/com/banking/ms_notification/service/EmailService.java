package com.banking.ms_notification.service;

import com.banking.ms_notification.amqp.event.CustomerStatus;
import com.banking.ms_notification.amqp.event.CustomerStatusUpdateEvent;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    private static final String FORM_EMAIL = "naoresponda@carraraodontologia.com.br";

    private String greeting() {

        LocalTime hour = LocalTime.now(Clock.systemDefaultZone());
        String messageHour;

        if (hour.isBefore(LocalTime.of(13, 0))) {
            messageHour = "Bom dia";
        } else if (hour.isBefore(LocalTime.of(19, 0))) {
            messageHour = "Boa tarde";
        } else {
            messageHour = "Boa noite";
        }

        return messageHour;
    }


    public void customerCreated(String to, String name) throws MessagingException, IOException {

        String messageHour = greeting();

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        String html = loadTemplate("customerCreated.html")
                .replace("{{saudacao}}", messageHour)
                .replace("{{nome}}", name);

        helper.setFrom(FORM_EMAIL);
        helper.setTo(to);
        helper.setSubject("Recebemos seu cadastro no Spring Bank");
        helper.setText(html, true);

        javaMailSender.send(message);
    }

    public void customerStatusUpdate(CustomerStatusUpdateEvent event) throws MessagingException, IOException {

        String messageHour = greeting();

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        if (event.status().equals(CustomerStatus.ACTIVE)) {
            String html = loadTemplate("CustomerApproved.html")
                    .replace("{{saudacao}}", messageHour)
                    .replace("{{nome}}", event.name());

            helper.setFrom(FORM_EMAIL);
            helper.setTo(event.email());
            helper.setSubject("Concluímos a análise da sua conta Spring Bank");
            helper.setText(html, true);

        } else if (event.status().equals(CustomerStatus.REJECTED)) {
            String html = loadTemplate("CustomerRejected.html")
                    .replace("{{saudacao}}", messageHour)
                    .replace("{{nome}}", event.name());

            helper.setFrom(FORM_EMAIL);
            helper.setTo(event.email());
            helper.setSubject("Concluímos a análise da sua conta Spring Bank");
            helper.setText(html, true);

        } else {

            return;
        }

        javaMailSender.send(message);
    }

    private String loadTemplate(String templateName) throws IOException {

        ClassPathResource resource = new ClassPathResource("templates/" + templateName);

        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
