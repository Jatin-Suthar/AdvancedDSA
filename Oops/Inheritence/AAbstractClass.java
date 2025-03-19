package Oops.Inheritence;

interface AA {
    String getName();
}

public abstract class AAbstractClass implements AA {

    public static final String CITY = "JAIPUR";

    private String name;

    AAbstractClass(String name) {
        this.name = name;
    }

    public abstract String getSegregatedName(String name);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

    }

}

class SubClass extends AAbstractClass {

    SubClass(String name) {
        super(name);
    }

    @Override
    public String getSegregatedName(String name) {
        return "Jatin Suthar";
    }

    public static void main(String[] args) {
        SubClass a = new SubClass("Jatin");
        System.out.println(a.getSegregatedName("") + ": " + AAbstractClass.CITY);
    }

}

interface BB {
    int MAX_COUNT = Integer.MAX_VALUE;
    static int MIN_COUNT = Integer.MIN_VALUE;
}

class Example1 {

    final int var = 2;

    void drive() {
        System.out.println("driving...");
    }

    final void display() {
        System.out.println("displaying");
    }

}

class Example2 extends Example1 {

    public static void main(String[] args) {
        Example2 example2 = new Example2();
        example2.display();
    }

}

interface M {
    void show();
    default void display() {
        System.out.println("M: displaying...");
    }
}
interface N {
    void show();
    default void display() {
        System.out.println("N: displaying...");
    }
}
class O implements M, N {

    @Override
    public void show() {

    }

    @Override
    public void display() {
        M.super.display();
    }
}

class AExp implements Exp, Exp.Vp {

    public static void main(String[] args) {
        Exp exp = new Exp() {

            @Override
            public void display() {

            }
        };
    }

    @Override
    public void display() {

    }

    @Override
    public void play() {

    }
}

interface Exp {
    void display();

    interface Vp {
        void play();
    }
}