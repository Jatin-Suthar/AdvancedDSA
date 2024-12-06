package Oops.Inheritence;

public class A {

    public static void main(String[] args) {
        Child child = new Child();
        int a = 3, b = 1;
        System.out.println(child.getDiv(a,b));
        System.out.println(child.getSum(a,b));
        System.out.println(child.getSub(a,b));
        System.out.println(Parent.getMul(a,b));
        Child.C c = new Child.C();
        c.display("Hi");
    }

}

class Child extends Parent {

    static class B {
        public void display(String str) {
            System.out.println(str);
        }
    }

    static class C extends B {
        public void display(String str) {
            super.display(str);
            System.out.println("C" + str);
        }
    }

}

class Parent {

    protected int getSum(int a, int b) {
        return a + b;
    }

    public static int getMul(int a, int b) {
        return a * b;
    }

    public int getDiv(int a, int b) {
        return a / b;
    }

    private int getMod(int a, int b) {
        return a % b;
    }

    final int getSub(int a, int b) {
        return a - b;
    }

}
