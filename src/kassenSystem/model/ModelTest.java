package kassenSystem.model;

public class ModelTest {
    public static void main(String[] args) throws Exception {
        // This class is only for testing purpose during development.
        // The first thing we try is to instantiate every model class to test their behaviour
        // By doing so we build a temporary database, on which we can later test the controller and the view.
        // Additionally, if we don't manage to write the database integration in time, we have this test file to
        // show the functionality without a real database.

        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("AdminLogin Tests");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println();

        AdminLogin defaultAdminLogin = new AdminLogin();
        boolean checkPassword = defaultAdminLogin.checkPassword("123456");
        System.out.println("check true password: " + checkPassword);
        defaultAdminLogin.logOut();
        System.out.println("getIsLoggedIn value, after .logOut(): " + defaultAdminLogin.getIsLoggedIn());
        AdminLogin saveAdminLogin = new AdminLogin("i love bordihn");
        System.out.println("Using different constructor, check long password: " +
                saveAdminLogin.checkPassword("i love bordihn"));
        System.out.println("Didn't logout, logInValue: " + saveAdminLogin.getIsLoggedIn());

        System.out.println();
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("CategoryList Tests");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println();

        CategoryList myCategoryList = new CategoryList();
        myCategoryList.addCategory("Gemüse");
        myCategoryList.addCategory("Grünes Gemüse");
        myCategoryList.addCategory("Rotes Gemüse");
        myCategoryList.addCategory("Früchte");
        myCategoryList.addCategory("Tiefkühlkost");
        System.out.println();
        System.out.println("Print all categories after creating a list of them.");
        System.out.println(myCategoryList.getCategoryList());
        myCategoryList.changeCategory("Früchte", "MEGAFRÜCHTE");
        System.out.println();
        System.out.println("Check ich Früchte was changed to MEGAFRÜCHTE");
        System.out.println(myCategoryList.getCategoryList());
        myCategoryList.removeCategory("Tiefkühlkost");
        System.out.println();
        System.out.println("Check if categoryInList works on MEGAFRÜCHTE");
        System.out.println(myCategoryList.categoryInList("MEGAFRÜCHTE"));
        System.out.println();
        System.out.println("Check if Tiefkühlkost was removed");
        System.out.println(myCategoryList.getCategoryList());
        System.out.println();
        System.out.println("Check if partial word search works");
        System.out.println(myCategoryList.searchCategory("Gemüse"));

        System.out.println();
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("Product Tests");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println();

        Product karotte;
        Product apfel;
        karotte = new Product("Karotte", 2345L,
                1000, 100, "g", 1000, "Gemüse");
        apfel = new Product("Apfel", 94321L,
                980, 100, "stück", 1000, "MEGAFRÜCHTE");

        System.out.println("Check if construction of product worked as inteded");
        System.out.println("Name: " + karotte.getName());
        System.out.println("ID: " + karotte.getId());
        System.out.println("Stock: " + karotte.getStock());
        System.out.println("Weight: " + karotte.getWeight());
        System.out.println("Weight Unit: " + karotte.getWeightUnit());
        System.out.println("Price: " + karotte.getPrice());
        System.out.println("BasePrice: " + karotte.getBasePrice());
        System.out.println("Category: " + karotte.getCategory());
        System.out.println();

        System.out.println("Check if construction of product worked as inteded with different values");
        System.out.println("Name: " + apfel.getName());
        System.out.println("ID: " + apfel.getId());
        System.out.println("Stock: " + apfel.getStock());
        System.out.println("Weight: " + apfel.getWeight());
        System.out.println("Weight Unit: " + apfel.getWeightUnit());
        System.out.println("Price: " + apfel.getPrice());
        System.out.println("BasePrice: " + apfel.getBasePrice());
        System.out.println("Category: " + apfel.getCategory());
        System.out.println();

        System.out.println("Add a new category and check if the static property of myCategoryList works as inteded");
        myCategoryList.addCategory("ULTRAGEMÜSE");

        karotte.setName("Pastinake");
        karotte.setId(1234567890123L);
        karotte.setStock(10);
        karotte.setWeight(1);
        karotte.setBasePrice(0.01);
        karotte.setCategory("ULTRAGEMÜSE");


        System.out.println();
        System.out.println("After changing Karotte zu Pastinake and the Category to the new category ULTRAGEMÜSE");
        System.out.println("Name: " + karotte.getName());
        System.out.println("ID: " + karotte.getId());
        System.out.println("Stock: " + karotte.getStock());
        System.out.println("Weight: " + karotte.getWeight());
        System.out.println("Weight Unit: " + karotte.getWeightUnit());
        System.out.println("Price: " + karotte.getPrice());
        System.out.println("BasePrice: " + karotte.getBasePrice());
        System.out.println("Category: " + karotte.getCategory());

        System.out.println();
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("PurchaseList Tests");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println();

        PurchaseList myPurchaseList = new PurchaseList();
        myPurchaseList.addItem(karotte, 9);
        myPurchaseList.addItem(apfel, 950);
        System.out.println("Check if purchase list creation worked as inteded");
        for(Item item : myPurchaseList.getPurchaseList()){
            System.out.println("Name: " + item.getProduct().getName());
            System.out.println("Preis: " + item.getProduct().getPrice());
            System.out.println("Anzahl: " + item.getAmount());
            System.out.println();
        }
        System.out.println("Zwischensumme: " + myPurchaseList.getSubtotal());
        System.out.println();

        System.out.println("Check if setItemAmount works as inteded - price and amount change");
        myPurchaseList.setItemAmount(myPurchaseList.getPurchaseList().get(1), 200);
        for(Item item : myPurchaseList.getPurchaseList()){
            System.out.println("Name: " + item.getProduct().getName());
            System.out.println("Preis: " + item.getProduct().getPrice());
            System.out.println("Anzahl: " + item.getAmount());
            System.out.println();
        }
        System.out.println("Zwischensumme: " + myPurchaseList.getSubtotal());
        System.out.println();

        System.out.println("Check if item removal works as inteded - price and amount change");
        myPurchaseList.removeItem(myPurchaseList.getPurchaseList().get(0));
        for(Item item : myPurchaseList.getPurchaseList()){
            System.out.println("Name: " + item.getProduct().getName());
            System.out.println("Preis: " + item.getProduct().getPrice());
            System.out.println("Anzahl: " + item.getAmount());
            System.out.println();
        }
        System.out.println("Zwischensumme: " + myPurchaseList.getSubtotal());
        System.out.println();

        System.out.println("Check if cancel purchase works as inteded");
        System.out.println("Size before canceling: " + myPurchaseList.getPurchaseList().size());
        myPurchaseList.cancelPurchase();
        System.out.println("Size after canceling: " + myPurchaseList.getPurchaseList().size());

        //finishPurchase()

        System.out.println();
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("ProductList Tests");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println();





    }
}