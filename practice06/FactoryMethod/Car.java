package ru.mirea.java.practice06.FactoryMethod;

import ru.mirea.java.practice06.AbstractFactory.BodyType;

public class Car {
    BodyType bodyType;
    Car(BodyType bodyType){
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "bodyType=" + bodyType +
                '}';
    }
}
