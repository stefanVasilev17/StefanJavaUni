package com.example.TransportCompany.Models;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


/**
 * This is a class which represents an information about Transport company.
 *
 * @author svasilev
 * */

public class TransportCompany implements Comparable<TransportCompany>
{
  private String         companyName;
  private List<Employee> hiredEmployees;
  private List<Vehicle>  ownVehicles        = new ArrayList<>();
  //private List<String>   licenceOfVehicles  = new ArrayList<>();
  private List<Client>   clients;
  private Double         cashRegister       = 0.00;
  private AtomicInteger  transportationDone = new AtomicInteger(0);
  private double         profit             = 0.00;
  private String email;

  public TransportCompany(String companyName)
  {
    this.companyName = companyName;
  }

  public TransportCompany()
  {
  }

  public TransportCompany(String companyName, List<Employee> hiredEmployees, List<Vehicle> ownVehicles, List<Client> clients, Double cashRegister)
  {
    this.companyName = companyName;
    this.hiredEmployees = hiredEmployees;
    this.ownVehicles = ownVehicles;
    this.clients = clients;
    this.cashRegister = cashRegister;
  }

  /**
   * This is a method for receiving money from client.
   * @param money
   * */
  public void recieveMoney(double money)
  {
    profit += money;
  }

  /**
   * This is a method for writing in file with name filename.txt.
   * It saves a vehicles which are owned by the company.
   * When there is an error, it throws an exception and prints the stackTrace.
   */
  public void writeInFile()
  {
    try {
      FileWriter myWriter = new FileWriter("filename.txt");
      for (Vehicle veh1 : ownVehicles) {
        myWriter.write(String.valueOf(veh1));
      }
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    }
    catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  /**
   * This is a method for reading from file with name filename.txt.
   * It gets an information where in the record have 'A'.
   * When there is an error, it throws an exception and print the stackTrace.
   */
  public void readFromFile()
  {
    List<String> fileLines = null;
    try {
      fileLines = Files.lines(Paths.get("filename.txt"))
          .filter(a -> a.contains("A"))
          .collect(Collectors.toList());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    fileLines.forEach(a -> System.out.println(a));
  }

  public static Comparator<Transportation>   byDestination = new Comparator<Transportation>()
  {
    @Override
    public int compare(Transportation comp1, Transportation comp2)
    {
      return comp1.getDestination().compareTo(comp2.getDestination());
    }
  };
  public static Comparator<TransportCompany> byName        = new Comparator<TransportCompany>()
  {
    @Override
    public int compare(TransportCompany comp1, TransportCompany comp2)
    {
      return comp1.companyName.compareTo(comp2.companyName);
    }
  };

  public static Comparator<TransportCompany> byCash = new Comparator<TransportCompany>()
  {
    @Override
    public int compare(TransportCompany comp1, TransportCompany comp2)
    {
      return comp1.cashRegister.compareTo(comp2.cashRegister);
    }
  };

  @Override
  public int compareTo(TransportCompany company)
  {
    return this.companyName.compareTo(company.companyName);
  }

  /**
   * FROM HERE TILL THE END, THE NAMES ON THE METHODS REPRESENTS WHAT THEY DO.
   * */
  public void addClient(Client client)
  {
    System.out.println("Вече работите с клиент: " + client.getName());
    clients.add(client);
  }

  public void deleteClient(Client c)
  {
    clients.remove(c);
  }

  public void addVehicle(Vehicle vehicle)
  {
    System.out.println("Това превозно средство е на ваше разположение: " + vehicle);
    ownVehicles.add(vehicle);
  }

  public AtomicInteger getTransportationDone()
  {
    return transportationDone;
  }

  public void showCompanyGarage()
  {
    ownVehicles.forEach(System.out::println);
  }

  public void showProfitFromEachDriver()
  {
    hiredEmployees.forEach(System.out::println);
  }

  public void addEmployee(Employee e)
  {
    System.out.println("Присъеденихте нов шофъор към вашата компания! Това е " + e);
    hiredEmployees.add(e);
  }

  public void deleteEmployee(Employee e)
  {
    System.out.println("Вие уволнихте : " + e);
    hiredEmployees.remove(e);
  }


  public String getCompanyName()
  {
    return companyName;
  }

  public void setCompanyName(String companyName)
  {
    this.companyName = companyName;
  }

  public Double getCashRegister()
  {
    return cashRegister;
  }

  public void setCashRegister(Double cashRegister)
  {
    this.cashRegister = cashRegister;
  }

  public double getProfit()
  {
    System.out.println("Вашите приходи досега са: ");
    return profit;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  @Override
  public String toString()
  {
    return "TransportCompany{" +
        "companyName='" + companyName + '\'' +
        ", hiredEmployees=" + hiredEmployees +
        ", ownVehicles=" + ownVehicles +
        ", clients=" + clients +
        ", cashRegister=" + cashRegister +
        ", transportationsDone=" + transportationDone +
        " profit = " + profit +
        '}';
  }
}

