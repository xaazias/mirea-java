package ru.mirea.java.practice06.Builder;

import ru.mirea.java.practice06.AbstractFactory.BodyType;
import ru.mirea.java.practice06.AbstractFactory.CarType;

// Client Side Code
class CarReceiver {

    private volatile Car car;

    public CarReceiver() {

        car = Car.Builder.newInstance()
                .setCarType(CarType.PETROL)
                .setBodyType(BodyType.SEDAN)
                .build();
    }

    public Car getCar() {
        return car;
    }
}
