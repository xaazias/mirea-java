package ru.mirea.java.practice06.FactoryMethod;

import ru.mirea.java.practice06.AbstractFactory.BodyType;

public class JeepCar extends Car {

    public JeepCar() {
        super(BodyType.JEEP);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}