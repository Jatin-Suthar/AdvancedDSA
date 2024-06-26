package JavaPoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student_Solution {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Jatin", 22));
        students.add(new Student("Jitendra", 26));
        students.add(new Student("Ujjwal", 24));
        students.add(new Student("Abhay", 24));
        Collections.sort(students, Comparator.comparing(Student::getName));
        List<String> studentNames = students.stream().map(Student::getName).sorted().toList();
        System.out.println(students);
        System.out.println(studentNames);
    }

}

class Student {

    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
