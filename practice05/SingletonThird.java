package ru.mirea.java.practice05;

public class SingletonThird {
    private static SingletonThird SINGLE;
    private SingletonThird() {}
    public static SingletonThird getInstance() {
        if (SINGLE == null) {
            synchronized (SingletonThird.class) {
                if (SINGLE == null) {
                    SINGLE = new SingletonThird();
                }
            }
        }
        return SINGLE;
    }
}
