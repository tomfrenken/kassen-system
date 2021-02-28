package kassenSystem.model;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This is the list of Products currently in stock.
 */
public class ProductList extends AbstractTableModel {

    /**
     * The productList attribute is the productList.
     * The path attribute is the path to the productDatabase.
     */
    private static final ArrayList<Product> productList = new ArrayList<>();
    private final Path path = Paths.get(
            "out/production/kassen-system/kassenSystem/model/ProductDatabase.txt");

    /**
     * ProductList constructor.
     */
    public ProductList() {}

    /**
     * Adds a new product to the productList.
     * The parameters name, id, stock, weight and Price are entered by the user.
     * The weightUnit and category are selected from a dropdown menu.
     * The category will be supplied by the category list and will not be entered separately.
     * Throws Exception if the product id is already used by a product in the list.
     *
     * @param name       the name of the new product
     * @param id         the identification number of the new product
     * @param stock      the amount of units of the new product
     * @param weight     the weight of the product
     * @param weightUnit the unit of the given weight e.g. g,kg,ml,l,stück
     * @param price      the price of the product
     * @param category   the category the product will be assigned to
     * @throws Exception if the product id is already used by a product in the list
     */
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
        this.sortById();
        this.fireTableStructureChanged();
    }

    /**
     * Adds a new product to the productList.
     * The parameters name, id, specialStock, weight and basePrice are entered by the user.
     * The weightUnit and category are selected from a dropdown menu.
     * The category will be supplied by the category list and will not be entered separately.
     * Throws Exception if the product id is already used by a product in the list.
     *
     * @param name         the name of the new product
     * @param id           the identification number of the new product
     * @param specialStock The special case where a product can not be counted,
     *                     has to be either n or N
     * @param weight       the weight of the product
     * @param weightUnit   the unit of the given weight e.g. g,kg,ml,l,stück
     * @param basePrice    the base price of the product
     * @param category     the category the product will be assigned to
     * @throws Exception   if the product id is already used by a product in the list
     */
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
        this.sortById();
        this.fireTableStructureChanged();
    }

    /**
     * Returns the element at the specified index from productList.
     *
     * @param index specifies the position at which the element is found
     * @return      the product at the index position
     */
    public Product getProduct(int index) {
        return productList.get(index);
    }

    /**
     * Removes the element at the specified index from productList.
     *
     * @param i specifies the position at which the element is deleted
     */
    public void removeProductByIndex(int i) {
        productList.remove(i);
        this.fireTableStructureChanged();
    }

    /**
     * Removes the specified product from the productList.
     * Throws Exception if the remove function is not used correctly or a wrong type of
     * element that is being removed is supplied.
     *
     * @param product    the product that shall be removed
     * @throws Exception if the remove function is not used correctly or a wrong type of
     *                   element that is being removed is supplied
     */
    public void removeProduct(Product product) throws Exception {
        productList.remove(product);
        this.fireTableStructureChanged();
    }

    /**
     * Empties the productList of all stored products.
     */
    public void clear() {
        this.getProductList().clear();
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
        this.fireTableDataChanged();
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
        this.fireTableDataChanged();
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
        this.fireTableDataChanged();
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
        this.fireTableDataChanged();
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
        this.fireTableDataChanged();
    }

    /**
     * Sorts the products in productList numerically by their basePrice in ascending order.
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
        this.fireTableDataChanged();
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
        this.fireTableDataChanged();
    }

    /**
     * Searches the productList for a product with this name.
     * The entered search phrase can be a substring of the results or a specific name.
     *
     * @param searchPhrase the search phrase that is looked for in the productList
     * @return             a list of products with the same name as the search phrase,
     *                     or where the given search phrase is part of the name
     */
    public ArrayList<Product> searchProductByName(String searchPhrase) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if(product.getName().contains(searchPhrase)){
                result.add(product);
            }
        }
        return result;
    }

    /**
     * Searches the productList for a product with this id.
     * The entered search phrase can be a partial id of the results or a specific id.
     *
     * @param id the id of a product
     * @return   a list of products with the same id as the search phrase,
     *           or where the given search phrase is part of the id
     */
    public ArrayList<Product> searchProductById(Long id) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if(Long.toString(product.getId()).contains(Long.toString(id))) {
                result.add(product);
            }
        }
        return result;
    }

    /**
     * Searches the productList for a product with this name or id.
     * The search phrase can be a specific name or id of the results or it can be part of them.
     *
     * @param searchPhrase the search phrase that is looked for in the productList
     * @return             a list of product with the same name or id regarding what was searched
     *                     for, or where the search phrase is part of the name or id
     */
    public ArrayList<Product> searchProduct(String searchPhrase) {
        ArrayList<Product> productList;
        try{
            productList = this.searchProductById(Long.parseLong(searchPhrase));
        } catch(Exception e){
            productList = this.searchProductByName(searchPhrase);
        }
        return productList;
    }

    /**
     * Changes the parameters of a product in the database.
     * Throws Exception if a parameter violates the restrictions set in the addProduct function.
     *
     * @param index      the index of the product that shall be changed
     * @param name       the name of the new product
     * @param id         the identification number of the new product
     * @param stock      the amount of units of the new product
     * @param weight     the weight of the new product
     * @param weightUnit the unit of the given weight e.g. g,kg,ml,l,stück
     * @param price      the price of the new product
     * @param category   the category the new product will be assigned to
     * @throws Exception if a parameter violates the restrictions set in the addProduct function
     */
    public void changeProduct(int index, String name,  long id, int stock, double weight,
                              String weightUnit, double price, String category) throws Exception {
        Product temp = this.getProduct(index);
        this.removeProductByIndex(index);
        try {
            this.addProduct(name, id , stock, weight, weightUnit,
                    price, category);
        } catch (Exception e){
            this.addProduct(temp.getName(), temp.getId(), temp.getStock(),
                    temp.getWeight(), temp.getWeightUnit(), temp.getPrice(),
                    temp.getCategory());
            throw e;
        }
    }
    /**
     * Changes the parameters of a product in the database.
     * Throws Exception if a parameter violates the restrictions set in the addProduct function.
     *
     * @param index        the index of the product that shall be changed
     * @param name         the name of the new product
     * @param id           the identification number of the new product
     * @param specialStock The special case where a product can not be counted,
     *                     has to be either n or N
     * @param weight       the weight of the new product
     * @param weightUnit   the unit of the given weight e.g. g,kg,ml,l,stück
     * @param basePrice    the base price of the new product
     * @param category     the category the new product will be assigned to
     * @throws Exception   if a parameter violates the restrictions set in the addProduct function
     */
    public void changeProduct(int index, String name,  long id, String specialStock, double weight,
                              String weightUnit, double basePrice, String category) throws Exception {
        Product temp = this.getProduct(index);
        this.removeProductByIndex(index);
        try {
            this.addProduct(name, id , specialStock, weight, weightUnit,
                    basePrice, category);
        } catch (Exception e){
            this.addProduct(temp.getName(), temp.getId(), temp.getSpecialStock(), temp.getWeight(),
                    temp.getWeightUnit(), temp.getBasePrice(), temp.getCategory());
            throw e;
        }
    }

    /**
     * Saves all products to the ProductDatabase.
     * The save function will be executed only once when the application is closed,
     * because the way the product list is implemented represents an inMemory database.
     * Throws IOException if the the file the writer accesses is non existent.
     *
     * @throws Exception if the the file the writer accesses is non existent
     */
    public void saveToProductDatabase() throws Exception {
        PrintWriter pw = new PrintWriter(String.valueOf(path));
        pw.close();
        for(Product product : productList) {
            String s;
            if(product.getSpecialStock() == null) {
                s = String.format("%d|%s|%d|%.2f|%s|%.2f|%.2f|%s", product.getId(),
                        product.getName(), product.getStock(), product.getWeight(),
                        product.getWeightUnit(), product.getPrice(), product.getBasePrice(),
                        product.getCategory());
            }else {
                s = String.format("%d|%s|%s|%.2f|%s|%.2f|%.2f|%s", product.getId(),
                        product.getName(), product.getSpecialStock(), product.getWeight(),
                        product.getWeightUnit(), product.getPrice(), product.getBasePrice(),
                        product.getCategory());
            }
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(String.valueOf(path), true)));
            writer.println(s);
            writer.close();
        }
    }

    /**
     * Loads all Products from the ProductDatabase.
     * The load function will be executed only once when the application is started,
     * because the way the product list is implemented represents an inMemory database.
     * Throws IO Exception if there is no file or a wrong path declared to read from.
     *
     * @throws Exception if the the file the reader accesses is non existent
     */
    public void loadFromProductDatabase() throws Exception {
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            String line;
            String[] paraList;
            while ((line = reader.readLine()) != null) {
                line = line.replace(",",".");
                paraList = line.split("\\|");
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

    /**
     * Returns the number of rows in the model.
     * A <code>JTable</code> uses this method to determine how many rows it should display.
     * This method should be quick, as it is called frequently during rendering.
     *
     * @return the number of rows in the model
     * @see    #getColumnCount
     */
    @Override
    public int getRowCount() {
        return this.getProductList().size();
    }

    /**
     * Returns the number of columns in the model.
     * A <code>JTable</code> uses this method to determine how many columns it
     * should create and display by default.
     *
     * @return the number of columns in the model
     * @see    #getRowCount
     */
    @Override
    public int getColumnCount() {
        return 8;
    }

    /**
     * Returns the value for the cell at <code>columnIndex</code> and <code>rowIndex</code>.
     *
     * @param rowIndex    the row whose value is to be queried
     * @param columnIndex the column whose value is to be queried
     * @return            the value Object at the specified cell
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        Product product = this.getProduct(rowIndex);
        if (product.getSpecialStock() == null) {
            switch (columnIndex) {
                case 0:
                    value = product.getId();
                    break;
                case 1:
                    value = product.getName();
                    break;
                case 2:
                    value = product.getPrice();
                    break;
                case 3:
                    value = product.getStock();
                    break;
                case 4:
                    value = product.getCategory();
                    break;
                case 5:
                    value = product.getBasePrice();
                    break;
                case 6:
                    value = product.getWeight();
                    break;
                case 7:
                    value = product.getWeightUnit();
            }
        } else {
            switch (columnIndex) {
                case 0:
                    value = product.getId();
                    break;
                case 1:
                    value = product.getName();
                    break;
                case 2:
                    value = product.getPrice();
                    break;
                case 3:
                    value = product.getSpecialStock();
                    break;
                case 4:
                    value = product.getCategory();
                    break;
                case 5:
                    value = product.getBasePrice();
                    break;
                case 6:
                    value = product.getWeight();
                    break;
                case 7:
                    value = product.getWeightUnit();
            }
        }
        return value;
    }

    /**
     * Returns the columnName of the column specified by the index.
     *
     * @param index specifies the column of which the name is returned
     * @return      the column name of the column with the given index
     */
    @Override
    public String getColumnName(int index) {
        String[] columnNames = {"EAN", "Name", "Preis", "Bestand", "Kategorie", "Grundpreis", "Gewicht",
                "Gewichtseineheit"};
        return columnNames[index];
    }
}
