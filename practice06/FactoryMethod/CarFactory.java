package ru.mirea.java.practice06.FactoryMethod;

public class CarFactory {
    public Car createCar(String type)
    {
        if (type == null)
            return null;
        if ("JEEP".equals(type)) {
            return new JeepCar();
        }
        else if ("SEDAN".equals(type)) {
            return new SedanCar();
        }
        return null;
    }
}