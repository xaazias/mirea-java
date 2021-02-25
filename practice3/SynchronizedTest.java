package ru.mirea.java;

import java.util.HashSet;

public class SynchronizedTest {

    static HashSet<Integer> hashSet = new HashSet<>();

    static synchronized void add(int i){
        hashSet.add(i);
    }

    public static void main(String[] args) {

        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        Thread threadOne = new Thread(() -> {
            for (int i = 4; i <= 6; i++) add(i);
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 7; i <= 10; i++) add(i);
        });

        threadOne.start();
        threadTwo.start();

        hashSet.forEach(System.out::println);
    }
}
