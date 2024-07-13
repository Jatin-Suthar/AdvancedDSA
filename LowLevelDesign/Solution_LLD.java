package LowLevelDesign;

public class Solution_LLD {

    public static void main(String[] args) {
        Factory amazonFactory = new AmazonFactory();
        Product amazonProduct = amazonFactory.getProduct();
        amazonProduct.display();

        Factory flipkartFactory = new FlipkartFactory();
        Product flipkart = flipkartFactory.getProduct();
        flipkart.display();
    }

}

class AmazonProduct extends Product {
    @Override
    void display() {
        System.out.println("This is Amazon product");
    }
}

class FlipkartProduct extends Product {
    @Override
    void display() {
        System.out.println("This is Flipkart product");
    }
}

abstract class Factory {
    abstract Product getProduct();
}

class AmazonFactory extends Factory {
    @Override
    Product getProduct() {
        return new AmazonProduct();
    }
}

class FlipkartFactory extends Factory {
    @Override
    Product getProduct() {
        return new FlipkartProduct();
    }
}

abstract class Product {
    abstract void display();
}
