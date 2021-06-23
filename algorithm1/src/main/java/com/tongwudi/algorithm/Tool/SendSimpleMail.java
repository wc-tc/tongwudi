package com.tongwudi.algorithm.Tool;

import com.sun.org.slf4j.internal.LoggerFactory;
import com.tongwudi.algorithm.bean.SimpleEmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;




@Component
public class SendSimpleMail {
    @Autowired
    private  JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private   String from;
    @Async
    public   void sendSimpleMail(SimpleEmailEntity simpleEmailEntity)   {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setSubject(simpleEmailEntity.getSubject());
        message.setText(simpleEmailEntity.getContent());
        message.setTo(simpleEmailEntity.getTos());
        mailSender.send(message);
        try {
            Thread.sleep(10000);  //1000毫秒就是1秒
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
