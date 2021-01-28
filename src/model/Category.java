package model;

class Category {
    String name;

    //create new Category
    Category(String name) {
        this.name = name;
    }

    //set new value for name
    public void setName(String name) {
        this.name = name;
    }

    //request the current value for name
    public String getName() {
        return name;
    }
}