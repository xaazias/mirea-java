package ru.mirea.java;

import java.util.concurrent.ConcurrentHashMap;

public class SemaphoreTest {

    private static final java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(3);
    private static final ConcurrentHashMap<Integer, String> hashMap = new ConcurrentHashMap<>();

    static void runTask(int i) {
        try {
            semaphore.acquire();
            System.out.println(hashMap.get(i));
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {

        hashMap.put(0,"USER_1");
        hashMap.put(1,"USER_2");
        hashMap.put(2,"USER_3");
        hashMap.put(3,"USER_4");
        hashMap.put(4,"USER_5");

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 5; i++)
                runTask(i);
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 5; i++)
                runTask(i);
        });

        threadOne.start();
        threadTwo.start();
    }
}
