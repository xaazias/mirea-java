package ru.mirea.java.practice06.Prototype;

// Driver class
public class PrototypeDemo {
    public static void main(String[] args) {
        System.out.println("Prototype Demo");
        System.out.println(CarStore.getCar("jeep").toString());
        System.out.println(CarStore.getCar("sedan").toString());
    }
}
