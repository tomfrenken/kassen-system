package kassenSystem.test;

import kassenSystem.model.CategoryList;
import kassenSystem.model.Product;
import kassenSystem.model.ProductList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ProductListTest {

    private final CategoryList categoryList = new CategoryList();
    private final ProductList productList = new ProductList();

    @BeforeEach
    public void setUp() throws Exception {
        categoryList.addCategory("Süßwaren");
        categoryList.addCategory("Obst");
        categoryList.addCategory("Gemüse");
        categoryList.addCategory("Gewürze");
        categoryList.addCategory("Aufstrich");
        categoryList.addCategory("Backwaren");
        categoryList.addCategory("Getränke");
        categoryList.addCategory("Konserven");
        productList.addProduct("Brausepulver Zuckerfrei", 2913455551023L, 27, 75, "g", 3.99, "Süßwaren");
        productList.addProduct("Apfel Goldy", 4532, 68, 100, "g", 2.50, "Obst");
        productList.addProduct("Tomate Savanna", 93780, 34, 100, "g", 4.99, "Gemüse");
        productList.addProduct("Basilikum gerebelt", 89348842, 8, 50, "g", 2.70, "Gewürze");
        productList.addProduct("Erdbeer-Konfitüre",8453267832680L , 14, 250, "g", 4.27, "Aufstrich");
        productList.addProduct("Mehl 405", 8597618758423L, 53, 1, "kg", 0.99, "Backwaren");
        productList.addProduct("Zitronensaft trüb", 4686835148936L, 21, 250, "ml", 2.49, "Getränke");
        productList.addProduct("Apfelsaft Klar", 32135947, 41, 1.5, "l", 1.65, "Getränke");
        productList.addProduct("Zucker-Ganglien", 1151216951419L, 15, 1, "stück", 45.32, "Süßwaren");
        productList.addProduct("Grüne Bohnen Eintopf", 12744532, 12, 0.4, "kg", 1.59, "Konserven");
    }

    @AfterEach
    public void tearDown(){
        productList.getProductList().clear();
        categoryList.getCategoryList().clear();
    }

    @Test
    public void createUniqueEan() {
        Throwable exceptionForThirteenNumbersLongEan = assertThrows(Exception.class, () -> productList.addProduct("Mehl 406", 8597618758423L, 20, 2, "kg", 4.99, "Backwaren"));
        Throwable exceptionForEightNumbersLongEan = assertThrows(Exception.class, () -> productList.addProduct("Birnensaft Klar", 32135947, 69, 2, "l", 2.49, "Getränke"));
        Throwable exceptionForFiveNumbersLongEan = assertThrows(Exception.class, () -> productList.addProduct("Tomate Havanna", 93780, 12, 1, "kg", 3.99, "Gemüse"));
        Throwable exceptionForFourNumbersLongEan = assertThrows(Exception.class, () -> productList.addProduct("Birne Silby", 4532, 132, 250, "g", 1.99, "Obst"));

        assertEquals("Die Produkt-ID 8597618758423 wird bereits verwendet.", exceptionForThirteenNumbersLongEan.getMessage());
        assertEquals("Die Produkt-ID 32135947 wird bereits verwendet.", exceptionForEightNumbersLongEan.getMessage());
        assertEquals("Die Produkt-ID 93780 wird bereits verwendet.", exceptionForFiveNumbersLongEan.getMessage());
        assertEquals("Die Produkt-ID 4532 wird bereits verwendet.", exceptionForFourNumbersLongEan.getMessage());
    }

    @Test
    public void searchByName() throws Exception {
        ArrayList<Product> testList = new ArrayList<>();
        testList.add(new Product("Brausepulver Zuckerfrei", 2913455551023L, 27, 75, "g", 3.99, "Süßwaren"));
        testList.add(new Product("Zucker-Ganglien", 1151216951419L, 15, 1, "stück", 45.32, "Süßwaren"));
        assertEquals(productList.searchProductByName("Zucker"), testList);
    }

    @Test
    public void searchById() throws Exception {
        ArrayList<Product> testList = new ArrayList<>();
        testList.add(new Product("Apfel Goldy", 4532, 68, 100, "g", 2.50, "Obst"));
        testList.add(new Product("Erdbeer-Konfitüre",8453267832680L , 14, 250, "g", 4.27, "Aufstrich"));
        testList.add(new Product("Grüne Bohnen Eintopf", 12744532, 12, 0.4, "kg", 1.59, "Konserven"));
        assertEquals(productList.searchProductById(4532L), testList);
    }
}
