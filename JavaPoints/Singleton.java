package JavaPoints;

public class Singleton {
    private static Singleton instance;
    private Singleton() {
        System.out.println("Created singleton object...");
        if (instance != null) {
            throw new IllegalStateException("Singleton instance already exists.");
        }
    }
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void doSomething() {
        System.out.println("Singleton instance is doing something.");
    }

}
