package ru.mirea.java.practice2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Person(
                "John",
                "Wooz",
                19,
                77,
                new GregorianCalendar(2002, Calendar.JANUARY, 15).getTime())
        );

        persons.add(new Person(
                "Mark",
                "Grey",
                31,
                66,
                new GregorianCalendar(1991, Calendar.FEBRUARY, 25).getTime())
        );

        persons.add(new Person(
                "Lisa",
                "Bird",
                71,
                68,
                new GregorianCalendar(1999, Calendar.APRIL, 9).getTime())
        );

        ArrayList<Person> ageMoreThanWeight = (ArrayList<Person>) persons
                .stream()
                .filter(person -> person.getAge() > person.getWeight())
                .collect(Collectors.toList());

        Comparator<Person> secondNameComparator = Comparator.comparingInt(p -> p.getSecondName().charAt(p.getSecondName().length() - 1));
        ArrayList<Person> sortedByLastLetterInLastName = (ArrayList<Person>) persons
                .stream()
                .sorted(secondNameComparator)
                .collect(Collectors.toList());

        Comparator<Person> birthComparator = Comparator.comparing(Person::getBirth);
        ArrayList<Person> sortedByBirth = (ArrayList<Person>) persons
                .stream()
                .sorted(birthComparator)
                .collect(Collectors.toList());

        int ageMultiplication =  persons
                .stream()
                .reduce(1, (bufferResult, person) -> bufferResult * person.getAge(), Integer::sum);

        System.out.println("Фильтрация (истина, если возраст больше веса): " + ageMoreThanWeight.toString());
        System.out.println("Сортировка по последней букве фамилии: " + sortedByLastLetterInLastName.toString());
        System.out.println("Сортировка по дате рождения: " + sortedByBirth.toString());
        System.out.println("Произведение всех возрастов: " + ageMultiplication);
    }
}
