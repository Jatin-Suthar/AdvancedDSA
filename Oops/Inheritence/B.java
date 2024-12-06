package Oops.Inheritence;

public class B {

    public static void main(String[] args) {
        E e = new E();
        String str = "Hi";
        e.display();
        e.display(str);
        final Person person = new Person("Jatin", 23);
        System.out.println(person);
        person.setName("Jayesh");
        System.out.println(person);
    }

}

class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class G implements H {
    @Override
    public void display() {
        System.out.println("G");
    }
}

interface H {
    void display();
    static void display(String str) {
        System.out.println(str);
    }
    default void display(int say) {
        System.out.println(say);
    }
}

class E extends D {
    @Override
    void display() {
        System.out.println("E: Hi");
    }
    void display(String str) {
        super.display(str);
        System.out.println("E: " + str);
    }
}

abstract class D {
    abstract void display();
    void display(String str) {
        this.display();
        System.out.println("D: " + str);
    }
    private void display(String str, int i) {
        System.out.println(str + " " + i);
    }
    static void display(int i) {
        System.out.println(i);
    }
    final void display(String s, String t) {
        System.out.println(s + " " + t);
    }
}