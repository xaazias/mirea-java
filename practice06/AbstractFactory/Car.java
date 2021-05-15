package ru.mirea.java.practice06.AbstractFactory;

public abstract class Car {
    Car(CarType model, BodyType bodyType) {
        this.model = model;
        this.bodyType = bodyType;
    }

    public abstract void construct();

    CarType model = null;
    BodyType bodyType = null;

    CarType getModel() {
        return model;
    }

    void setModel(CarType model) {
        this.model = model;
    }

    BodyType getBodyType() {
        return bodyType;
    }

    void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "CarType = " + model + "; BodyType = " + bodyType;
    }
}
