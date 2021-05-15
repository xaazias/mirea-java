package ru.mirea.java.practice06.AbstractFactory;

class CarFactory {


    public static Car buildCar(CarType type) {
        Car car = null;
        BodyType location = BodyType.SEDAN;

        car = switch (location) {
            case SEDAN -> SedanCarFactory.buildCar(type);
            case JEEP -> JeepCarFactory.buildCar(type);
        };

        return car;

    }
}
