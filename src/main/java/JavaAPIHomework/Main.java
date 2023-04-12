package JavaAPIHomework;

import JavaAPIHomework.entity.Person;
import JavaAPIHomework.entity.PersonDTO;
import JavaAPIHomework.entity.GroupOfPeople;
import JavaAPIHomework.service.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        MockData mockData = new MockData();
        List<Person> people = mockData.getPeople();

        System.out.println("//--------Filter---------//");

        List<Person> pplUnderAge2 = people.stream()
                .filter(ppl -> ppl.getAge() < 2)
                .collect(Collectors.toList());
        pplUnderAge2.forEach(System.out::println);

        System.out.println("//--------Map---------//");

        List<PersonDTO> pplUnderAgeDTO = pplUnderAge2.stream()
                .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
                .collect(Collectors.toList());
        pplUnderAgeDTO.forEach(System.out::println);

        System.out.println("//--------Flat Map---------//");

        List<Person> woman = people.stream()
                .filter(ppl -> ppl.getGender().equalsIgnoreCase("Female"))
                .limit(10)
                .collect(Collectors.toList());
        // Sukuriame 2 objektus, kurie savyje laiko sąrašą objektų Person
        GroupOfPeople under2YearsOld = new GroupOfPeople(pplUnderAge2);
        GroupOfPeople foundWomanList = new GroupOfPeople(woman);
        // Sukuriame sąrašą objektų, kurie savyje laiko sąrašus
        List<GroupOfPeople> listForFlatMap = new ArrayList<>();
        listForFlatMap.add(under2YearsOld);
        listForFlatMap.add(foundWomanList);

        //Flat map streamas. Pirma 2 sukurtus objektus su map paverčiame į atskirus sąrašus, tada su latmap juos sutapatiname į vieną.
        List<Person> flatMapResult = listForFlatMap.stream()
                .map(GroupOfPeople::getPersons)
                .flatMap(Collection::stream)
                .filter(person -> person.getId() < 300)
                .collect(Collectors.toList());
        System.out.println("------Flat Map result list-------");
        flatMapResult.forEach(System.out::println);

        System.out.println("--------------Peek---------------");
        // Usually used in debugging purposes
        List<Person> peekExample = flatMapResult.stream()
                .peek(System.out::println)
                .filter(person -> person.getGender().equalsIgnoreCase("Male"))
                .collect(Collectors.toList());
        System.out.println();
        peekExample.forEach(System.out::println);

        System.out.println("-------Reduce------");

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6);
        int reduceExample = numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(1, (a, b) -> a * b);

        System.out.println(reduceExample);


        System.out.println("Primityvus stringų masyvas");
        //String[] stringArray = {"Obuolys", "Apelsinas", "Ananasas"};

        //Arrays.stream(stringArray).
    }
}


