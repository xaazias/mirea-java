package ru.mirea.java.practice06.AbstractFactory;

class PetrolCar extends Car {
    PetrolCar(BodyType bodyType) {
        super(CarType.PETROL, bodyType);
        construct();
    }

    @Override
    public void construct() {
        System.out.println("PetrolCar constructor");
    }
}
