package model;

import java.util.ArrayList;

public class ProductList {
    private ArrayList<Product> productList;

    ProductList() {
        productList = new ArrayList<Product>();
    }

    // unsorted adding to PL
    public void addProduct(String name, int id, int stock, float weight,
                           float price, float basePrice, Category category) {
        Product temp = new Product(name, id, stock, weight, price, basePrice, category);
        productList.add(temp);
    }

    public Product getProduct(int index) {
        return productList.get(index);
    }

    public void removeProduct(int index) {
        productList.remove(index);
    }

    /**
     *
     */
    public void sortName() {
        boolean swaped;
        int n = productList.size();
        do {
            swaped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getName().compareTo(productList.get(i + 1).getName()) > 0) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swaped = true;
                }
            }
            n = n - 1;
        } while (swaped);
    }

    /**
     *
     */
    public void sortId() {
        boolean swaped;
        int n = productList.size();
        do {
            swaped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getId() > productList.get(i+1).getId()) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swaped = true;
                }
            }
            n = n - 1;
        } while (swaped);
    }

    /**
     *
     */
    public void sortStock() {
        boolean swaped;
        int n = productList.size();
        do {
            swaped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getStock() > productList.get(i+1).getStock()) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swaped = true;
                }
            }
            n = n - 1;
        } while (swaped);
    }

    /**
     *
     */
    public void sortWeight() {
        boolean swaped;
        int n = productList.size();
        do {
            swaped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getWeight() > productList.get(i+1).getWeight()) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swaped = true;
                }
            }
            n = n - 1;
        } while (swaped);
    }

    /**
     *
     */
    public void sortPrice() {
        boolean swaped;
        int n = productList.size();
        do {
            swaped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getPrice() > productList.get(i+1).getPrice()) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swaped = true;
                }
            }
            n = n - 1;
        } while (swaped);
    }

    /**
     *
     */
    public void sortBasePrice() {
        boolean swaped;
        int n = productList.size();
        do {
            swaped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getBasePrice() > productList.get(i+1).getBasePrice()) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swaped = true;
                }
            }
            n = n - 1;
        } while (swaped);
    }

    /**
     *
     */
    public void sortCategory() {
        boolean swaped;
        int n = productList.size();
        do {
            swaped = false;
            for (int i = 0; i < n - 1; i++) {
                if (productList.get(i).getCategory().getName().compareTo(
                        productList.get(i + 1).getCategory().getName()) > 0) {
                    Product temp = productList.get(i);
                    productList.set(i+1,productList.get(i));
                    productList.set(i,temp);
                    swaped = true;
                }
            }
            n = n - 1;
        } while (swaped);
    }

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

    // get Products from database
    public void getProducts() {

    }
}
