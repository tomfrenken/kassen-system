package model;

public class ModelTest {
    public static void main(String[] args) throws Exception {
        // This class is only for testing purpose during development.
        // The first thing we try is to instantiate every model class to test their behaviour
        // By doing so we build a temporary database, on which we can later test the controller and the view.
        // Additionally, if we don't manage to write the database integration in time, we have this test file to
        // show the functionality without a real database.

        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("CategoryList Tests");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        CategoryList myCategoryList = new CategoryList();
        myCategoryList.addCategory("Gemüse");
        myCategoryList.addCategory("Grünes Gemüse");
        myCategoryList.addCategory("Rotes Gemüse");
        myCategoryList.addCategory("Früchte");
        myCategoryList.addCategory("Tiefkühlkost");
        System.out.println();
        System.out.println(myCategoryList.getCategoryList());
        myCategoryList.changeCategory("Früchte", "MEGAFRÜCHTE");
        System.out.println();
        System.out.println(myCategoryList.getCategoryList());
        myCategoryList.removeCategory("Tiefkühlkost");
        System.out.println();
        System.out.println(myCategoryList.categoryInList("MEGAFRÜCHTE"));
        System.out.println();
        System.out.println(myCategoryList.getCategoryList());
        System.out.println();
        System.out.println(myCategoryList.searchCategory("Gemüse"));


        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("Product Tests");
        System.out.println("------------------------------");
        System.out.println("------------------------------");

        Product karotte;
        Product apfel;
        karotte = new Product("Karrotte", 1234567890123L,
                1000, 10, 0.5, "Gemüse");
        apfel = new Product("Apfel", 94001L,
                1000, 5, 0.4, "MEGAFRÜCHTE");

        System.out.println("Name: " + karotte.getName());
        System.out.println("ID: " + karotte.getId());
        System.out.println("Stock: " + karotte.getStock());
        System.out.println("Weight: " + karotte.getWeight());
        System.out.println("Price: " + karotte.getPrice());
        System.out.println("BasePrice: " + karotte.getBasePrice());
        System.out.println("Category: " + karotte.getCategory());

        myCategoryList.addCategory("ULTRAGEMÜSE");

        karotte.setName("Pastinake");
        karotte.setId(9999999999999L);
        karotte.setStock(10);
        karotte.setWeight(5);
        karotte.setPrice(1.0f);
        karotte.setBasePrice(0.9);
        karotte.setCategory("ULTRAGEMÜSE");

        System.out.println("Name: " + karotte.getName());
        System.out.println("ID: " + karotte.getId());
        System.out.println("Stock: " + karotte.getStock());
        System.out.println("Weight: " + karotte.getWeight());
        System.out.println("Price: " + karotte.getPrice());
        System.out.println("BasePrice: " + karotte.getBasePrice());
        System.out.println("Category: " + karotte.getCategory());

        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("PurchaseList Tests");
        System.out.println("------------------------------");
        System.out.println("------------------------------");

        PurchaseList myPurchaseList = new PurchaseList();
        myPurchaseList.addItem(karotte, 9);
        myPurchaseList.addItem(apfel, 950);
        for(Item item : myPurchaseList.getPurchaseList()){
            System.out.println("Name: " + item.getProduct().getName());
            System.out.println("Preis: " + item.getProduct().getPrice());
            System.out.println("Anzahl: " + item.getAmount());
            System.out.println();
        }
        System.out.println(myPurchaseList.getSubtotal());
        System.out.println();
        myPurchaseList.removeItem(karotte);
        for(Item item : myPurchaseList.getPurchaseList()){
            System.out.println("Name: " + item.getProduct().getName());
            System.out.println("Preis: " + item.getProduct().getPrice());
            System.out.println("Anzahl: " + item.getAmount());
            System.out.println();
        }
        System.out.println(myPurchaseList.getSubtotal());
        System.out.println();


        // Implement tests for:
        // CategoryList
        // ProductList

    }
}