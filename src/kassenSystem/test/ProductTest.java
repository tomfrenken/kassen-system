package kassenSystem.test;

import kassenSystem.model.CategoryList;
import kassenSystem.model.Product;
import kassenSystem.model.ProductList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the product.
 */
public class ProductTest {

    private final CategoryList categoryList = new CategoryList();
    private final ProductList productList = new ProductList();
    Product apfel;
    Product apfel4;
    Product apfel5;
    Product apfel8;
    Product apfel13;

    /**
     * Initialize categoryList and productList with entries to perform the test on.
     * Initializes single products to perform the test on.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
    @BeforeEach
    public void setUp() throws Exception {
        categoryList.addCategory("Obst");
        categoryList.addCategory("Gemüse");
        productList.addProduct("Apfel4", 1234L, 1000, 100, "ml", 1.5 , "Obst");
        productList.addProduct("Apfel5", 94321L, 1000, 100, "stück", 1.5 , "Obst");
        productList.addProduct("Apfel8", 12345678L, "n", 100, "kg", 1.5 , "Obst");
        productList.addProduct("Apfel13", 1234567890123L, "N", 100, "l", 1.5 , "Obst");
        apfel = new Product("Apfel", 91234, 1000, 100, "g", 1.5 , "Obst");
        apfel4 = new Product("Apfel4", 1234, 1000, 100, "ml", 1.5 , "Obst");
        apfel5 = new Product("Apfel5", 94321, 1000, 100, "stück", 1.5 , "Obst");
        apfel8 = new Product("Apfel8", 12345678, "n", 100, "kg", 1.5 , "Obst");
        apfel13 = new Product("Apfel13", 1234567890123L, "N", 100, "l", 1.5 , "Obst");
    }

    /**
     * Clears categoryList and productList off all test entries.
     */
    @AfterEach
    public void tearDown() {
        categoryList.clear();
        productList.clear();
    }

