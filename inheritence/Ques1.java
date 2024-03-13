package inheritence;

class A {
    void methodA() {
        System.out.println("Method A in class A");
    }
}

class B extends A {
    void methodB() {
        System.out.println("Method B in class B");
    }
}

class C extends B {
    void methodC() {
        System.out.println("Method C in class C");
    }
}

public class Ques1 {
    public static void main(String[] args) {
        C myObject = new C();
        myObject.methodA();
        myObject.methodB();
        myObject.methodC();
        Dog myDog = new Dog();
        myDog.eat();
        myDog.bark();
    }
}

class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}