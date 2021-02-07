package kassenSystem.test;

import kassenSystem.model.CategoryList;
import kassenSystem.model.Product;
import kassenSystem.model.ProductList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CategoryListTest {

    private CategoryList categoryList;
    private ProductList productList;

    @BeforeEach
    public void setUp() throws Exception {
        categoryList = new CategoryList();
        productList = new ProductList();
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
        productList.addProduct("Grüne BohnenEintopf", 12744532, 12, 0.4, "kg", 1.59, "Konserven");
    }

    @Test
    public void removeCategory() {
        Throwable exception = assertThrows(Exception.class, () -> categoryList.removeCategory("Süßwaren"));
        assertEquals("Die Kategorie Süßwaren ist nicht leer, bitte leeren sie zuerst die Kategorie.", exception.getMessage());
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
        testList.add(new Product("Grüne BohnenEintopf", 12744532, 12, 0.4, "kg", 1.59, "Konserven"));
        assertEquals(productList.searchProductById(4532L), testList);
    }
}