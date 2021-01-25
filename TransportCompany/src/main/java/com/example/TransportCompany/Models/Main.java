package com.example.TransportCompany.Models;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * A SMALL SCRIPT OF THE PROJECT
 *
 * @author svasilev F91532
 */
public class Main
{
  public static void main(String[] args)
  {

    List<TransportCompany> transportCompanyList = new ArrayList<>();
    TransportIndustry transportIndustry = new TransportIndustry(transportCompanyList);
    List<Employee> hiredEmployees = new ArrayList<>();
    List<Vehicle> ownVehicles = new ArrayList<>();
    List<Employee> hiredEmployees2 = new ArrayList<>();
    List<Vehicle> ownVehicles2 = new ArrayList<>();
    List<Client> clients = new ArrayList<>();
    List<Client> clients2 = new ArrayList<>();
    System.out.println("Добре дошли в света на транспортните компании!\n" +
        "Моля създайте вашата транспортна компания!\nИме: ");
    Scanner scanner = new Scanner(System.in);
    String nameOfTheCompany = scanner.nextLine();
    System.out.println("Какъв ще е вашият бюджет?:");
    double budget;
    do {
      System.out.println("Въведете число, по-голямо от 0!!!");
      budget = scanner.nextDouble();
    }
    while (budget <= 0);
    System.out.println("Честито, Вие създадохте първата си транспортна компания!" +
        "\nНейното име е:" + nameOfTheCompany + "\nВашият бюджет е: " + budget);
    TransportCompany company1 = new TransportCompany(nameOfTheCompany, hiredEmployees, ownVehicles
        , clients, budget);
    transportIndustry.addCompany(company1);

    System.out.println("Вашата компания е регистрирана като част от световната транспортна индустрия!");
    List<Transportation> transportationList = new ArrayList<>();
    Client client1 = new Client("StanchoOOD", transportationList,
        0, false, 70000.00);

    Employee driver1 = new Employee("Selim", 42, 15, TypeOfDriver.CE, 3000.00);
    Employee driver2 = new Employee("Ivan", 25, 5, TypeOfDriver.CE, 2700.00);
    company1.addEmployee(driver1);
    company1.addEmployee(driver2);
    Transportation transportation1 = new Transportation(client1, driver2, "Stutgard", "Eindhoven",
        LocalDateTime.of(2021, Month.APRIL, 3, 12, 15),
        LocalDateTime.of(2021, Month.MAY, 3, 12, 15),
        TypeOfCargo.OIL, 12000, false, "Stutgard-Eindhoven");
    Vehicle veh1 = new Vehicle(TypeOfVehicle.CISTERN, transportation1, 25000, "AAAAAA");
    company1.addVehicle(veh1);
    transportationList.add(transportation1);

    Transportation transportation2 = new Transportation(client1, driver1, "Sofiq", "Belasica",
        LocalDateTime.of(2021, Month.APRIL, 3, 12, 15), LocalDateTime.of(2021, Month.MAY, 3, 12, 15),
        TypeOfCargo.OIL, 7000, false, "Sofiq-Belasica");
    Vehicle veh2 = new Vehicle(TypeOfVehicle.CISTERN, transportation2, 19000, "A1999ВР");
    transportationList.add(transportation2);
    company1.addVehicle(veh2);
    System.out.println("\nТъй като сте новобранци в бизнеса, световната транспортна индустрия, " +
        "автоматично ще ви зададe 1 клиент и с негова помощ да генерирате първите си приходи :)!");
    System.out.println();
    company1.addClient(client1);
    System.out.println("Това е :" + client1 + "\n");

    client1.listNotPaidTransports();
    client1.payTransport(transportation1, company1);
    client1.listNotPaidTransports();
    client1.payTransport(transportation2, company1);
    System.out.println(company1.getProfit());

    System.out.println("\nПоказване на компаниите по име после по пари");
    TransportCompany transportCompany2 = new TransportCompany("IvanOOD", hiredEmployees2, ownVehicles2,
        clients2, 120000.00);
    transportCompanyList.add(transportCompany2);
    transportCompanyList.stream().sorted(Comparator.comparing(TransportCompany::getCompanyName)
        .thenComparing(TransportCompany::getCashRegister)).forEach(System.out::println);

    System.out.println("\nПоказване на компанията " + company1.getCompanyName() + " колко транспорта е направила: ");
    System.out.println(company1.getTransportationDone());
    System.out.println("\nПоказване на компанията " + transportCompany2.getCompanyName() + " колко приходи е направила: ");
    System.out.println(transportCompany2.getTransportationDone());

    System.out.println("Компанията " + company1.getCompanyName() + " e получила от нейните шофъори: ");
    company1.showProfitFromEachDriver();

    System.out.println("Автопарк на компания: " + company1.getCompanyName());
    company1.showCompanyGarage();

    System.out.println("Записване на информацията за автопарк във файл...");
    company1.writeInFile();
    System.out.println("Четене от файл, където се съдържа 'А'");
    company1.readFromFile();


  }
}
