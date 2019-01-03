package com.rjxz.xykd.service.impl;

import com.rjxz.xykd.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendRichEmail(String to, String msg) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("hsxywwj@sina.com");
        helper.setTo(to);
        helper.setSubject("校园快递");
        helper.setText(msg);
        mailSender.send(message);
    }

    public boolean codeVerify(String code,String trueCode){
        return  trueCode.equals(code);
    }
}
