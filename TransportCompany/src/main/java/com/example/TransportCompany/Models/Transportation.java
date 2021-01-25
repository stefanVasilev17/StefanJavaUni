package com.example.TransportCompany.Models;


import java.time.LocalDateTime;

/**
 * This class represents an information about the transportions
 * ALL OF THE NAMES OF THE METHODS REPRESENTS WHAT THEY DO.
 * @author svasilev
 * */
public class Transportation
{
  private String        owner;
  private String        start;
  private String        finish;
  private LocalDateTime departDate;
  private LocalDateTime arriveDate;
  private TypeOfCargo   typeOfCargo;
  private double        amount;
  private boolean       isPaid;
  private String        destination;

  /**
   * It is a constructor of Transportation.
   * The driver's count of transportations inceased by 1.
   * The driver's profit is also increased by the amount of the transportation.
   * */
  public Transportation(Client owner, Employee driver, String start, String finish, LocalDateTime departDate,
                        LocalDateTime arriveDate, TypeOfCargo typeOfCargo, double amount,
                        boolean isPaid, String destination)
  {
    this.owner = owner.getName();
    driver.setProfitFromEmployee(driver.getProfitFromEmployee() + amount);
    driver.getNumberOfTransportations().incrementAndGet();
    this.start = start;
    this.finish = finish;
    this.departDate = departDate;
    this.arriveDate = arriveDate;
    this.typeOfCargo = typeOfCargo;
    this.amount = amount;
    this.isPaid = isPaid;
    this.destination = destination;
  }

  public String getDestination()
  {
    return destination;
  }

  public String getOwner()
  {
    return owner;
  }

  public void setOwner(String owner)
  {
    this.owner = owner;
  }

  public void setDestination(String destination)
  {
    this.destination = destination;
  }

  public boolean isPaid()
  {
    return isPaid;
  }

  public void setPaid(boolean paid)
  {
    isPaid = paid;
  }

  public double getAmount()
  {
    return amount;
  }

  public void setAmount(double amount)
  {
    this.amount = amount;
  }

  @Override
  public String toString()
  {
    return "Transportation{" +
        "owner='" + owner + '\'' +
        ", start='" + start + '\'' +
        ", finish='" + finish + '\'' +
        ", departDate=" + departDate +
        ", arriveDate=" + arriveDate +
        ", typeOfCargo=" + typeOfCargo +
        ", amount=" + amount +
        ", isPaid=" + isPaid +
        ", destination='" + destination + '\'' +
        '}';
  }
}

