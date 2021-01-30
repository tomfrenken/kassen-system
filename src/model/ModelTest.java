package model;

public class ModelTest {
    public static void main(String[] args) {
        // This class is only for testing purpose during development.
        // The first thing we try is to instantiate every model class to test their behaviour
        // By doing so we build a temporary database, on which we can later test the controller and the view.
        // Additionally, if we don't manage to write the database integration in time, we have this test file to
        // show the functionality without a real database.




        System.out.println(fruit.getName());
        System.out.println("Now we change the category");
        fruit.setName("green-fruit");
        System.out.println(fruit.getName());

        System.out.println("Now we try Products");

        Product apple = new Product("Apple", 1, 50, 50, 10, 20, fruit);

        System.out.println(apple.getName());
        System.out.println(apple.getId());
        System.out.println(apple.getStock());
        System.out.println(apple.getWeight());
        System.out.println(apple.getPrice());
        System.out.println(apple.getBasePrice());
        System.out.println(apple.getCategory().getName());

        // Implement tests for:
        // CategoryList
        // ProductList

    }
}