package model;

import java.util.ArrayList;

public class ProductList {
    private ArrayList<Product> productList;

    ProductList() {
        productList = new ArrayList<Product>();
    }

    // unsorted adding to PL
    public void addProduct(String name, int id, int stock, float weight,
                           float price, float basePrice) {
        Product temp = new Product(name, id, stock, weight, price, basePrice);
        productList.add(temp);
    }

    public Product getProduct(int index) {
        return productList.get(index);
    }

    public void removeProduct(int index) {
        productList.remove(index);
    }
    // for every sorting new function
    public void sortProductList() {

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
