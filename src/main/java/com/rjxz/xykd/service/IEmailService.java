package com.rjxz.xykd.service;


import javax.mail.MessagingException;

public interface IEmailService {

    void sendRichEmail(String to, String msg) throws MessagingException;


}
