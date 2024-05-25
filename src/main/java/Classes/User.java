package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {
    private ArrayList<Order> orders = new ArrayList<>();
    private int id;
    private String name;
    private static final String FILE_NAME = "users.txt";
    private String email;
    private String username;
    private String password;
    private Cart cart;

    //No category or Item here
    private static int counter = 1;

    private CreditCard creditCard;

    public User() {
        cart = new Cart();
        orders = new ArrayList<>();
        id = counter;
        counter ++;
    //        Random rand = new Random();
//        id = rand.nextInt(900000) + 100000;
    }
    public User(String username, String password, CreditCard creditCard) {
        this.creditCard = creditCard;
        this.username = username;
        this.password = password;
        cart = new Cart();
        orders = new ArrayList<>();
        id = counter;
        counter ++;
//        Random rand = new Random();
    }

    public static int getCounter() {
        return counter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setCounter(int counter) {
        User.counter = counter;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public static User signIn(String username, String password) {
        File file = new File(FILE_NAME);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] credentials = scanner.nextLine().split(",");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    int creditCardId = Integer.parseInt(credentials[2]);
                    CreditCard creditCard = new CreditCard();
                    creditCard.setId(creditCardId);
                    return new User(username, password, creditCard);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean SignUp(String username, String password, int creditCardId) {
        try {
            File file = new File(FILE_NAME);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] credentials = scanner.nextLine().split(",");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return false;
                }
            }
            scanner.close();

            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write(username + "," + password + "," + creditCardId + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    public void UpdateUserInfo(User user, String newUsername, String newPassword, int newCreditCardId) {
        Path path = Paths.get(FILE_NAME);
        Path tempPath = Paths.get("tempFile.txt");

        try (Stream<String> lines = Files.lines(path)) {
            List<String> replaced = lines
                    .map(line -> line.split(","))
                    .map(credentials -> credentials[0].equals(user.getUsername())
                            ? newUsername + "," + newPassword + "," + newCreditCardId
                            : String.join(",", credentials))
                    .collect(Collectors.toList());
            Files.write(tempPath, replaced);
            Files.move(tempPath, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void Delete(String username, String password) {
        Path path = Paths.get(FILE_NAME);
        Path tempPath = Paths.get("tempFile.txt");

        try (Stream<String> lines = Files.lines(path)) {
            List<String> filtered = lines
                    .map(line -> line.split(","))
                    .filter(credentials -> !(credentials[0].equals(username) && credentials[1].equals(password)))
                    .map(credentials -> String.join(",", credentials))
                    .collect(Collectors.toList());
            Files.write(tempPath, filtered);
            Files.move(tempPath, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public boolean signUp(String username, String password, int creditCardId) {
//        try {
//            File file = new File(FILE_NAME);
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()) {
//                String[] credentials = scanner.nextLine().split(",");
//                if (credentials[0].equals(username) && credentials[1].equals(password)) {
//                    return false;
//                }
//            }
//            scanner.close();
//
//            FileWriter writer = new FileWriter(FILE_NAME, true);
//            writer.write(username + "," + password + "," + creditCardId + "\n");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
    public static void deleteUser(String username, String password) {
        User user=new User();
        user.deleteUser(username,password);
    }

    public void browseCategories(){
        //GUI function
    }

    public void addItemToCart(Item item){
        cart.addItem(item);
    }

    public void makeOrder(){
        Order order = new Order();
        orders.add(order);
    }

    public void cancelOrder(int index){
        orders.remove(index);
    }
//
//    public void completePayment(String choice){
//        paymentMethod = PaymentFactory.getPaymentMethod(choice);
//        double amount = cart.getTotalPrice();
//        paymentMethod.pay(amount);
//    }

//    public void addFeedBack(Item item, String feedback){
//        item.setFeedback(feedback);
//    }

    public void browseItems(){
        //GUI function
    }

    public void updatePersonalInfo(){
        //GUI function
    }
}
