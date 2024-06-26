package JavaPoints;

import java.util.ArrayList;
import java.util.List;

public class ShallowCopyExample {

    public static void main(String[] args) {


        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = list1;
        list1.add(1);///
        list1.add(2);///
        list1.add(3);///
        List<Integer> list3 = new ArrayList<>(list1);
        list3.add(4);////
        list3.add(5);////
        list2.add(6);/////
        list2.add(7);/////
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

//        int[] a = new int[0];
//        int[] b = new int[-56];
//        int[] c = new int[3487983989483333];


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
