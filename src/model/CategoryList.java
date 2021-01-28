package model;

import java.util.ArrayList;

public class CategoryList {
    private ArrayList<Category> categoryList;

    CategoryList() {
        categoryList = new ArrayList<>();
    }

    public void setCategory(String name) {
        for (int i = 0; i < categoryList.size() - 1; i++) {
            Category temp = categoryList.get(i);
            if (temp.getName().compareTo(name) > 0) {
                categoryList.add(i,temp);
                break;
            } else {
                i++;
            }
        }
    }

    public void removeCategory(int index) {
        Category temp = categoryList.get(index);
        categoryList.remove(temp);
    }

    public void changeCategory(int index, String name) {
        Category temp = categoryList.get(index);
        temp.setName(name);
    }

    public ArrayList<Category> showList() {
        return categoryList;
    }

    public ArrayList<Category> getCategory(String search) {
        ArrayList<Category> result = new ArrayList<>();
        CharSequence sequence = search.subSequence(0,search.length() - 1);
        for (int i = 0; i < categoryList.size() - 1; i++) {
            Category temp = categoryList.get(i);
            if (temp.getName().contains(sequence)) {
                result.add(temp);
            }
        }
        return result;
    }

    public boolean categoryInList(String search) {
        CharSequence sequence = search.subSequence(0, search.length() - 1);
        for (int i = 0; i < categoryList.size() - 1; i++) {
            Category temp = categoryList.get(i);
            if (temp.getName().contains(sequence)) {
                return true;
            }
        }
        return false;
    }
}