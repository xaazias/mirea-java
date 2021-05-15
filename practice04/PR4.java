package ru.mirea.java.practice04;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class PR4 {
    public static void main(String[] args) {
        ExecutorService executorService = new MyExecutorService(2);

        Future<String> task = executorService.submit(() -> "First");
        executorService.shutdown();

        if (task.isDone() && !task.isCancelled()) {
            try {
                try {
                    System.out.println("Future result: " + task.get());
                }catch (ExecutionException e){
                    System.out.println(e.getMessage());
                }
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }

        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Second");
            }
        });
        executorService.shutdown();

        try {
            executorService.submit(() -> "Test");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
