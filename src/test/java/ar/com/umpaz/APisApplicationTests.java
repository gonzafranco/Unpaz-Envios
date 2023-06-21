package ar.com.umpaz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import ar.com.umpaz.service.imp.EmailSenderImp;

import static org.mockito.Mockito.verify;

@SpringBootTest
class APisApplicationTests {

    @MockBean
    private JavaMailSender mailSender;

    @Autowired
    private EmailSenderImp emailSender;

    @Test
    void testEnviarMail() {
        String destinatario = "gonzafrancoandres@gmail.com";
        String asunto = "Test Email";
        String body = "nuevo mail.";

        emailSender.enviarMensaje(destinatario, asunto, body);

        SimpleMailMessage expectedMessage = new SimpleMailMessage();
        expectedMessage.setFrom(emailSender.getSenderEmail());
        expectedMessage.setTo(destinatario);
        expectedMessage.setSubject(asunto);
        expectedMessage.setText(body);

        verify(mailSender).send(expectedMessage);
    }
}
