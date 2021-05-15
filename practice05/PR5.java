package ru.mirea.java.practice05;

public class PR5 {
    public static void main(String[] args) {
        SingletonFirst singletonOne = SingletonFirst.getInstance();
        SingletonFirst singletonOne2 = SingletonFirst.getInstance();
        SingletonSecond singletonTwo = SingletonSecond.getInstance();
        SingletonSecond singletonTwo2 = SingletonSecond.getInstance();
        SingletonThird singletonThree = SingletonThird.getInstance();
        SingletonThird singletonThree2 = SingletonThird.getInstance();

        System.out.println(singletonOne);
        System.out.println(singletonOne2);
        System.out.println(singletonTwo);
        System.out.println(singletonTwo2);
        System.out.println(singletonThree);
        System.out.println(singletonThree2);
    }
}