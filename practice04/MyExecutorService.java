package ru.mirea.java.practice04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

class MyExecutorService extends AbstractExecutorService implements java.util.concurrent.ExecutorService {
    private final int Count;
    private boolean shutdown;
    private final List<Thread> threads;

    public MyExecutorService(int threadCount) {
        this.Count = threadCount;
        this.threads = new ArrayList<>();
    }

    @Override
    public void shutdown() {
        shutdown = true;
        threads.forEach(Thread::interrupt);
    }

    @Override
    public List<Runnable> shutdownNow() {
        List<Runnable> list = threads.stream().map(thread -> (Runnable) thread).collect(Collectors.toList());
        this.shutdown();
        return list;
    }

    @Override
    public boolean isShutdown() {
        return shutdown;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
        return false;
    }


    @Override
    public Future<?> submit(Runnable task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<Void> futureTask = new FutureTask<>(task, null);
        execute(futureTask);
        return futureTask;
    }

    @Override
    public void execute(Runnable command) {
        if (command == null)
            throw new NullPointerException();
        if (threads.size() == Count)
            throw new IllegalArgumentException("Final thread");
        shutdown = false;

        Thread thread = new Thread(command);
        threads.add(thread);
        thread.start();
    }
}