    /**
     * Test if the Product constructor works correctly.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
    @Test
    public void Product() throws Exception {

        // Name Test
        // 1.Fall Länge des Namen
        Throwable exceptionForTooShortName = assertThrows(Exception.class, () -> new Product("1", 91234, 1000, 100, "g", 1.5 , "Obst"));
        Throwable exceptionForTooLongName = assertThrows(Exception.class, () -> new Product("123456789012345678901234567890123", 91234, 1000, 100, "g", 1.5 , "Obst"));

        assertTrue(2 <= apfel.getName().length() && apfel.getName().length() <= 32);
        assertEquals("Der Name muss 2 bis 32 Zeichen lang sein. Ihre Eingabe 1 war fehlerhaft.", exceptionForTooShortName.getMessage());
        assertEquals("Der Name muss 2 bis 32 Zeichen lang sein. Ihre Eingabe 123456789012345678901234567890123 war fehlerhaft.", exceptionForTooLongName.getMessage());

        // 2.Fall Zeichen aus denen der Name besteht
        Throwable exceptionForWrongNameSymbols = assertThrows(Exception.class, () -> new Product("§§§", 91234, 1000, 100, "g", 1.5 , "Obst"));

        assertTrue(apfel.getName().matches("[-&'äÄöÖüÜßa-zA-Z\\d]([-&'äÄöÖüÜßa-zA-Z\\d\\s]{0,30})[-&'äÄöÖüÜßa-zA-Z\\d]"));
        assertEquals("Der Name muss 2 bis 32 Zeichen lang sein. Ihre Eingabe §§§ war fehlerhaft.", exceptionForWrongNameSymbols.getMessage());

        // ID Test
        // 1.Fall Länge der ID
        Throwable exceptionForNotFourFiveEightThirteen = assertThrows(Exception.class, () -> new Product("Apfel", 123, 1000, 100, "g", 1.5 , "Obst"));
        Throwable exceptionForFiveAndNotLeadingNine = assertThrows(Exception.class, () -> new Product("Apfel", 81234, 1000, 100, "g", 1.5 , "Obst"));

        assertTrue(1000 <= apfel4.getId() && apfel4.getId() <= 9999);
        assertTrue(90000 <= apfel5.getId() && apfel5.getId() <= 99999);
        assertTrue(10000000 <= apfel8.getId() && apfel8.getId() <= 99999999);
        assertTrue(1000000000000L <= apfel13.getId() && apfel13.getId() <= 9999999999999L);
        assertEquals("Die ID muss eines der folgenden Formate erfuellen: 1) 13 Stellen oder 2) 4 Stellen oder 3) 5 Stellen mit führender 9 4) 8 Stellen Ihre Eingabe 123 war fehlerhaft.", exceptionForNotFourFiveEightThirteen);
        //assertEquals("Die ID muss eines der folgenden Formate erfuellen: 1) 13 Stellen oder 2) 4 Stellen oder 3) 5 Stellen mit führender 9 4) 8 Stellen Ihre Eingabe 81234 war fehlerhaft.", exceptionForFiveAndNotLeadingNine);

        // 2.Fall Vorhandensein der ID
        Throwable exceptionForFourNumbersLongEan = assertThrows(Exception.class, () -> productList.addProduct("Apfel4", 1234L, 1000, 100, "ml", 1.5 , "Obst"));
        Throwable exceptionForFiveNumbersLongEan = assertThrows(Exception.class, () -> productList.addProduct("Apfel5", 94321L, 1000, 100, "stück", 1.5 , "Obst"));
        Throwable exceptionForEightNumbersLongEan = assertThrows(Exception.class, () -> productList.addProduct("Apfel8", 12345678L, "n", 100, "kg", 1.5 , "Obst"));
        Throwable exceptionForThirteenNumbersLongEan = assertThrows(Exception.class, () -> productList.addProduct("Apfel13", 1234567890123L, "N", 100, "l", 1.5 , "Obst"));

        assertEquals("Die Produkt-ID 1234 wird bereits verwendet.", exceptionForFourNumbersLongEan.getMessage());
        assertEquals("Die Produkt-ID 94321 wird bereits verwendet.", exceptionForFiveNumbersLongEan.getMessage());
        assertEquals("Die Produkt-ID 12345678 wird bereits verwendet.", exceptionForEightNumbersLongEan.getMessage());
        assertEquals("Die Produkt-ID 1234567890123 wird bereits verwendet.", exceptionForThirteenNumbersLongEan.getMessage());

        // Bestand Test
        // Normal Fall
        Throwable exceptionForTooGreatStock = assertThrows(Exception.class, () -> new Product("Apfel", 91234, 1001, 100, "g", 1.5 , "Obst"));
        Throwable exceptionForTooSmallStock = assertThrows(Exception.class, () -> new Product("Apfel", 91234, -1, 100, "g", 1.5 , "Obst"));

        assertTrue(0 <= apfel.getStock() && apfel.getStock() <= 1000);
        assertEquals("Der Bestand muss im Bereich von einschließlich 0 bis einschließlich 1000 liegen. Ihre Eingabe 1001 war fehlerhaft.", exceptionForTooGreatStock.getMessage());
        assertEquals("Der Bestand muss im Bereich von einschließlich 0 bis einschließlich 1000 liegen. Ihre Eingabe -1 war fehlerhaft.", exceptionForTooSmallStock.getMessage());

        // Spezial Fall
        assertEquals("n", apfel8.getSpecialStock());
        assertEquals("N", apfel13.getSpecialStock());
        assertNull(apfel.getSpecialStock());

        // Gewicht Test
        Throwable exceptionForWeightNotInBoundsSetByWeightUnit = assertThrows(Exception.class, () -> new Product("Apfel", 91234, 1000, 0, "g", 1.5 , "Obst"));

        assertTrue(1 <= apfel.getWeight() && apfel.getWeight() <= 100000);      // g
        assertTrue(1 <= apfel4.getWeight() && apfel4.getWeight() <= 100000);    // ml
        assertTrue(0.1 <= apfel5.getWeight() && apfel5.getWeight() <= 100);     // kg
        assertTrue(0.1 <= apfel8.getWeight() && apfel8.getWeight() <= 100);     // l
        assertTrue(1 <= apfel13.getWeight() && apfel13.getWeight() <= 1000);    // stück
        assertEquals("Das Gewicht in g muss im Bereich von einschließlich 1 bis einschließlich 100.000 liegen. Ihre Eingabe 0.0 war fehlerhaft.", exceptionForWeightNotInBoundsSetByWeightUnit.getMessage());

        // Preis Test
        Throwable exceptionForTooBigPrice = assertThrows(Exception.class, () -> new Product("Apfel", 91234, 1000, 100, "g", 100000.1 , "Obst"));
        Throwable exceptionForTooSmallPrice = assertThrows(Exception.class, () -> new Product("Apfel", 91234, 1000, 100, "g", 0 , "Obst"));

        assertTrue(0.01 <= apfel.getPrice() && apfel.getPrice() <= 100000);
        assertEquals("Der Preis muss im Bereich von einschließlich 0.01 bis einschließlich 100000 liegen.", exceptionForTooBigPrice.getMessage());
        assertEquals("Der Preis muss im Bereich von einschließlich 0.01 bis einschließlich 100000 liegen.", exceptionForTooSmallPrice.getMessage());

        // BasePrice Test
        Throwable exceptionForTooBigBasePrice = assertThrows(Exception.class, () -> new Product("Apfel", 91234, "n", 100, "g", 100000.1 , "Obst"));
        Throwable exceptionForTooSmallBasePrice = assertThrows(Exception.class, () -> new Product("Apfel", 91234, "n", 100, "g", 0 , "Obst"));

        assertTrue(0.01 <= apfel8.getBasePrice() && apfel.getBasePrice() <= 100000);
        assertEquals("Der Grundpreis muss im Bereich von einschließlich 0.01 bis einschließlich 100.000 liegen. Ihr aktueller Grundpreis lautet: 100000.1", exceptionForTooBigBasePrice.getMessage());
        assertEquals("Der Grundpreis muss im Bereich von einschließlich 0.01 bis einschließlich 100.000 liegen. Ihr aktueller Grundpreis lautet: 0.0", exceptionForTooSmallBasePrice.getMessage());
    }

    /**
     * Test if the setName function works correctly.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
    @Test
    public void setName() throws Exception {
        // 1.Fall Länge des Namen
        Throwable exceptionForTooShortName = assertThrows(Exception.class, () -> apfel.setName("1"));
        Throwable exceptionForTooLongName = assertThrows(Exception.class, () -> apfel.setName("123456789012345678901234567890123"));

        apfel.setName("Apfel");
        assertTrue(2 <= apfel.getName().length() && apfel.getName().length() <= 32);
        assertEquals("Der Name muss zwischen 2 und 32 zeichen lang sein  Ihre Eingabe 1 war fehlerhaft.", exceptionForTooShortName.getMessage());
        assertEquals("Der Name muss zwischen 2 und 32 zeichen lang sein  Ihre Eingabe 123456789012345678901234567890123 war fehlerhaft.", exceptionForTooLongName.getMessage());

        // 2.Fall Zeichen aus denen der Name besteht
        Throwable exceptionForWrongNameSymbols = assertThrows(Exception.class, () -> apfel.setName("§§§"));

        apfel.setName("Apfel");
        assertTrue(apfel.getName().matches("[-&'äÄöÖüÜßa-zA-Z\\d]([-&'äÄöÖüÜßa-zA-Z\\d\\s]{0,30})[-&'äÄöÖüÜßa-zA-Z\\d]"));
        assertEquals("Der Name muss zwischen 2 und 32 zeichen lang sein  Ihre Eingabe §§§ war fehlerhaft.", exceptionForWrongNameSymbols.getMessage());
    }

    /**
     * Test if the setId function works correctly.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
    @Test
    public void setId() throws Exception {
        // 1.Fall Länge der ID
        Throwable exceptionForNotFourFiveEightThirteen = assertThrows(Exception.class, () -> apfel.setId(123));
        Throwable exceptionForFiveAndNotLeadingNine = assertThrows(Exception.class, () -> apfel.setId(81234));

        apfel4.setId(1234);
        apfel5.setId(91234);
        apfel8.setId(12345678);
        apfel13.setId(1234567890123L);
        assertTrue(1000 <= apfel4.getId() && apfel4.getId() <= 9999);
        assertTrue(90000 <= apfel5.getId() && apfel5.getId() <= 99999);
        assertTrue(10000000 <= apfel8.getId() && apfel8.getId() <= 99999999);
        assertTrue(1000000000000L <= apfel13.getId() && apfel13.getId() <= 9999999999999L);
        // assertEquals("Die ID muss eines der folgenden Formate erfuellen: 1) 13 Stellen oder 2) 4 Stellen oder 3) 5 Stellen mit führender 9 4) 8 Stellen Ihre Eingabe 123 war fehlerhaft.", exceptionForNotFourFiveEightThirteen);
        // assertEquals("Die ID muss eines der folgenden Formate erfuellen: 1) 13 Stellen oder 2) 4 Stellen oder 3) 5 Stellen mit führender 9 4) 8 Stellen Ihre Eingabe 81234 war fehlerhaft.", exceptionForFiveAndNotLeadingNine);
    }

    /**
     * Test if the setStock function works correctly.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
    @Test
    public void setStock() throws Exception {
        // Normal Fall
        Throwable exceptionForTooGreatStock = assertThrows(Exception.class, () -> apfel.setStock(1001));
        Throwable exceptionForTooSmallStock = assertThrows(Exception.class, () -> apfel.setStock(-1));
        Throwable exceptionForSpecialStockActive = assertThrows(Exception.class, () -> apfel8.setStock(1));

        apfel.setStock(1000);
        assertTrue(0 <= apfel.getStock() && apfel.getStock() <= 1000);
        assertEquals("Der Bestand muss im Bereich von einschließlich 0 bis einschließlich 1000 liegen. Ihre Eingabe 1001 war fehlerhaft.", exceptionForTooGreatStock.getMessage());
        assertEquals("Der Bestand muss im Bereich von einschließlich 0 bis einschließlich 1000 liegen. Ihre Eingabe -1 war fehlerhaft.", exceptionForTooSmallStock.getMessage());
        assertEquals("Der Spezialfall ist aktiviert. Diese Operation ist nicht möglich.", exceptionForSpecialStockActive.getMessage());
    }

    /**
     * Test if the setWeight function works correctly.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
    @Test
    public void setWeight() throws Exception {
        Throwable exceptionForWeightNotInBoundsSetByWeightUnit = assertThrows(Exception.class, () -> apfel.setWeight(0));

        apfel.setWeight(100);
        apfel4.setWeight(100);
        apfel5.setWeight(100);
        apfel8.setWeight(100);
        apfel13.setWeight(100);
        assertTrue(1 <= apfel.getWeight() && apfel.getWeight() <= 100000);      // g
        assertTrue(1 <= apfel4.getWeight() && apfel4.getWeight() <= 100000);    // ml
        assertTrue(0.1 <= apfel5.getWeight() && apfel5.getWeight() <= 100);     // kg
        assertTrue(0.1 <= apfel8.getWeight() && apfel8.getWeight() <= 100);     // l
        assertTrue(1 <= apfel13.getWeight() && apfel13.getWeight() <= 1000);    // stück
        assertEquals("Das Gewicht in g muss im Bereich 1 bis 100.000 liegen. Ihre Eingabe 0.0 war fehlerhaft.", exceptionForWeightNotInBoundsSetByWeightUnit.getMessage());
    }

    /**
     * Test if the setPrice function works correctly.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
    @Test
    public void setPrice() throws Exception {
        Throwable exceptionForTooBigPrice = assertThrows(Exception.class, () -> apfel.setPrice(100000.1));
        Throwable exceptionForTooSmallPrice = assertThrows(Exception.class, () -> apfel.setPrice(0));

        apfel.setPrice(1.5);
        assertTrue(0.01 <= apfel.getPrice() && apfel.getPrice() <= 100000);
        assertEquals("Der Preis muss im Bereich zwischen 0.01 und 100.000 liegen. Ihre Eingabe 100000.1 war fehlerhaft.", exceptionForTooBigPrice.getMessage());
        assertEquals("Der Preis muss im Bereich zwischen 0.01 und 100.000 liegen. Ihre Eingabe 0.0 war fehlerhaft.", exceptionForTooSmallPrice.getMessage());
    }

    /**
     * Test if the setBasePrice function works correctly.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
    @Test
    public void setBasePrice() throws Exception {
        Throwable exceptionForTooBigBasePrice = assertThrows(Exception.class, () -> apfel8.setBasePrice(100000.1));
        Throwable exceptionForTooSmallBasePrice = assertThrows(Exception.class, () -> apfel8.setBasePrice(0));

        apfel8.setBasePrice(1.5);
        assertTrue(0.01 <= apfel8.getBasePrice() && apfel8.getBasePrice() <= 100000);
        assertEquals("Der Grundpreis muss zwischen 0.01 und 100.000 liegen.Ihre Eingabe 100000.1 war fehlerhaft.", exceptionForTooBigBasePrice.getMessage());
        assertEquals("Der Grundpreis muss zwischen 0.01 und 100.000 liegen.Ihre Eingabe 0.0 war fehlerhaft.", exceptionForTooSmallBasePrice.getMessage());
    }

    /**
     * Test if the setCategory function works correctly.
     * Throws Exception if a constraint regarding the content of an attribute has been violated.
     *
     * @throws Exception if a constraint regarding the content of an attribute has been violated
     */
    @Test
    public void setCategory() throws Exception {
        Throwable exceptionForNonExistentCategory = assertThrows(Exception.class, () -> apfel.setCategory("O"));

        apfel.setCategory("Gemüse");
        assertEquals("Gemüse", apfel.getCategory());
        assertEquals("Die Kategorie O existiert nicht.", exceptionForNonExistentCategory.getMessage());
    }

    /**
     * Test if the toString function works correctly.
     */
    @Test
    public void toStringTest() {
        assertEquals("91234 Apfel 1.5 1000 Obst 1.5€ 100.0g", apfel.toString());
    }
}
