package kassenSystem.model;

import java.util.ArrayList;

/**
 * This is a list of Products.
 */
public class ProductList {

    /**
     * This is
     */
    private static ArrayList<Product> productList;

    ProductList() {
        productList = new ArrayList<Product>();
    }

    /**
     * Adds a new product to the productList.
     * The parameters name, id, stock, weight and basePrice are entered by the user.
     * The category will be supplied by the category list and will not be entered separately.
     *
     * @param name the name of the new product
     * @param id the identification number of the new product
     * @param stock the amount of units of the new product
     * @param weight the weight of the product
     * @param basePrice the base price of the product
     * @param category the category the product will be assigned to
     */
    public void addProduct(String name, long id, int stock, float weight, String weightUnit,
                           float basePrice, String category) throws Exception {
        Product temp = new Product(name, id, stock, weight, weightUnit, basePrice, category);
        productList.add(temp);
    }

    /**
     * Returns the element at the specified index from productList.
     *
     * @param index specifies the position at which the element is found
     */
    public Product getProduct(int index) {
        return productList.get(index);
    }

    /**
     * Removes the element at the specified index from productList.
     *
     * @param index specifies the position at which the element is deleted
     */
    public void removeProduct(int index) {
        productList.remove(index);
    }

    /**
     * Sorts the products in productList alphabetically by their name in ascending order.
     */
    public void sortByName() {
        boolean swapped;
        int n = productList.size();
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getName().compareTo(productList.get(i + 1).getName()) > 0) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swapped = true;
                }
            }
            n = n - 1;
        } while (swapped);
    }

    /**
     * Sorts the products in productList numerically by their id in ascending order.
     */
    public void sortById() {
        boolean swapped;
        int n = productList.size();
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getId() > productList.get(i+1).getId()) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swapped = true;
                }
            }
            n = n - 1;
        } while (swapped);
    }

    /**
     * Sorts the products in productList numerically by their stock in ascending order.
     */
    public void sortByStock() {
        boolean swapped;
        int n = productList.size();
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getStock() > productList.get(i+1).getStock()) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swapped = true;
                }
            }
            n = n - 1;
        } while (swapped);
    }

    /**
     * Sorts the products in productList numerically by their weight in ascending order.
     */
    public void sortByWeight() {
        boolean swapped;
        int n = productList.size();
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getWeight() > productList.get(i+1).getWeight()) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swapped = true;
                }
            }
            n = n - 1;
        } while (swapped);
    }

    /**
     * Sorts the products in productList numerically by their price in ascending order.
     */
    public void sortByPrice() {
        boolean swapped;
        int n = productList.size();
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getPrice() > productList.get(i+1).getPrice()) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swapped = true;
                }
            }
            n = n - 1;
        } while (swapped);
    }

    /**
     * Sorts the products in productList numerically by their base price in ascending order.
     */
    public void sortByBasePrice() {
        boolean swapped;
        int n = productList.size();
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getBasePrice() > productList.get(i+1).getBasePrice()) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swapped = true;
                }
            }
            n = n - 1;
        } while (swapped);
    }

    /**
     * Sorts the products in productList alphabetically by their category in ascending order.
     */
    public void sortByCategory() {
        boolean swapped;
        int n = productList.size();
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getCategory().compareTo(
                        productList.get(i + 1).getCategory()) > 0) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swapped = true;
                }
            }
            n = n - 1;
        } while (swapped);
    }

    /**
     * Searches the productList for all products whose name includes,
     * or is equal to the search phrase.
     *
     * @param search The search phrase that is looked for in the productList
     * @return a list of products with the same name as the search phrase,
     *         or where the given search phrase is part of the name
     */
    public ArrayList<Product> searchProduct(String search) {
        ArrayList<Product> result = new ArrayList<Product>();
        CharSequence sequence = search.subSequence(0,search.length() - 1);
        for (int i = 0; i < productList.size() - 1; i++) {
            Product temp = productList.get(i);
            if (temp.getName().contains(sequence)) {
                result.add(temp);
            }
        }
        return result;
    }

    /**
     * Parses the database for Products and adds them to the productList.
     */
    public void getProducts() {

    }
}
