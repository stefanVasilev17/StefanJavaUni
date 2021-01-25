package com.example.TransportCompany.Models;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * This is a class which represents an information about an employee(driver).
 *
 * @author svasilev
 * */

public class Employee implements Comparable<Employee>
{
  private String        employeeName;
  private int           age;
  private int           experience;
  private TypeOfDriver  typeOfDriver;
  private Double        salary;
  private AtomicInteger numberOfTransportations = new AtomicInteger(0);
  private Double        profitFromEmployee      = 0.00;

  public Employee(String employeeName, int age, int experience, TypeOfDriver typeOfDriver, Double salary)
  {
    this.employeeName = employeeName;
    this.age = age;
    this.experience = experience;
    this.typeOfDriver = typeOfDriver;
    this.salary = salary;
  }

  public Double getProfitFromEmployee()
  {
    return profitFromEmployee;
  }

  public void setProfitFromEmployee(Double profitFromEmployee)
  {
    this.profitFromEmployee = profitFromEmployee;
  }

  public AtomicInteger getNumberOfTransportations()
  {
    return numberOfTransportations;
  }

  public String getEmployeeName()
  {
    return employeeName;
  }

  public void setEmployeeName(String employeeName)
  {
    this.employeeName = employeeName;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public int getExperience()
  {
    return experience;
  }

  public void setExperience(int experience)
  {
    this.experience = experience;
  }

  public TypeOfDriver getTypeOfDriver()
  {
    return typeOfDriver;
  }

  public void setTypeOfDriver(TypeOfDriver typeOfDriver)
  {
    this.typeOfDriver = typeOfDriver;
  }

  @Override
  public int compareTo(Employee emp)
  {
    return this.employeeName.compareTo(emp.employeeName);
  }

  public static Comparator<Employee> byTypeOfDriver = new Comparator<Employee>()
  {
    @Override
    public int compare(Employee emp1, Employee emp2)
    {
      return emp1.typeOfDriver.compareTo(emp2.typeOfDriver);
    }
  };

  public static Comparator<Employee> bySalary = new Comparator<Employee>()
  {
    @Override
    public int compare(Employee emp1, Employee emp2)
    {
      return emp1.salary.compareTo(emp2.salary);
    }
  };

  @Override
  public String toString()
  {
    return "Employee{" +
        "employeeName = '" + employeeName + '\'' +
        ", numberOfTransportations = " + numberOfTransportations +
        ", profitFromEmployee = " + profitFromEmployee +
        '}';
  }
}
