package kassenSystem.model;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This is a list of Products.
 */
public class ProductList {

    /**
     * This is the product list.
     */
    private static final ArrayList<Product> productList = new ArrayList<>();
    Path path = Paths.get("kassenSystem/model/Database.txt");

    ProductList() {}

    /**
     * Adds a new product to the productList.
     * The parameters name, id, stock, weight and basePrice are entered by the user.
     * The category will be supplied by the category list and will not be entered separately.
     *
     * @param name the name of the new product
     * @param id the identification number of the new product
     * @param stock the amount of units of the new product
     * @param weight the weight of the product
     * @param price the base price of the product
     * @param category the category the product will be assigned to
     * @throws Exception When the product id is already in the list
     */
    // needs to handle both price and basePrice
    public void addProduct(String name, long id, int stock, float weight, String weightUnit,
                           float price, String category) throws Exception {
         if (productList.size() > 0) {
             for (Product product : productList) {
                 if (product.getId() == id) {
                     throw new Exception("Die Produkt-ID " + id + " wird bereits verwendet.");
                 }
             }
             Product temp = new Product(name, id, stock, weight, weightUnit, price, category);
             productList.add(temp);
             addToDatabase(temp);
        } else {
            Product temp = new Product(name, id, stock, weight, weightUnit, price, category);
            productList.add(temp);
             addToDatabase(temp);
        }
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
                    Product temp = productList.get(i+1);
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
                    Product temp = productList.get(i+1);
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
                    Product temp = productList.get(i+1);
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
                    Product temp = productList.get(i+1);
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
                    Product temp = productList.get(i+1);
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
                    Product temp = productList.get(i+1);
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
                    Product temp = productList.get(i+1);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swapped = true;
                }
            }
            n = n - 1;
        } while (swapped);
    }

    /**
     *
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
     * Adds a new product entry to the database.
     *
     * @param product
     */
    public void addToDatabase(Product product) throws IOException {
        String s = String.format("%13d %32s %4d %8.2f %5s  %8.2f %8.2f %32s",product.getId(),product.getName(),product.getStock(),product.getWeight(),product.getWeightUnit(),product.getPrice(),product.getBasePrice(),product.getCategory());
        //"%1$13d %2$32s %3$4d %4$6f.2 %5$5s  %6$6f.2 %7$6f.2 %8$32s", s
        //"%13d %32s %4d %6f.2 %5s  %6f.2 %6f.2 %32s",product.getId(),product.getName(),product.getStock(),product.getWeight(),product.getWeightUnit(),product.getPrice(),product.getBasePrice(),product.getCategory()

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(String.valueOf(path), true)));
        pw.println(s);
        pw.close();
    }

    /**
     * Updates a product entry in the database.
     *
     * @param product
     */
    public void updateInDatabase(Product product) {}

    /**
     * Removes a product entry from the database.
     *
     * @param product
     */
    public void removeFromDatabase(Product product) {}

    /**
     * Reads a product entry from the database
     */
    public void readFromDatabase() {
        Charset charset = StandardCharsets.UTF_8;
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }
}
