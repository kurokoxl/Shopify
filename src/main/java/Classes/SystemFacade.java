package Classes;

import com.example.homepage.MyListener;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import java.nio.file.*;
import java.util.stream.*;

import java.io.*;
import java.util.*;

public class SystemFacade {
    private static final String FILE_NAME = "users.txt";
    static int i=0;


    public static boolean signUp(String username, String password, int creditCardId) {
        User user=new User();
        return user.SignUp(username,password,creditCardId);
    }
    public static void deleteUser(String username, String password) {
        User user=new User();
        user.Delete(username,password);
    }

    public static User signIn(String username, String password) {
      return User.signIn(username,password);
    }
    public static List<Item> MakeClothes() {
        Item item=new Item();
       return item.Makecloth();

    }
    public static List<Item> MakeGames() {
        Item item=new Item();
        return item.MakeGames();
    }
    public static List<Item> MakeElectronicss(){
        Item item=new Item();
        return item.MakeElectronics();
    }
    public static List<Item> MakeBooks(){
        Item item=new Item();
        return item.MakeBookss();
    }
    public static void updateUserInfo(User user, String newUsername, String newPassword, int newCreditCardId) {
       User user1=new User();
       user1.UpdateUserInfo(user,newUsername,newPassword,newCreditCardId);
    }
}
