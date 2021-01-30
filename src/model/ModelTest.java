package model;

public class ModelTest {
    public static void main(String[] args) throws Exception {
        // This class is only for testing purpose during development.
        // The first thing we try is to instantiate every model class to test their behaviour
        // By doing so we build a temporary database, on which we can later test the controller and the view.
        // Additionally, if we don't manage to write the database integration in time, we have this test file to
        // show the functionality without a real database.


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


        Product karotte;
        Product apfel;
        try {
            karotte = new Product("Karrotte", 1234567890123L,
                    1000, 10, 0.5, "Gemüse");
            apfel = new Product("Apfel", 94001L,
                    1000, 5, 0.4, "Früchte");
        } catch (Exception e) {
            throw e;
        }

        //Product tests
        System.out.println(karotte.getName());
        System.out.println(karotte.getId());
        System.out.println(karotte.getStock());
        System.out.println(karotte.getWeight());
        System.out.println(karotte.getPrice());
        System.out.println(karotte.getBasePrice());
        System.out.println(karotte.getCategory());

        System.out.println(apfel.getName());
        System.out.println(apfel.getId());
        System.out.println(apfel.getStock());
        System.out.println(apfel.getWeight());
        System.out.println(apfel.getPrice());
        System.out.println(apfel.getBasePrice());
        System.out.println(apfel.getCategory());

        karotte.setName("Pastinake");
        karotte.setId(9999999999999L);
        karotte.setStock(10);
        karotte.setWeight(5);
        karotte.setPrice(1.0f);
        karotte.setBasePrice(0.5);
        karotte.setCategory("MEGAGEMÜSE");

        apfel.setName("Birne");
        apfel.setId(3210987654321L);
        apfel.setStock(10);
        apfel.setWeight(10);
        apfel.setPrice(100.0f);
        apfel.setBasePrice(100.0);
        apfel.setCategory("Elektronik");

        System.out.println(karotte.getName());
        System.out.println(karotte.getId());
        System.out.println(karotte.getStock());
        System.out.println(karotte.getWeight());
        System.out.println(karotte.getPrice());
        System.out.println(karotte.getBasePrice());
        System.out.println(karotte.getCategory());

        System.out.println(apfel.getName());
        System.out.println(apfel.getId());
        System.out.println(apfel.getStock());
        System.out.println(apfel.getWeight());
        System.out.println(apfel.getPrice());
        System.out.println(apfel.getBasePrice());
        System.out.println(apfel.getCategory());


        // Implement tests for:
        // CategoryList
        // ProductList

    }
}