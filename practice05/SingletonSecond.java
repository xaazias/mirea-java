package ru.mirea.java.practice05;

public enum SingletonSecond {
    SINGLE;
    public static SingletonSecond getInstance() {
        return SINGLE;
    }
}
