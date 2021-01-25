package com.example.TransportCompany.Models;

import java.util.List;

/**
 * This class represents an information about the transport industry in the whole world.
 * It is used for legalising new companies.
 * When they are added in @param transportCompanies they are legalised.
 *
 * @author svasilev
 * */
public class TransportIndustry
{
  private final List<TransportCompany> transportCompanies;

  public TransportIndustry(List<TransportCompany> transportCompanies)
  {
    this.transportCompanies = transportCompanies;
  }


  public void sortCompaniesByNameAndByCash()
  {
    this.transportCompanies.sort(TransportCompany.byName.thenComparing(TransportCompany.byCash));
  }

  public void addCompany(TransportCompany transportCompany)
  {
    transportCompanies.add(transportCompany);
  }

  public void deleteCompany(TransportCompany transportCompany)
  {
    transportCompanies.remove(transportCompany);
  }
}
