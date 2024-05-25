package com.example.homepage;

import Classes.*;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import com.jfoenix.controls.JFXToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private PasswordField LoginPasswordText;
    @FXML
    private TextField LoginUserText;
    @FXML
    private GridPane otherGrid0;

    @FXML
    private Button AddItembutton;
    @FXML
    private TextField SignupCreditText;
    @FXML
    private PasswordField SignupPasswordText;
    @FXML
    private TextField UsernameSingupText;

    @FXML
    private GridPane ElectronicsGrid;

    @FXML
    private GridPane GamesGrid;

    @FXML
    private GridPane booksGrid;

    @FXML
    private GridPane otherGrid1;

    @FXML
    private GridPane othergrid2;

    @FXML
    private GridPane othergrid3;


    @FXML
    private GridPane ClothesGrid;

    @FXML
    private AnchorPane HomeAnchor;

    @FXML
    BorderPane HomePagePanel;

    @FXML
    private AnchorPane SignupPanel;
    @FXML
    private AnchorPane LoginPanel;

    @FXML
    private JFXToggleButton IsAdmin;
    @FXML
    private TextField NewCategoryName;
    @FXML
    private GridPane CartGrid;
    @FXML
    BorderPane CartPanel;

    @FXML
    private AnchorPane HelloPanel;
    @FXML
    private VBox Category1, Category2, Category3, Category4, Category5, Category6, Category7, Category8;
    VBox[] vBoxes;
    private List<Item> clothes = new ArrayList<>();
    private List<Item> Games = new ArrayList<>();
    private List<Item> electronics = new ArrayList<>();
    private List<Item> books = new ArrayList<>();
    @FXML
    private HBox DeleteCatImage1;

    @FXML
    private HBox DeleteCatImage2;

    @FXML
    private HBox DeleteCatImage3;

    @FXML
    private HBox DeleteCatImage4;
    @FXML
    private HBox AdminPanel1;

    @FXML
    private GridPane OrderGrid;
    @FXML
    private Label TotalPrice;
    @FXML
    private ScrollPane OrderScroll;
    @FXML
    private Hyperlink UsernameLabel;

    @FXML
    private StackPane CartButton;
    @FXML
    private Label BalanceText;
    CreditCard creditCard;
    ItemController itemController;
    Cart cart;
    User user;
    Admin admin=null;


    private MyListener myListener;
    private MyListener myListener2;
    int i = 0;
    int colOrder = 1;

    public int Rand_Date() {
        Random random = new Random();
        int min = 2;
        int max = 7;
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }
    @FXML
    void Login(MouseEvent event) {
       String usernme= LoginUserText.getText();
       String password=LoginPasswordText.getText();
        if(usernme.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("Admin")){
            admin=Admin.getInstance();
            HomePagePanel.setVisible(true);
            HelloPanel.setVisible(false);
            DeleteCatImage1.setVisible(true);
            DeleteCatImage2.setVisible(true);
            DeleteCatImage3.setVisible(true);
            DeleteCatImage4.setVisible(true);
            AdminPanel1.setVisible(true);
            CartButton.setVisible(false);
            return;
        }
        user= SystemFacade.signIn(usernme,password);
     if(user!=null){

           HomePagePanel.setVisible(true);
           HelloPanel.setVisible(false);
           UsernameLabel.setText(user.getUsername());
           cart= user.getCart();
           creditCard= user.getCreditCard();
     }
     else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Please enter a valid username and password");
           alert.show();
       }

    }
    @FXML
    void SingUp(MouseEvent event) {
        SystemFacade.signUp(UsernameSingupText.getText(),SignupPasswordText.getText(),Integer.parseInt(SignupCreditText.getText()));
    }
    @FXML
    void SwapSignup_In(MouseEvent event) {
        if(LoginPanel.isVisible()){
            LoginPanel.setVisible(false);
            SignupPanel.setVisible(true);
        }else if(SignupPanel.isVisible()){
            LoginPanel.setVisible(true);
            SignupPanel.setVisible(false);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clothes.addAll(SystemFacade.MakeClothes());
        Games.addAll(SystemFacade.MakeGames());
        electronics=SystemFacade.MakeElectronicss();
        books=SystemFacade.MakeBooks();
//        electronics.addAll(SystemFacade.MakeElectronics());
        myListener2=new MyListener() {
            @Override
            public void onClickListener(Item item) {
                if (user!=null) {
                    ObservableList<String> items = FXCollections.observableArrayList(item.getFeedBack());
                    ListView<String> listView = new ListView<>(items);
                    VBox popupContent = new VBox();
                    popupContent.setStyle("-fx-background-color:#88e0f0");
                    popupContent.setSpacing(10);
                    popupContent.setAlignment(Pos.CENTER);
                    TextField FeedBack = new TextField();
                    FeedBack.setPromptText("Feedback");
                    JFXButton saveButton = new JFXButton("Add feedback");
                    saveButton.setStyle("-fx-background-color:#c8285e");
                    popupContent.getChildren().addAll(listView,FeedBack,saveButton);
                    Popup popup = new Popup();
                    popup.getContent().add(popupContent);
                    popup.show(UsernameLabel.getScene().getWindow());
                    saveButton.setOnAction(event1 -> {
                        String feedBackText = FeedBack.getText();
                        if(!feedBackText.isEmpty()) {
                            item.addFeedback(feedBackText);
                        }
                        else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Invalid Input!");
                            alert.setHeaderText("Please enter a FeedBack");
                            alert.show();
                        }
                        popup.hide();
                    });
                }

            }
        };

        myListener = new MyListener() {
            int Col = 1;
            @Override
            public void onClickListener(Item item) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Item.fxml"));
                    AnchorPane anchorPaneCart = fxmlLoader.load();
                    ItemController selecteditem = fxmlLoader.getController();
                    selecteditem.SetData(item, myListener,myListener2);
                    if (HomePagePanel.isVisible()) {
                        //check stock
                        if (item.getStockQuantity() != 0) {
                            JFXButton cancel = new JFXButton();
//                            JFXButton cloneitem=new JFXButton("+");
//                            cloneitem.setStyle("-fx-background-color: green;");
//                            cloneitem.setOnAction(event3 -> {
//
//                                JFXButton clickedButton = (JFXButton) event3.getSource();
//                                GridPane Grid = (GridPane) clickedButton.getParent().getParent();
//                                VBox vBox1 = (VBox) clickedButton.getParent();
//                                System.out.println(vBox1.getChildren());
//                               VBox vBox=cloneVBox(vBox1);
//                               vBox.setAlignment(Pos.CENTER);
//
//
//                                   Item item1= (Item) item.getClone();
//                                    item.setStockQuantity(item.getStockQuantity()-1);
//                                    cart.addItem(item1);
//                                    CartGrid.add(vBox1,CartGrid.getColumnCount()+1,0);
//                                    Grid_Optimize(CartGrid);
//
//
//
//                            });
                            cancel.setOnAction(event1 -> {
                                // Get the reference to the button here
                                JFXButton clickedButton = (JFXButton) event1.getSource();
                                GridPane Grid = (GridPane) clickedButton.getParent().getParent();
                                int index = Grid.getChildren().indexOf(clickedButton.getParent());
                                Grid.getChildren().remove(clickedButton.getParent().getParent().getChildrenUnmodifiable().get(index));

                                //caculate total againnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn if in cart and if in order
                                if (Grid == CartGrid) {
                                    cart.removeItem(item.getId());
                                    TotalPrice.setText("Total Price is :" + String.valueOf(cart.getTotalPrice()) + "EGP");
                                    item.setStockQuantity(item.getStockQuantity()+1);
                                } else {
                                    creditCard.refund(item.getPrice() - (item.getPrice() * (item.getSale() / 100)));
                                    BalanceText.setText(String.valueOf(creditCard.getBalance()));
                                    item.setStockQuantity(item.getStockQuantity()+1);
                                }
                            });
                            cancel.setStyle("-fx-background-color: #FF0000;");
                            cancel.setText("Cancel item");


                            VBox vBox = new VBox(anchorPaneCart,cancel);
                            vBox.setAlignment(Pos.CENTER);
                            CartGrid.add(vBox, Col++, 0);
                            cart.addItem(item);
                            item.setStockQuantity(item.getStockQuantity()-1);
                            Grid_Optimize(CartGrid);
                            CartGrid.setMargin(anchorPaneCart, new Insets(15));
                        }
                        else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Stock");
                            alert.setHeaderText("Not enough quantity,please try again later");
                            alert.show();

                        }
                    }
                    else {
                        if (item.getStockQuantity() != 0) {
                            JFXButton cancel = new JFXButton();
//                            JFXButton cloneitem=new JFXButton("+");
//                            cloneitem.setStyle("-fx-background-color: green;");
//                            cloneitem.setOnAction(event3 -> {
//
//                                JFXButton clickedButton = (JFXButton) event3.getSource();
//                                GridPane Grid = (GridPane) clickedButton.getParent().getParent();
//                                VBox vBox1 = (VBox) clickedButton.getParent();
//                                System.out.println(vBox1.getChildren());
//                               VBox vBox=cloneVBox(vBox1);
//                               vBox.setAlignment(Pos.CENTER);
//
//
//                                   Item item1= (Item) item.getClone();
//                                    item.setStockQuantity(item.getStockQuantity()-1);
//                                    cart.addItem(item1);
//                                    CartGrid.add(vBox1,CartGrid.getColumnCount()+1,0);
//                                    Grid_Optimize(CartGrid);
//
//
//
//                            });
                            cancel.setOnAction(event1 -> {
                                // Get the reference to the button here
                                JFXButton clickedButton = (JFXButton) event1.getSource();
                                GridPane Grid = (GridPane) clickedButton.getParent().getParent();
                                int index = Grid.getChildren().indexOf(clickedButton.getParent());
                                Grid.getChildren().remove(clickedButton.getParent().getParent().getChildrenUnmodifiable().get(index));

                                //caculate total againnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn if in cart and if in order
                                if (Grid == CartGrid) {
                                    cart.removeItem(item.getId());
                                    TotalPrice.setText("Total Price is :" + String.valueOf(cart.getTotalPrice()) + "EGP");
                                    item.setStockQuantity(item.getStockQuantity()+1);
                                } else {
                                    creditCard.refund(item.getPrice() - (item.getPrice() * (item.getSale() / 100)));
                                    BalanceText.setText(String.valueOf(creditCard.getBalance()));
                                    item.setStockQuantity(item.getStockQuantity()+1);
                                }
                            });
                            cancel.setStyle("-fx-background-color: #FF0000;");
                            cancel.setText("Cancel item");


                            VBox vBox = new VBox(anchorPaneCart,cancel);
                            vBox.setAlignment(Pos.CENTER);
                            Item item1= (Item) item.getClone();
                            item.setStockQuantity(item.getStockQuantity()-1);
                            cart.addItem(item1);
                            CartGrid.add(vBox, Col++, 0);
                            cart.addItem(item);
                            item.setStockQuantity(item.getStockQuantity()-1);
                            Grid_Optimize(CartGrid);
                            CartGrid.setMargin(anchorPaneCart, new Insets(15));
                            TotalPrice.setText("Total Price is: "+String.valueOf(cart.getTotalPrice()+"EGP"));
                        }

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        try {

            Show_items(electronics,ElectronicsGrid);
            Show_items(clothes, ClothesGrid);
            Show_items(Games, GamesGrid);
            Show_items(books,booksGrid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        vBoxes = new VBox[]{Category1, Category2, Category3, Category4, Category5, Category6, Category7, Category8};
    }


    @FXML
    void Add_New_Item(MouseEvent event) {
        VBox popupContent = new VBox();
        popupContent.setSpacing(10);
        String styleString = "-fx-background-color: #00ff00; -fx-padding: 10px;";
        popupContent.setStyle(styleString);
        popupContent.setStyle("");
        TextField name = new TextField();
        name.setPromptText("Name");
        TextField price = new TextField();
        price.setPromptText("Price");
         TextField stockquantity = new TextField();
        stockquantity.setPromptText("Stock quantity");
        TextField sale = new TextField();
        sale.setPromptText("Sale");
        TextField imgSrc = new TextField();
        imgSrc.setPromptText("Image Path");
        Button saveButton = new Button("Save");
        ListView<Integer> category = new ListView<>();
        ObservableList<Integer> items = FXCollections.observableArrayList(1, 2, 3,4,5,6,7,8);
        category.setItems(items);
        popupContent.getChildren().addAll(name, price, stockquantity, sale,imgSrc,category,saveButton);
        Popup popup = new Popup();
        popup.setOpacity(0.9);
        popup.getContent().add(popupContent);
        popup.show(UsernameLabel.getScene().getWindow());
        saveButton.setOnAction(event1 -> {
            if(name.getText().isEmpty()||price.getText().isEmpty()||stockquantity.getText().isEmpty()||sale.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Please enter a valid Data");
                alert.show();
            }
            else{
                 List<Item> items1 = new ArrayList<>();
                 Item item=new Item(Double.parseDouble(price.getText()),Integer.parseInt(stockquantity.getText()),Double.parseDouble(sale.getText()),name.getText(),imgSrc.getText());
                 items1.add(item);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Item.fxml"));
                    AnchorPane anchorPaneCart = fxmlLoader.load();
                    ItemController selecteditem = fxmlLoader.getController();
                    int selected=category.getSelectionModel().getSelectedItem();
                    Category category1;
                    category1=CategoryFactory.getCategory(selected);
                    selecteditem.SetData(item, myListener,myListener2);//CATEGORY FACTOOOORYYYYYYY
                    item.setCategory(category1);
                   if(selected==1){
                       ClothesGrid.add(anchorPaneCart,ClothesGrid.getColumnCount(),0);
                   } if(selected==2) {
                        GamesGrid.add(anchorPaneCart, GamesGrid.getColumnCount(), 0);
                    } if(selected==3) {
                        ElectronicsGrid.add(anchorPaneCart, ElectronicsGrid.getColumnCount(), 0);
                    } if(selected==4) {
                        booksGrid.add(anchorPaneCart, booksGrid.getColumnCount(), 0);
                    } if(selected==5) {
                        otherGrid0.add(anchorPaneCart, otherGrid0.getColumnCount(), 0);
                    } if(selected==6) {
                        otherGrid1.add(anchorPaneCart, otherGrid1.getColumnCount(), 0);
                    } if(selected==7) {
                        othergrid2.add(anchorPaneCart, othergrid2.getColumnCount(), 0);
                    } if(selected==8) {
                        othergrid3.add(anchorPaneCart, othergrid3.getColumnCount(), 0);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            popup.hide();  });
    }
    @FXML
    void Show_items(List<Item> items, GridPane Grid) throws IOException {
        try {
            for (int i = 0; i < items.size(); i++) {
                Item item=items.get(i);
                FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("Item.fxml"));
                AnchorPane anchorPane = fxmlLoader2.load();
                ItemController itemController = fxmlLoader2.getController();
                itemController.SetData(item, myListener,myListener2);

                Grid.add(anchorPane, i + 1, 0);
                Grid_Optimize(Grid);
                Grid.setMargin(anchorPane, new Insets(13));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void remove(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.getParent().getParent().getParent().getParent().setVisible(false);
    }
    @FXML
    void Edit_Name(MouseEvent event) {

        if (admin!=null) {

            VBox popupContent = new VBox();
            popupContent.setSpacing(10);
            TextField NewName = new TextField();
            NewName.setPromptText("New Name");
            Button saveButton = new Button("Save");
            popupContent.getChildren().addAll(NewName,saveButton);

            Popup popup = new Popup();
            popup.getContent().add(popupContent);
            popup.show(UsernameLabel.getScene().getWindow());
            saveButton.setOnAction(event1 -> {
                String name = NewName.getText();
                if(!name.isEmpty()) {

                    Label label = (Label) event.getSource();
                    label.setText(name);
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid Input!");
                    alert.setHeaderText("Please enter a name");
                    alert.show();
                }
                popup.hide();
            });
        }
    }
    @FXML
    void Add_New_Category(MouseEvent event) {
        for (int i = 0; i < vBoxes.length; i++) {
            if (!vBoxes[i].isVisible()) {
                vBoxes[i].setVisible(true);
                HBox hBoxes=(HBox) vBoxes[i].getChildren().get(0);
                Label label= (Label) hBoxes.getChildren().get(0);

                break;

            }

        }
    }
    @FXML
    void Cart_To_Home(MouseEvent event) {
        CartPanel.setVisible(false);
        HomePagePanel.setVisible(true);

    }
    @FXML
    void Home_To_Cart(MouseEvent event) {
        CartPanel.setVisible(true);
        HomePagePanel.setVisible(false);
        double total = cart.getTotalPrice();
        TotalPrice.setText("Total Price is :" + String.valueOf(total) + "EGP");
        BalanceText.setText(String.valueOf(creditCard.getBalance()));
    }
    private GridPane cloneGridPane(GridPane originalGridPane) {
        GridPane clonedGridPane = new GridPane();
        clonedGridPane.setHgap(originalGridPane.getHgap());
        clonedGridPane.setVgap(originalGridPane.getVgap());
        clonedGridPane.setPadding(originalGridPane.getPadding());
        clonedGridPane.getChildren().addAll(originalGridPane.getChildren());
        return clonedGridPane;
    }
    @FXML
    void Make_Order(MouseEvent event) {
//!CartGrid.getChildren().stream().allMatch(child -> child == null
        if(cart.getTotalPrice()!=0)
        {
            double Price_Order= cart.getTotalPrice();
            double Balance=  creditCard.getBalance();
            if(Balance>= Price_Order) {
                Order order=new Order(Price_Order,cart);
                order.setTotalPrice(Price_Order);
                Label price = new Label("Order " + (colOrder) + " Total Price = " + Price_Order + "EGP");
                Label date = new Label("Will arrive in " + Rand_Date() + " days");
                JFXButton cancel = new JFXButton();
                cancel.setOnAction(event1 -> {
                    // Get the reference to the button here
                    JFXButton clickedButton = (JFXButton) event1.getSource();
                    int index = OrderGrid.getChildren().indexOf(clickedButton.getParent());
                    OrderGrid.getChildren().remove(clickedButton.getParent().getParent().getChildrenUnmodifiable().get(index + 1));
                    OrderGrid.getChildren().remove(clickedButton.getParent().getParent().getChildrenUnmodifiable().get(index));
                    creditCard.refund(order.getTotalPrice());
                    BalanceText.setText(String.valueOf(creditCard.getBalance()));
                });
                cancel.setStyle("-fx-background-color: #FF0000;");
                cancel.setText("Cancel Order");

                GridPane order1 = cloneGridPane(CartGrid);
                VBox box = new VBox(price, date, cancel);
                box.setAlignment(Pos.CENTER);
                AnchorPane anchorPane = new AnchorPane(order1);
                OrderGrid.add(box, 0, colOrder);
                OrderGrid.add(anchorPane, 1, colOrder);
                colOrder++;
                Grid_Optimize(OrderGrid);
                OrderGrid.setMargin(anchorPane, new Insets(13));
                cart.emptyCart();
                TotalPrice.setText("Your cart is Empty");
                creditCard.pay(Price_Order);
                BalanceText.setText(String.valueOf(creditCard.getBalance()));
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Balance");
                alert.setHeaderText("Not enough balance");
                alert.show();
            }
        }
    }
    @FXML
    void UpdateData(MouseEvent event) {
        VBox popupContent = new VBox();
        popupContent.setSpacing(10);
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        TextField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button saveButton = new Button("Save");
        if(user!=null){

            TextField creditCardField = new TextField();
            creditCardField.setPromptText("Credit Card Number");
            popupContent.getChildren().addAll(usernameField, passwordField, creditCardField, saveButton);
            Popup popup = new Popup();
            popup.setOpacity(0.9);
            popup.getContent().add(popupContent);
            popup.show(UsernameLabel.getScene().getWindow());
            saveButton.setOnAction(event1 -> {
                if(usernameField.getText().isEmpty()||passwordField.getText().isEmpty()||creditCardField.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter a valid Data");
                    alert.show();
                }
                else {
                    SystemFacade.updateUserInfo(user, usernameField.getText(), passwordField.getText(), Integer.parseInt(creditCardField.getText()));
                }
                popup.hide();
            });
        }

        else {

            popupContent.getChildren().addAll(usernameField, passwordField, saveButton);
            Popup popup = new Popup();
            popup.setOpacity(0.9);
            popup.getContent().add(popupContent);
            popup.show(UsernameLabel.getScene().getWindow());
            saveButton.setOnAction(event1 -> {
                if(usernameField.getText().isEmpty()||passwordField.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter a valid username and password");
                    alert.show();
                }
                else {
                    SystemFacade.deleteUser( usernameField.getText(), passwordField.getText());
                }
                popup.hide();

            });

        }
    }
    public static void Grid_Optimize(GridPane grid) {
        grid.setMinWidth(Region.USE_COMPUTED_SIZE);
        grid.setMinHeight(Region.USE_COMPUTED_SIZE);
        grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
        grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
        grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
        grid.setPrefHeight(Region.USE_COMPUTED_SIZE);


    }

}