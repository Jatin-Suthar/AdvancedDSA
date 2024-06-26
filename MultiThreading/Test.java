package MultiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
    private String name;
    private String gender;
    private List<Person> subLinks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Person> getSubLinks() {
        return subLinks;
    }

    public void setSubLinks(List<Person> subLinks) {
        this.subLinks = subLinks;
    }

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.subLinks = new ArrayList<>();
    }
}

public class Test {

    public static void main(String[] args) {

        Person person1 = new Person("John", "Male");
        Person person2 = new Person("Alice", "Female");
        Person person3 = new Person("Bob", "Male");
        Person person4 = new Person("Eve", "Female");
        Person person5 = new Person("Mike", "Male");

        Person person6 = new Person("Charlie", "Male");
        Person person7 = new Person("Daisy", "Female");

        person1.getSubLinks().add(person2);
        person1.getSubLinks().add(person3);
        person1.getSubLinks().add(person4);
        person1.getSubLinks().add(person5);

        person3.getSubLinks().add(person6);
        person3.getSubLinks().add(person7);

        List<Person> people = new ArrayList<>();
        people.add(person1);

        List<String> names = people.stream().flatMap(Test::mapSubLinks).map(Person::getName).toList();
        System.out.println(names);
    }

    public static Stream<Person> mapSubLinks(Person p) {
        List<Person> subLinks = p.getSubLinks();
        if(!subLinks.isEmpty()) {
            return Stream.concat(Stream.of(p), subLinks.stream());
        } else {
            return Stream.of(p);
        }
    }

    // Generic swap method
    public static void swap(Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }
}