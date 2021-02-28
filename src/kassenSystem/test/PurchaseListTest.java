package kassenSystem.test;

import kassenSystem.model.CategoryList;
import kassenSystem.model.Product;
import kassenSystem.model.ProductList;
import kassenSystem.model.PurchaseList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the productList.
 */
public class PurchaseListTest {

    private final CategoryList categoryList = new CategoryList();
    private final ProductList productList = new ProductList();
    private final PurchaseList purchaseList = new PurchaseList();

    /**
     * Initialize categoryList and productList with entries to perform the test on.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
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

    /**
     * Clears categoryList and productList off all test entries.
     */
    @AfterEach
    public void tearDown(){
        productList.clear();
        categoryList.clear();
        purchaseList.getPurchaseList().clear();

        purchaseList.

    /**
     * Test if the finishPurchase function works correctly.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
    @Test
    public void purchase1() throws Exception{
        purchaseList.addItem(purchaseList.getProductList().get(2), 2); // Tomate Savanna; 9,98
        purchaseList.addItem(purchaseList.getProductList().get(0), 4); // Brausepulver Zuckerfrei; 15.96
        purchaseList.addItem(purchaseList.getProductList().get(8), 1); // Zucker-Ganglien; 45.32
        assertEquals(71.26, purchaseList.finishPurchase());
        assertEquals(32, purchaseList.getProductList().get(2).getStock());
        assertEquals(23, purchaseList.getProductList().get(0).getStock());
        assertEquals(14, purchaseList.getProductList().get(8).getStock());
    }

    /**
     * Test if the finishPurchase function works correctly.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
    @Test
    public void purchase2() throws Exception{
        purchaseList.addItem(purchaseList.getProductList().get(9), 1); // Grüne Bohnen Eintopf; 1.59
        purchaseList.addItem(purchaseList.getProductList().get(5), 3); // Mehl 405; 2.97
        purchaseList.addItem(purchaseList.getProductList().get(8), 7); // Apfelsaft Klar; 11.55
        assertEquals(16.11, purchaseList.finishPurchase());
        assertEquals(11, purchaseList.getProductList().get(2).getStock());
        assertEquals(50, purchaseList.getProductList().get(0).getStock());
        assertEquals(34, purchaseList.getProductList().get(8).getStock());
    }


}
