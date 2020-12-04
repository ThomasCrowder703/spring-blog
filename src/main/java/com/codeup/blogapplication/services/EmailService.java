package com.codeup.blogapplication.services;


import com.codeup.blogapplication.models.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {
    @Autowired
    public JavaMailSender emailSender; //dependency injection

    @Value("${spring.mail.from}") //placeholder for app.prop
    private String from;

    public void prepareAndSend(Posts post, String subject, String body){
        SimpleMailMessage msg = new SimpleMailMessage(); //create message obj
        msg.setFrom(from); //set sender
        msg.setTo(post.getOwner().getEmail()); //set recipient
        msg.setSubject(subject); //subject
        msg.setText(body); //body

        try{
            this.emailSender.send(msg); //send the email
        }catch (MailException ex){
            System.err.println(ex.getMessage()); //catch error
        }
    }

}

