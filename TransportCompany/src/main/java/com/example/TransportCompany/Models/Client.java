package com.example.TransportCompany.Models;

import java.util.List;

public class Client
{
  private String               name;
  private List<Transportation> transports;
  private double               haveToPay   = 0.00;
  private Boolean              isPaid;
  private double               clientMoney = 0.00;

  public Client(String name, List<Transportation> transports, double haveToPay, Boolean isPaid, double clientMoney)
  {
    this.name = name;
    this.transports = transports;
    this.haveToPay = haveToPay;
    this.isPaid = isPaid;
    this.clientMoney = clientMoney;
  }

  /**
   * This method lists the transport which are not paid(understood from it's name)
   * */
  public void listNotPaidTransports()
  {
    for (Transportation transportation : transports) {
      if (!transportation.isPaid()) {
        System.out.println("Клиентът има да ви заплати: ");
        System.out.println(transportation.getAmount());
      }
      else {
        System.out.println("Клиентът е заплатил всичко!");
      }
    }
  }

/**
 * This method pays the transport which the client have to pay.
 * @param transport - an object of class Transportion,
 * @param transportCompany - an object of class TransportCompany
 *
 * When it is paid the number ot tranportation's which are done is increased by 1.
 *
 *
 * */
  public void payTransport(Transportation transport, TransportCompany transportCompany)
  {
    if (this.clientMoney >= transport.getAmount() && transport.getAmount() > 0) {
      clientMoney -= transport.getAmount();
      transportCompany.recieveMoney(transport.getAmount());
      System.out.println("Клиентът " + name + " Ви заплати " + transport.getAmount());
      transport.setAmount(0.00);
      transports.remove(transport);
      transportCompany.getTransportationDone().incrementAndGet();
      transport.setPaid(true);
    }
    else {
      System.out.println("Access denied");
    }
  }

  public String getName()
  {
    return name;
  }


  @Override
  public String toString()
  {
    return "Client{" +
        "name='" + name + '\'' +
        ", transports=" + transports +
        ", clientMoney=" + clientMoney +
        '}';
  }
}
