package kassenSystem.test;

import kassenSystem.model.CategoryList;
import kassenSystem.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test for item.
 */
public class ItemTest {

    private final CategoryList categoryList = new CategoryList();
    Product apfel;

    /**
     * Creates a test entry to perform tests on.
     *
     * @throws Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        categoryList.addCategory("Obst");
        apfel = new Product("Apfel", 1234, 100, 10, "g", 10, "Obst");
    }

    @AfterEach
    public void tearDown() {
        categoryList.clear();
    }

}
