package model;

import java.util.ArrayList;
import java.util.Collections;

public class CategoryList {
    private ArrayList<String> categoryList;

    CategoryList() {
        categoryList = new ArrayList<>();
    }

    /**
     * Add a category to the categoryList.
     *
     * @param category The new category.
     */
    public void addCategory(String category) {
        categoryList.add(category);
        Collections.sort(categoryList);
    }

    /**
     * Removes a category from the list.
     *
     * @param category The category to be removed.
     */
    public void removeCategory(String category) {
        categoryList.remove(category);
    }

    /**
     * Changes a category to a new category.
     *
     * @param category The category to be changed.
     * @param newCategory The new category.
     */
    public void changeCategory(String category, String newCategory) {
        this.removeCategory(category);
        this.addCategory(newCategory);
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
        ArrayList<String> result = new ArrayList<String>();
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
        if (categoryList.contains(category)){
            return true;
        } else {
            return false;
        }
    }
}