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

        // Implement tests for:
        // CategoryList
        // ProductList

    }
}