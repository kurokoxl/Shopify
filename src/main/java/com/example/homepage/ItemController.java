package com.example.homepage;

import Classes.Item;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class ItemController {

    @FXML
    private ImageView Img;

    @FXML
    private Label NameLabel;

    @FXML
    private AnchorPane itemPane;

    @FXML
    private Label PriceLabel;
    HelloController helloControllerl;

    @FXML
    private Label SaleLabel;

    @FXML
     JFXButton ItemButton;

    @FXML
    private void BuyItem(MouseEvent mouseEvent)  {
            myListener.onClickListener(item);
    }
    private Item item;
    private MyListener myListener;
    MyListener myListener2;
    @FXML
    void LeaveFeedBack(MouseEvent event) {
        myListener2.onClickListener(item);

    }
    public void SetData(Item item,MyListener myListener,MyListener myListener2){
        //we can use prototype?

        this.item=item;
//        this.idLabel.setText(String.valueOf(item.getId()));
        this.myListener=myListener;
        this.myListener2=myListener2;
        NameLabel.setText(item.getName());
        PriceLabel.setText(String.valueOf(item.getPrice()));
        SaleLabel.setText(String.valueOf(item.getSale())+"%");
        Image image=new Image(getClass().getResourceAsStream(item.getImgSrc()));
        Img.setImage(image);
    }


}
