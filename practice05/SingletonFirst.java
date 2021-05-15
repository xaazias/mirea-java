package ru.mirea.java.practice05;

public class SingletonFirst {
    private static SingletonFirst SINGLE;

    private SingletonFirst() {}

    public static SingletonFirst getInstance() {
        if (SINGLE == null) {
            synchronized (SingletonFirst.class) {
                SINGLE = new SingletonFirst();
            }
        }
        return SINGLE;
    }
}
