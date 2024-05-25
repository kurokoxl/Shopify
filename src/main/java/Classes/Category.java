package Classes;

public abstract class Category {
    private int id;
    protected String name;
    public Category( int id) {

        this.id = id;
    }
    public Category() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void setName();
}
