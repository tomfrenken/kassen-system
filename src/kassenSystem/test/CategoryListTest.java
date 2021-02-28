package kassenSystem.test;

import kassenSystem.model.CategoryList;
import kassenSystem.model.Product;
import kassenSystem.model.ProductList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the categoryList.
 */
public class CategoryListTest {

    private final CategoryList categoryList = new CategoryList();
    private final ProductList productList = new ProductList();

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
    }

    /**
     * Test if the addCategory function works correctly.
     * Throws Exception if the category is shorter then 3 or longer then 32 symbols,
     * or contains a number, or punctuation symbol.
     *
     * @throws Exception if the category is shorter then 3 or longer then 32 symbols,
     *                   or contains a number, or punctuation symbol
     */
    @Test
    public void addCategory() throws Exception {
        Throwable exceptionForNotUniqueName = assertThrows(Exception.class, () -> categoryList.addCategory("Obst"));
        Throwable exceptionForTooShortName = assertThrows(Exception.class, () -> categoryList.addCategory("O"));
        Throwable exceptionForTooLongName = assertThrows(Exception.class, () -> categoryList.addCategory("ooooooooooooooooooooooooooooooooo"));
        Throwable exceptionForIllegalSymbol = assertThrows(Exception.class, () -> categoryList.addCategory("Obst1"));

        categoryList.addCategory("Elektronik");
        assertEquals("Elektronik", categoryList.getCategoryList().get(2));
        assertEquals("Der Name der Kategorie muss einzigartig sein, darf keine Zahlen und sonderzeichen enthalten, und muss zwischen 3 und 32 Zeichen liegen. Ihre eingabe Obst war fehlerhaft.", exceptionForNotUniqueName.getMessage());
        assertEquals("Der Name der Kategorie muss einzigartig sein, darf keine Zahlen und sonderzeichen enthalten, und muss zwischen 3 und 32 Zeichen liegen. Ihre eingabe O war fehlerhaft.", exceptionForTooShortName.getMessage());
        assertEquals("Der Name der Kategorie muss einzigartig sein, darf keine Zahlen und sonderzeichen enthalten, und muss zwischen 3 und 32 Zeichen liegen. Ihre eingabe ooooooooooooooooooooooooooooooooo war fehlerhaft.", exceptionForTooLongName.getMessage());
        assertEquals("Der Name der Kategorie muss einzigartig sein, darf keine Zahlen und sonderzeichen enthalten, und muss zwischen 3 und 32 Zeichen liegen. Ihre eingabe Obst1 war fehlerhaft.", exceptionForIllegalSymbol.getMessage());
    }

    /**
     * Test if the removeCategory function works correctly.
     * Throws Exception if the category that is being removed is still used by any product
     * in the productList.
     *
     * @throws Exception if the category that is being removed is still used by any product
     *                   in the productList
     */
    @Test
    public void removeCategory() throws Exception {
        Throwable exceptionForCategoryUsed = assertThrows(Exception.class, () -> categoryList.removeCategory("Süßwaren"));

        categoryList.addCategory("Test");
        categoryList.removeCategory("Test");
        assertEquals(8,categoryList.getCategoryList().size());
        assertEquals("Die Kategorie Süßwaren ist nicht leer, bitte leeren sie zuerst die Kategorie.", exceptionForCategoryUsed.getMessage());
    }

    /**
     * Test if the changeCategory function works correctly.
     * Throws Exception if the category name does not meet the requirements set by the
     * addCategory function.
     *
     * @throws Exception if the category name does not meet the requirements set by the
     *                   addCategory function
     */
    @Test
    public void changeCategory() throws Exception {
        categoryList.changeCategory("Aufstrich","Aufbau");
        assertEquals("Aufbau", categoryList.getCategoryList().get(0));
        assertEquals("Aufbau", productList.getProductList().get(8).getCategory());
    }

    /**
     * Test if the clear function works correctly.
     */
    @Test
    public void clear() {
        categoryList.clear();
        assertEquals(0, categoryList.getCategoryList().size());
    }

    /**
     * Test if the searchCategory function works correctly.
     */
    @Test
    public void searchCategory() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("Gemüse");
        testList.add("Getränke");
        testList.add("Gewürze");
        assertEquals(categoryList.searchCategory("Ge"), testList);
    }

    /**
     * Test if the categoryInList function works correctly.
     */
    @Test
    public void categoryInList() {
        assertTrue(categoryList.categoryInList("Gemüse"));
        assertFalse(categoryList.categoryInList("Tee"));
    }
}