public class CategoryList {
    private ArrayList<Category> categoryList;

    CategoryList() {
        categroyList = new ArrayList<Category>
    }

    public void setCategroy(String name) {
        Category temp = new Category(name);
        for (int i = 0; i < categoryList.length() - 1; i++) {
            Category temp = categoryList.get(i);
            if (temp.compareTo(name) > 0) {
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

    public void sort() {
        
    }

    public ArrayList<Category> showList() {
        return categoryList;
    }

    public ArrayList<Category> getCategory(String search) {
        ArrayList<Category> result = new ArrayList<Category>
        search = search.subSequence(0,search.length - 1);
        for (int i = 0; i < categoryList.length() - 1; i++) {
            Category temp = categoryList.get(i);
            if (temp.name.contains(search)) {
                result.add(temp);
            }
        }
        return result;
    }

    public boolean categoryInList(String search) {
        search = search.subSequence(0,search.length - 1);
        for (int i = 0; i < categoryList.length() - 1; i++) {
            Category temp = categoryList.get(i);
            if (temp.name.contains(search)) {
                return True;
            }
        }
        return False;
    }
}