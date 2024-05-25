package Classes;

public class CategoryFactory {
    private static Category category = null;

    public static Category getCategory(int choice){
        if(choice==1)
            category = new Clothes();
        else if(choice==2)
            category = new Games();
        else if(choice==3)
            category = new Electronics();
        else
            category = new General();
        return category;
    }
}
