package com.example.TransportCompany.Recources;

import com.example.TransportCompany.Models.TransportCompany;
import com.example.TransportCompany.Services.TransportIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * This is the rest controller of TransportIndustry's classes
 *
 * @author svasilev
 */
@RestController
public class TransportIndustryResource
{
  TransportIndustryService transportIndustryService;

  @Autowired
  public TransportIndustryResource(TransportIndustryService transportIndustryService)
  {
    this.transportIndustryService = transportIndustryService;
  }

  @PostMapping("/createCompany")
  @ResponseStatus(HttpStatus.CREATED)
  public void createCompany(@RequestParam("companyName") String companyName,
                            @RequestParam("email") String email)
  {
    transportIndustryService.insertTransportCompany(companyName, email);
  }

  @GetMapping("/getAllCompanies")
  @ResponseStatus(HttpStatus.OK)
  public List<TransportCompany> getCompanyInfoByMail(@RequestParam("email") String email)
  {
    return transportIndustryService.getCompanyInfoByMail(email);
  }
}
