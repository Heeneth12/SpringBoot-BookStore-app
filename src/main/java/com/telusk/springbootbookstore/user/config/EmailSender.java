package com.telusk.springbootbookstore.user.config;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


@Component
public class EmailSender {

    @Autowired
    private Environment environment;

    public  void sendEmail(String name,String to , String subject, String body  ) {
        // Sender's email ID and password
        final String username = "heeneth123@gmail.com";
//      final String password = "qwlv qeab pria mrul";

        String password = environment.getProperty("your.application.password");
//        System.out.println("Password: " + password);

        String subjectTest =  name +" "+ subject ;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field
            message.setFrom(new InternetAddress(username));

            // Set To: header field
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(subjectTest );

            // Set the actual message
            message.setText(body);

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
