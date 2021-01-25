package com.example.TransportCompany.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MailService
{
  private final MailSender mailSender;
  private final String     WELCOME_SUBJECT = "Congratulations on being part of the team!" +
      " The whole 'World of Transports' welcomes you and we look forward to a successful journey with you! Welcome aboard! ";


  @Autowired
  public MailService(MailSender mailSender)
  {
    this.mailSender = mailSender;
  }

  public void doSendMessage(String email)
  {
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo(email);
    simpleMailMessage.setText(WELCOME_SUBJECT);
    mailSender.send(simpleMailMessage);
  }

}
