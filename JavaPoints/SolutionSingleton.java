package JavaPoints;

public class SolutionSingleton {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        singleton1.doSomething();

        Singleton singleton2 = Singleton.getInstance();
        singleton2.doSomething();
    }

}
