package Interview;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonViewStream {

    public static void main(String[] args) {

        List<Person> list = new java.util.ArrayList<>(List.of(
                new Person("Jatin Suthar", "Jaipur", "Male", "4909490349"),
                new Person("Jayesh Suthar", "Pune", "Male", "4909490349"),
                new Person("Khushbu Suthar", "Surat", "Female", "4909490349"),
                new Person("Mukesh Suthar", "Surat", "Male", "4909490349"),
                new Person("Gourav Suthar", "Banglore", "Male", "4909490349"),
                new Person("Anjali Suthar", "Banglore", "Female", "4909490349"),
                new Person("Ujjwal Suthar", "Jaipur", "Male", "4909490349"),
                new Person("Nikhil Suthar", "Jaipur", "Male", "4909490349"),
                new Person("Jitu Suthar", "Jaipur", "Male", "4909490349")
        ));

        Map<String, Long> info = list.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
        System.out.println(info);

        System.out.println(list);
        Collections.sort(list, Comparator.comparing(Person::getCity));
        System.out.println(list);

    }

}

class Person {

    private String name;
    private String city;
    private String gender;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person(String name, String city, String gender, String phoneNumber) {
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
