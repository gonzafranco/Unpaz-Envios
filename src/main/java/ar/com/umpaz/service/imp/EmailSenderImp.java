package ar.com.umpaz.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ar.com.umpaz.service.MensajeService;

@Service
public class EmailSenderImp  implements MensajeService{
    
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remitente;

    @Override
    public void enviarMensaje(String destinatario, String asunto, String body) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom(remitente);
        mensaje.setTo(destinatario);
        mensaje.setSubject(asunto);
        mensaje.setText(body);

        mailSender.send(mensaje);

        System.out.println("Se envió el mail");
    }

    public String getSenderEmail() {
        return remitente;
    }

  
}
