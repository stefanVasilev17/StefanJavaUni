package com.example.TransportCompany.Models;

/**
 * This class represents an information about the vehicles which are owned by the company.
 *
 * @author svasilev
 * */
public class Vehicle
{
  private TypeOfVehicle  typeOfVehicle;
  private Transportation transportation;
  private       double maxWeight;
  private final String licence;

  public Vehicle(TypeOfVehicle typeOfVehicle, Transportation transportation, double maxWeight, String licence)
  {
    this.typeOfVehicle = typeOfVehicle;
    this.transportation = transportation;
    this.maxWeight = maxWeight;
    this.licence = licence;
  }

  public Vehicle(TypeOfVehicle typeOfVehicle, String licence)
  {
    this.typeOfVehicle = typeOfVehicle;
    this.licence = licence;
  }

  public String getLicence()
  {
    return licence;
  }

  public TypeOfVehicle getTypeOfVehicle()
  {
    return typeOfVehicle;
  }

  public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle)
  {
    this.typeOfVehicle = typeOfVehicle;
  }

  public Transportation getTransportation()
  {
    return transportation;
  }

  public void setTransportation(Transportation transportation)
  {
    this.transportation = transportation;
  }

  public double getMaxWeight()
  {
    return maxWeight;
  }

  public void setMaxWeight(double maxWeight)
  {
    this.maxWeight = maxWeight;
  }

  @Override
  public String toString()
  {
    return "Vehicle{" +
        "typeOfVehicle=" + typeOfVehicle +
        ", maxWeight=" + maxWeight +
        ", licence='" + licence + '\'' +
        '}';
  }
}
