package Classes;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class Admin {
    private final String adminName = "Marwan";
    private final String username = "admin";
    private final String password = "admin";

    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();
    private static Admin instance;
    public static Admin getInstance(){
        instance = new Admin();
        return instance;
    }
    private Admin() {}
    public void addSale(Item item, int sale){
        item.setSale(sale);
    }

    public String getAdminName() {
        return adminName;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public ArrayList<Category> getCategories() {
        return categories;
    }


//    public void initializeCategories(){
//        try {
//            categories = new ArrayList<>();
//            File file = new File("categories.txt");
//            Scanner scanner = new Scanner(file);
//
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(",");
//                int id = Integer.parseInt(parts[0]);
//                String name = parts[1];
//                categories.add(new Category(id, name));
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }

//    public void addCategory(int id, String name) {
//        try {
//            initializeCategories();
//            File file = new File("categories.txt");
//            Scanner scanner = new Scanner(file);
//
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(",");
//                if (parts[1].equals(name)) {
//                    scanner.close();
//                    return;
//                }
//            }
//            scanner.close();
//
//            FileWriter writer = new FileWriter("categories.txt", true);
//            writer.write(id + "," + name + "\n");
//            writer.close();
//            categories.add(new Category(id, name));
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }

//    public void editCategory(int index, String newName) {
//        initializeCategories();
//        if (categories.isEmpty()) {
//            return;
//        }
//
//        try {
//            // Get the category to be edited
//            Category category = categories.get(index);
//            String oldName = category.getName();
//            // Update the name in the ArrayList
//            category.setName(newName);
//
//            // Read the file
//            File file = new File("categories.txt");
//            Scanner scanner = new Scanner(file);
//            StringBuilder fileContent = new StringBuilder();
//
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(",");
//                // If the line contains the category to be edited, replace the name
//                if (parts[1].equals(oldName)) {
//                    fileContent.append(category.getId() + "," + newName + "\n");
//                } else {
//                    fileContent.append(line + "\n");
//                }
//            }
//            scanner.close();
//
//            // Write the new content to the file
//            FileWriter writer = new FileWriter("categories.txt");
//            writer.write(fileContent.toString());
//            writer.close();
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }


//    public void deleteCategory(int index) {
//        initializeCategories();
//        if (categories.isEmpty()) {
//            return;
//        }
//        try {
//            // Get the category to be deleted
//            Category category = categories.get(index);
//            // Remove the category from the ArrayList
//            categories.remove(index);
//
//            // Read the file
//            File file = new File("categories.txt");
//            Scanner scanner = new Scanner(file);
//            StringBuilder fileContent = new StringBuilder();
//
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(",");
//                // If the line contains the category to be deleted, skip it
//                if (!parts[1].equals(category.getName())) {
//                    fileContent.append(line + "\n");
//                }
//            }
//            scanner.close();
//
//            // Write the new content to the file
//            FileWriter writer = new FileWriter("categories.txt");
//            writer.write(fileContent.toString());
//            writer.close();
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }


//    public void addItemsToStore(Item item) {
//        File file = new File("shopItems.txt");
//        List<String> items = new ArrayList<>();
//
//        // Read existing items
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                items.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Convert item to string
//        String itemString = item.getId() + "," + item.getName() + "," + "," +
//                item.getCategory() + "," + item.getPrice() + "," + item.getStockQuantity() + "," +
//                item.getSale();
//
//        // Check if item already exists
//        if (!items.contains(itemString)) {
//            // If not, append to file
//            try (FileWriter fw = new FileWriter(file, true);
//                 BufferedWriter bw = new BufferedWriter(fw);
//                 PrintWriter out = new PrintWriter(bw)) {
//                out.println(itemString);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    public boolean deleteUser(String name, String password) {
//        File inputFile = new File("users.txt");
//        File tempFile = new File("tempFile.txt");
//
//        boolean userFound = false;
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
//
//            String currentLine;
//
//            while ((currentLine = reader.readLine()) != null) {
//                // trim newline when comparing with lineToRemove
//                String trimmedLine = currentLine.trim();
//                String[] userInfo = trimmedLine.split(",");
//                if (userInfo[2].equals(name) && userInfo[3].equals(password)) {
//                    userFound = true;
//                    continue;
//                }
//                writer.write(currentLine + System.getProperty("line.separator"));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        //Delete the original file
//        if (!inputFile.delete()) {
//            System.out.println("Could not delete file");
//            return false;
//        }
//
//        //Rename the new file to the filename the original file had.
//        if (!tempFile.renameTo(inputFile)) {
//            System.out.println("Could not rename file");
//            return false;
//        }
//
//        return userFound;
//    }


}
