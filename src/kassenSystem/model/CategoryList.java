package kassenSystem.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class handles the CategoryDatabase and CategoryList
 */
public class CategoryList {
    private static final ArrayList<String> categoryList = new ArrayList<>();
    private final ProductList productList = new ProductList();
    private final Path path = Paths.get("out/production/kassen-system/kassenSystem/model/CategoryDatabase.txt");

    public CategoryList() {}

    /**
     * Add a category to the categoryList.
     * Checks if the category name is between 3 and 32 Symbols and does not contain any Number,
     * or punctuation symbol (/,.,_,etc.).
     * Throws an exception if the category does not meet the requirements.
     *
     * @param category   the new category
     * @throws Exception if the category is shorter then 3 or longer then 32 symbols,
     *                   or contains a number, or punctuation symbol
     */
    public void addCategory(String category) throws Exception {
        if(category.length() <= 32 && category.length() >= 3 && !category.matches("\\D") &&
                category.matches("([-&'äÄöÖüÜßa-zA-Z]*[\\s]*[-&'äÄöÖüÜßa-zA-Z]*)")) {
            categoryList.add(category);
            Collections.sort(categoryList);
        } else {
            throw new Exception("Der Name der Kategorie darf," +
                    " keine Zahlen und sonderzeichen enthalten," +
                    " und muss zwischen 3 und 32 Zeichen liegen." +
                    " Ihre eingabe " + category + " war fehlerhaft.");
        }
    }

    /**
     * Removes a category from the list.
     *
     * @param category the category to be removed
     */
    public void removeCategory(String category) throws Exception {
        int n = productList.getProductList().size();
        boolean removable = true;
        for (int i = 0; i < n - 1; i++)
            if (productList.getProduct(i).getCategory() == category) {
                removable = false;
            }
        if (removable) {
            categoryList.remove(category);
        } else {
            throw new Exception("Die Kategorie " + category + " ist nicht leer," +
                    " bitte leeren sie zuerst die Kategorie.");
        }
    }

    /**
     * Changes a category to a new category.
     *
     * @param category the category to be changed
     * @param newCategory the new category
     */
    public void changeCategory(String category, String newCategory) throws Exception {
        int n = productList.getProductList().size();
        this.addCategory(newCategory);
        for (int i = 0; i < n - 1; i++) {
            if (productList.getProduct(i).getCategory() == category) {
                productList.getProduct(i).setCategory(newCategory);
            }
        }
        this.removeCategory(category);
    }

    /**
     * Returns the category list.
     *
     * @return returns the category list
     */
    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    /**
     * Searches for a category in the category list.
     *
     * @param search the (sub)string of the search
     * @return an array of all categories that contained the (sub)string
     */
    public ArrayList<String> searchCategory(String search) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < categoryList.size() - 1; i++) {
            String category = categoryList.get(i);
            if (category.contains(search)) {
                result.add(category);
            }
        }
        return result;
    }

    /**
     * Searches for a category in categoryList.
     *
     * @param category the category you search for
     * @return true if the category is already in the list
     */
    public boolean categoryInList(String category) {
        return categoryList.contains(category);
    }

    /**
     * Saves all categories to the Database.
     * The save function will be executed only once when the application is closed,
     * because the way the category list is implemented represents an inMemory database.
     */
    public void saveToCategoryDatabase() throws Exception {
        PrintWriter pw = new PrintWriter(String.valueOf(path));
        pw.close();
        for(String category : categoryList) {
            String s = category;
            PrintWriter writer = new PrintWriter(new BufferedWriter(
                    new FileWriter(String.valueOf(path), true)));
            writer.println(s);
            writer.close();
        }
        categoryList.clear();
    }

    /**
     * Loads all Categories from the CategoryDatabase. WARNING Flaky behaviour!
     *
     * The load function will be executed only once when the application is started,
     * because the way the category list is implemented represents an inMemory database.
     * Throws IO Exception if there is no file or a wrong path declared to read from.
     *
     * @throws Exception if the the file the reader accesses is non existent
     */
    public void LoadFromCategoryDatabase() throws Exception {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.length() >= 3) {
                    this.addCategory(line);
                }
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}