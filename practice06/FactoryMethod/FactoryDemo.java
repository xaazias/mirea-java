package ru.mirea.java.practice06.FactoryMethod;

public class FactoryDemo {
    public static void main(String[] args)
    {
        System.out.println("Factory Demo");
        CarFactory carFactory = new CarFactory();
        Car car1 = carFactory.createCar("JEEP");
        Car car2 = carFactory.createCar("SEDAN");
        System.out.println(car1.toString());
        System.out.println(car2.toString());
    }
}
