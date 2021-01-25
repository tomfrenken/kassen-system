public class CategoryList
{
    private ArrayList<Category> categoryList;

    CategoryList() {
        categroyList = new ArrayList<Category>
    }

    public void newCategroy(String name) {
        Category temp = new Category(name);
        categoryList.add(temp);
    }

    public void removeCategory(int index) {
        Category temp = categoryList.get(index);
        categoryList.remove(temp);
    }

    public void setCategory(int index, String name) {
        Category temp = categoryList.get(index);
        temp.setName(name);
    }

    public void sort() {

    }

    public void showList() {
        
    }

    public ArrayList getCategory(String search) {
        ArrayList<Category> result =new ArrayList<Category>
        search = search.subSequence(0,search.length-1);
        for(int i = 0; i < categoryList.length()-1; i++) {
            Category temp = categoryList.get(i);
            if(temp.name.contains(search)) {
                result.add(temp)
            }
        }
        return result;
    }

    public boolean categoryInList(String search) {
        search = search.subSequence(0,search.length-1);
        for(int i = 0; i < categoryList.length()-1; i++) {
            Category temp = categoryList.get(i);
            if(temp.name.contains(search)) {
                return True;
            }
        }
        return False;
    }
}