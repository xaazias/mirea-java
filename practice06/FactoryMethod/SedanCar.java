package ru.mirea.java.practice06.FactoryMethod;


import ru.mirea.java.practice06.AbstractFactory.BodyType;

public class SedanCar extends Car {

    public SedanCar() {
        super(BodyType.SEDAN);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}