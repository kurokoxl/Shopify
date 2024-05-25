package Classes;

import java.util.ArrayList;
import java.util.List;

public class Item implements Prototype {
    private static int nextId = 1;  // static variable to keep track of the next available ID
    private int id;  // individual ID for each item
    private double price;  // should be double
    private int stockQuantity;
    private double sale;  // should be double
    private String name;
    private ArrayList<String> feedback = new ArrayList<>();
    private String imgSrc;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public Item() {
        this.id = nextId++;  // assign the next available ID and then increment it
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public void addFeedback(String feedback){
        this.feedback.add(feedback);
    }
    public ArrayList<String> getFeedBack(){
        return feedback;
    }
    public Item(double price, int stockQuantity, double sale, String name, String imgSrc) {
        this();  // use the default constructor to assign the ID
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.sale = sale;
        this.name = name;
        this.imgSrc = imgSrc;
    }


    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
    public String getImgSrc() {
        return imgSrc;
    }


//    public void setId(int id) {this.id = id;}
    public void setPrice(int price) {this.price = price;}
    public void setStockQuantity(int stockQuantity) {this.stockQuantity = stockQuantity;}
    public void setSale(int sale) {this.sale = sale;}  //public applySale(){}
    public void setName(String name) {this.name = name;}
    public int getId() {return id;}
    public double getPrice() {return price;}
    public int getStockQuantity() {return stockQuantity;}
    public double getSale() {return sale;}
    public String getName() {return name;}
    public List<Item> Makecloth(){
        List<Item> items = new ArrayList<>();
        Item item;

        item = new Item( 300, 20, 10, "Bernardo City Shirt" ,"/Image/Bernardo.png");
        item.setCategory( CategoryFactory.getCategory('1'));
        items.add(item);
        item = new Item( 250, 20, 10, "Literally Me Jacket" ,"/Image/Literally me.png");
        item.setCategory( CategoryFactory.getCategory('1'));
        items.add(item);
        item = new Item( 150, 20, 10, "Jeans Jacket" ,"/Image/JeansJacket.png");
        item.setCategory( CategoryFactory.getCategory('1'));
        items.add(item);
        item = new Item( 900, 20, 10, "Ryan Gosling Shirt" ,"/Image/Rayan.png");
        item.setCategory( CategoryFactory.getCategory('1'));
        items.add(item);
        item = new Item( 200, 4, 10, "Black T-Shirt" ,"/Image/Shirt.png");
        item.setCategory( CategoryFactory.getCategory('1'));
        items.add(item);
        item = new Item( 400, 4, 10, "Swag Jacket" ,"/Image/Swag.png");
        item.setCategory( CategoryFactory.getCategory('1'));
        items.add(item);



        return items;
    }
    public List<Item> MakeGames(){
        List<Item> items = new ArrayList<>();
        Item item;

        item = new Item( 300, 4, 10, "Forza 5" ,"/Image/forza.png");
        item.setCategory( CategoryFactory.getCategory('2'));
        items.add(item);
        item = new Item( 250, 4, 10, "Horizon Zero Dawn" ,"/Image/horizon.png");
        item.setCategory( CategoryFactory.getCategory('2'));
        items.add(item);
        item = new Item( 150, 4, 10, "MineCraft" ,"/Image/mc.png");
        item.setCategory( CategoryFactory.getCategory('2'));
        items.add(item);
        item = new Item( 900, 4, 10, "Red Dead 2" ,"/Image/rdr2.png");
        item.setCategory( CategoryFactory.getCategory('2'));
        items.add(item);
        item = new Item( 200, 4, 10, "Shadow Of War" ,"/Image/shadow.png");
        item.setCategory( CategoryFactory.getCategory('2'));
        items.add(item);
        item = new Item( 400, 4, 10, "Spider-Man Remastered" ,"/Image/spiderman.png");
        item.setCategory( CategoryFactory.getCategory('2'));
        items.add(item);
        item = new Item( 600, 4, 5, "The Witcher 3" ,"/Image/thewitcher3.png");
        item.setCategory( CategoryFactory.getCategory('2'));
        items.add(item);
        item = new Item( 550, 4, 3, "Uncharted" ,"/Image/uncharted.png");
        item.setCategory( CategoryFactory.getCategory('2'));
        items.add(item);
        item = new Item( 300, 4, 30, "Watchdogs" ,"/Image/watchdogs.png");
        item.setCategory( CategoryFactory.getCategory('2'));
        items.add(item);


        return items;

    }
    public List<Item> MakeElectronics(){
        List<Item> items = new ArrayList<>();
        Item item;


        item = new Item( 4000, 4, 30, "Laptop" ,"/Image/LAP.png");
        item.setCategory( CategoryFactory.getCategory('3'));
        items.add(item);
        item = new Item( 4500, 4, 30, "Microwave" ,"/Image/MICRO.png");
        item.setCategory( CategoryFactory.getCategory('3'));
        items.add(item);
        item = new Item( 4500, 4, 25, "Playstation 5" ,"/Image/PS5.png");
        item.setCategory( CategoryFactory.getCategory('3'));
        items.add(item);
        item = new Item( 800, 4, 10, "Playstation Controller" ,"/Image/PSC.png");
        item.setCategory( CategoryFactory.getCategory('3'));
        items.add(item);
        item = new Item( 4000, 4, 20, "XBox" ,"/Image/XBOX.png");
        item.setCategory( CategoryFactory.getCategory('3'));
        items.add(item);
        item = new Item( 800, 4, 15, "XBOXController" ,"/Image/XC.png");
        item.setCategory( CategoryFactory.getCategory('3'));
        items.add(item);
        item = new Item( 900, 4, 5, "Coffee Machine" ,"/Image/COFFE.png");
        item.setCategory( CategoryFactory.getCategory('3'));
        items.add(item);
        item = new Item( 2000, 4, 10, "Two Doors Fridge" ,"/Image/FRIDGE.png");
        item.setCategory( CategoryFactory.getCategory('3'));
        items.add(item);

        return items;

    }
    public List<Item> MakeBookss(){
        List<Item> items = new ArrayList<>();
        Item item;


        item = new Item( 245, 50, 5, "The Dark Matter" ,"/Image/dark.png");
        item.setCategory( CategoryFactory.getCategory('4'));
        items.add(item);
        item = new Item( 100, 50, 5, "The Hunger Games" ,"/Image/hunger.png");
        item.setCategory( CategoryFactory.getCategory('4'));
        items.add(item);
        item = new Item( 120, 144, 4, "Naruto Manga" ,"/Image/naruto.png");
        item.setCategory( CategoryFactory.getCategory('4'));
        items.add(item);
        item = new Item( 130, 13, 10, "The Hobbit" ,"/Image/hobit.png");
        item.setCategory( CategoryFactory.getCategory('4'));
        items.add(item);
        item = new Item( 325, 13, 25, "Dune" ,"/Image/dune.png");
        item.setCategory( CategoryFactory.getCategory('4'));
        items.add(item);
        item = new Item( 200, 18, 15, "Berserk Vol.1" ,"/Image/berserk.png");
        item.setCategory( CategoryFactory.getCategory('4'));
        items.add(item);
        item = new Item( 250, 7, 5, "Rhythm of War" ,"/Image/rythm.png");
        item.setCategory( CategoryFactory.getCategory('4'));
        items.add(item);


        return items;

    }


    @Override
    public Prototype getClone() {
        return new Item( this.price, this.stockQuantity, this.sale, this.name,this.imgSrc);
    }


}
