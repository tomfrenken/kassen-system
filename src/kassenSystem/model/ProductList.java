package kassenSystem.model;

import java.io.*;
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
     * The path is the path to the database.
     */
    private static final ArrayList<Product> productList = new ArrayList<>();
    private final Path path = Paths.get("kassenSystem/model/ProductDatabase.txt");

    public ProductList() {}

    /**
     * Adds a new product to the productList.
     * The parameters name, id, stock, weight and basePrice are entered by the user.
     * The category will be supplied by the category list and will not be entered separately.
     *
     * @param name the name of the new product
     * @param id the identification number of the new product
     * @param stock the amount of units of the new product
     * @param weight the weight of the product
     * @param weightUnit the unit of the given weight e.g. g,kg,ml,l,stück
     * @param price the base price of the product
     * @param category the category the product will be assigned to
     * @throws Exception When the product id is already in the list
     */
    // needs to handle both price and basePrice
    public void addProduct(String name, long id, int stock, double weight, String weightUnit,
                           double price, String category) throws Exception {
         if (productList.size() > 0) {
             for (Product product : productList) {
                 if (product.getId() == id) {
                     throw new Exception("Die Produkt-ID " + id + " wird bereits verwendet.");
                 }
             }
             Product temp = new Product(name, id, stock, weight, weightUnit, price, category);
             productList.add(temp);
         } else {
             Product temp = new Product(name, id, stock, weight, weightUnit, price, category);
             productList.add(temp);
         }
    }
    /**
     * Adds a new product to the productList.
     * The parameters name, id, stock, weight and basePrice are entered by the user.
     * The category will be supplied by the category list and will not be entered separately.
     *
     * @param name the name of the new product
     * @param id the identification number of the new product
     * @param specialStock the amount of units of the new product
     * @param weight the weight of the product
     * @param weightUnit the unit of the given weight e.g. g,kg,ml,l,stück
     * @param basePrice the base price of the product
     * @param category the category the product will be assigned to
     */
    // needs to handle both price and basePrice
    public void addProduct(String name, long id, String specialStock, double weight,
                           String weightUnit, double basePrice, String category) throws Exception {
        if (productList.size() > 0) {
            for (Product product : productList) {
                if (product.getId() == id) {
                    throw new Exception("Die Produkt-ID " + id + " wird bereits verwendet.");
                }
            }
            Product temp = new Product(name, id, specialStock, weight, weightUnit, basePrice,
                    category);
            productList.add(temp);
        } else {
            Product temp = new Product(name, id, specialStock, weight, weightUnit, basePrice,
                    category);
            productList.add(temp);

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
     * Searches the productList for a product with this name.
     *
     * @param search The search phrase that is looked for in the productList
     * @return a list of products with the same name as the search phrase,
     *         or where the given search phrase is part of the name
     */
    public ArrayList<Product> searchProduct(String search) {
        ArrayList<Product> result = new ArrayList<>();
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
     * Saves all products to the ProductDatabase.
     *
     * The save function will be executed only once when the application is closed,
     * because the way the product list is implemented represents an inMemory database.
     */
    public void saveToProductDatabase() throws Exception {
        PrintWriter pw = new PrintWriter(String.valueOf(path));
        pw.close();
        for(Product product : productList) {
            String s;
            if(product.getSpecialStock() == null) {
                s = String.format("%d %s %d %.2f %s %.2f %.2f %s", product.getId(),
                        product.getName(), product.getStock(), product.getWeight(),
                        product.getWeightUnit(), product.getPrice(), product.getBasePrice(),
                        product.getCategory());
            }else {
                s = String.format("%d %s %s %.2f %s %.2f %.2f %s", product.getId(),
                        product.getName(), product.getSpecialStock(), product.getWeight(),
                        product.getWeightUnit(), product.getPrice(), product.getBasePrice(),
                        product.getCategory());
            }
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(String.valueOf(path), true)));
            writer.println(s);
            writer.println();
            writer.close();
        }
    }

    /**
     * Loads all Products from the ProductDatabase.
     *
     * The load function will be executed only once when the application is started,
     * because the way the product list is implemented represents an inMemory database.
     * Throws IO Exception if there is no file or a wrong path declared to read from.
     *
     * @throws Exception if the the file the reader accesses is non existent
     */
    public void LoadFromProductDatabase() throws Exception {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            String[] paraList;
            while ((line = reader.readLine()) != null) {
                line = line.replace(",",".");
                paraList = line.split(" ");
                if (paraList.length == 8) {
                    if (!paraList[2].equals("n")){
                        this.addProduct(paraList[1], Long.parseLong(paraList[0]),
                                Integer.parseInt(paraList[2]), Double.parseDouble(paraList[3]),
                                paraList[4], Double.parseDouble(paraList[5]), paraList[7]);
                    }else {
                        this.addProduct(paraList[1], Long.parseLong(paraList[0]), paraList[2],
                                Double.parseDouble(paraList[3]), paraList[4],
                                Double.parseDouble(paraList[6]), paraList[7]);
                    }
                }
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    /**
     * Returns the productList.
     *
     * @return the productList
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }
}
