package ru.mirea.java.practice06.Builder;

import ru.mirea.java.practice06.AbstractFactory.BodyType;
import ru.mirea.java.practice06.AbstractFactory.CarType;

// Server Side Code
final class Car {

    private final CarType carType;
    private final BodyType bodyType;

    public Car(Builder builder) {
        this.carType = builder.carType;
        this.bodyType = builder.bodyType;
    }


    public static class Builder {


        private CarType carType;
        private BodyType bodyType;

        public static Builder newInstance() {
            return new Builder();
        }

        private Builder() {
        }

        // Setter methods
        public Builder setCarType(CarType carType) {
            this.carType = carType;
            return this;
        }

        public Builder setBodyType(BodyType bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "CarType: "+this.carType+" BodyType: "+this.bodyType;
    }
}
