package inheritence;

class Superclass {
    static void staticMethod() {
        System.out.println("Static method in Superclass");
    }
    void orBhai() {
        System.out.println("or bhai SuperClass");
    }
}

class Subclass extends Superclass {
    static void staticMethod() {
        System.out.println("Static method in Subclass");
    }
    void orBhai() {
        System.out.println("or bhai SubClass");
    }
}

public class Solution_Oops {
    public static void main(String[] args) {
        Superclass obj1 = new Subclass();
        obj1.staticMethod(); // Output: "Static method in Superclass"

        Subclass obj2 = new Subclass();
        obj2.staticMethod(); // Output: "Static method in Subclass"

        obj1.orBhai();
        obj2.orBhai();
    }
}
