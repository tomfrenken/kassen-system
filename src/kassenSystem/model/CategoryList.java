package kassenSystem.model;

import java.util.ArrayList;
import java.util.Collections;

public class CategoryList {
    private static final ArrayList<String> categoryList = new ArrayList<>();
    private final ProductList productList = new ProductList();

    public CategoryList() {}

    /**
     * Add a category to the categoryList.
     * Checks if the category name is between 3 and 32 Symbols and does not contain any Number,
     * or punctuation symbol (/,.,_,-,etc.).
     * Throws an exception if the category does not meet the requirements.
     *
     * @param category   The new category.
     * @throws Exception if the category is shorter then 3 or longer then 32 symbols,
     *                   or contains a number, or punctuation symbol
     */
    public void addCategory(String category) throws Exception {
        if(category.length() <= 32 && category.length() >= 3 && !category.matches("\\D") &&
                category.matches("([öÖäÄüÜßa-zA-Z&'-]+(\\s?[öÖäÄüÜßa-zA-Z&'-]+\\s?)*[öÖäÄüÜßa-zA-Z&'-]+)")) {
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
     * @param category The category to be removed.
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
     * @param category The category to be changed.
     * @param newCategory The new category.
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
     * @return returns the category list.
     */
    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    /**
     * Searches for a category in the category list.
     *
     * @param search The (sub)string of the search.
     * @return An array of all categories that contained the (sub)string.
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
     * @param category The category you search for.
     * @return True if the category is already in the list.
     */
    public boolean categoryInList(String category) {
        return categoryList.contains(category);
    }
}