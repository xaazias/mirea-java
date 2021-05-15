package ru.mirea.java.practice1;

import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {

        List<Integer> nums = List.of(2, 3, 1, 5, 6, 7, 8, 9, 100, 12);
        Predicate<Integer> btf = n -> n == 100;
        System.out.println(nums.stream().anyMatch(btf));
    }
}
