package JavaPoints;

import java.util.ArrayList;
import java.util.List;

public class ShallowCopyExample {

    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        Dog oldDog = aDog;
        foo(aDog);
        System.out.println("3th: "+(aDog.getName().equals("Max")));
        System.out.println("4th: "+(aDog.getName().equals("Fifi"))); //
        System.out.println("5th: "+(oldDog.getName().equals("Max"))); //
        System.out.println("6th: "+(oldDog.getName().equals("Fifi"))); //
        System.out.println("7th: "+(aDog == oldDog)); //
    }

    public static void foo(Dog d) {
        System.out.println("1th: "+(d.getName().equals("Max"))); //

        d = new Dog("Fifi");
        System.out.println("2th: "+(d.getName().equals("Fifi"))); //
    }

}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
