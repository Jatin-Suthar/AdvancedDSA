package Oops.Inheritence;

public class CopyExample {

    public static void main(String[] args) {
        //with Objects
        City city1 = new City("Amd", 234567);
        System.out.println("City1: " + city1);
        modifyCity(city1);
        System.out.println("City1: " + city1);
    }

    public static void modifyCity(City city) {
        city.setPopulation(
                3455756
        );
        System.out.println(city);
        city = new City("Mumbai", 456789);
        System.out.println(city);
    }

}

class City {
    String name;
    int population;
    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
    public City(City anotherCity) {
        this.name = anotherCity.getName();
        this.population = anotherCity.getPopulation();
    }
}
