package ru.mirea.java.practice06.AbstractFactory;

class SedanCarFactory {
    public static Car buildCar(CarType model) {
        return switch (model) {
            case PETROL -> new PetrolCar(BodyType.SEDAN);
            case ELECTRICAL -> new ElectricalCar(BodyType.SEDAN);
        };
    }
}
