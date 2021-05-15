package ru.mirea.java.practice06.Prototype;

import ru.mirea.java.practice06.FactoryMethod.Car;
import ru.mirea.java.practice06.FactoryMethod.JeepCar;
import ru.mirea.java.practice06.FactoryMethod.SedanCar;

import java.util.HashMap;
import java.util.Map;

class CarStore {

    private static Map<String, Car> carMap = new HashMap<String, Car>();

    static {
        carMap.put("jeep", new JeepCar());
        carMap.put("sedan", new SedanCar());
    }

    public static Car getCar(String bodyType) {
        return (Car) carMap.get(bodyType);
    }
}
