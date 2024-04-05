package Arrays;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private List<String> hobbies;

    public Person(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    // Getter and setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}

public class CopyExample {
    public static void main(String[] args) {
        // Original person
        List<String> originalHobbies = new ArrayList<>();
        originalHobbies.add("Reading");
        originalHobbies.add("Cooking");
        Person originalPerson = new Person("Alice", originalHobbies);

        // Shallow copy
        Person shallowCopy = new Person(originalPerson.getName(), originalPerson.getHobbies());

        // Modify hobbies list in shallow copy
        shallowCopy.getHobbies().add("Gardening");

        // Deep copy
        List<String> deepCopyHobbies = new ArrayList<>(originalPerson.getHobbies());
        Person deepCopy = new Person(originalPerson.getName(), deepCopyHobbies);

        // Modify hobbies list in deep copy
        deepCopy.getHobbies().add("Painting");

        // Output
        System.out.println("Original Person: " + originalPerson);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Deep Copy: " + deepCopy);
    }
}

