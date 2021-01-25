class Category
{
    String name;

    //create new Category
    Category(String nameInit)
    {
        name = nameInit;
    }

    //set new value for name
    public void setName(String newName)
    {
        name = newName;
    }

    //request the current value for name
    public String getName()
    {
        return name;
    }
}