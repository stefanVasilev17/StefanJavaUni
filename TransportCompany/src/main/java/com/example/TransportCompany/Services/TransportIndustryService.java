package com.example.TransportCompany.Services;

import com.example.TransportCompany.DAOs.TransportIndustryDAO;
import com.example.TransportCompany.Models.TransportCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportIndustryService
{

  private TransportIndustryDAO transportIndustryDAO;
  private MailService          mailService;

  @Autowired
  public TransportIndustryService(TransportIndustryDAO transportIndustryDAO, MailService mailService)
  {
    this.transportIndustryDAO = transportIndustryDAO;
    this.mailService = mailService;
  }

  public void insertTransportCompany(String name, String email)
  {
    transportIndustryDAO.insertNewCompany(name, email);
    mailService.doSendMessage(email);
  }

  public List<TransportCompany> getCompanyInfoByMail(String mail)
  {
    return transportIndustryDAO.getCompanyInfoByMail(mail);
  }

}
