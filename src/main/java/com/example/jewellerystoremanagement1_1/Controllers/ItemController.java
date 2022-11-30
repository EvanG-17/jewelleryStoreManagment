package com.example.jewellerystoremanagement1_1.Controllers;

import com.example.jewellerystoremanagement1_1.JewelleryApplication;
import com.example.jewellerystoremanagement1_1.Models.DisplayTray;
import com.example.jewellerystoremanagement1_1.Models.JewelleryItem;
import com.example.jewellerystoremanagement1_1.Models.MaterialContent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.jewellerystoremanagement1_1.JewelleryApplication.addNewJewelleryItem;

public class ItemController {


    //Fields used by constructors
    public static ItemController ic;
    public static JewelleryItem selectedItem;
    public static Scene itemToTray;
    public static Scene itemtoMaterial;
    public Button jewelleryToDisplayTray;
    public Button jewelleryToMaterialContent;
    public TextField jewelleryDescription;
    public TextField jewelleryType;
    public TextField jewelleryGender;
    public TextField jewelleryImage;
    public TextField jewelleryPrice;
    public Button addJewelleryButton;
    public ListView items;
    public Button refreshItems;


    public String addJewelleryDescription() {
        return jewelleryDescription.getText();
    }

    public String addJewelleryType() {
        return jewelleryType.getText();

    }

    public String addJewelleryGender() {
        return jewelleryGender.getText();

    }

    public String addJewelleryImage() {
        return jewelleryImage.getText();

    }

    public int addJewelleryPrice() {
        return Integer.parseInt(jewelleryPrice.getText());

    }


    public void addJewelleryDescription(ActionEvent actionEvent) {
    }

    public void addJewelleryType(ActionEvent actionEvent) {
    }

    public void addJewelleryGender(ActionEvent actionEvent) {
    }

    public void addJewelleryImage(ActionEvent actionEvent) {
    }

    public void addJewelleryPrice(ActionEvent actionEvent) {
    }




    public void onAddJewelleryItem(ActionEvent actionEvent) {

        addNewJewelleryItem(TrayController.selectedTray, addJewelleryDescription(), addJewelleryType(), addJewelleryGender(), addJewelleryImage(), addJewelleryPrice());

        //PRINTS TO CONSOLE WHAT WAS ADDED
        JewelleryItem temp3 = TrayController.selectedTray.firstItem;

        System.out.println("\nList of Jewellery Items\n===========================");
        while (temp3 != null) {
            System.out.println(temp3);
            temp3 = temp3.nextItem;
        }

        //CLEAR THE LISTVIEW

        ItemController.ic.items.getItems().clear();


        //adds most recent to list view --- IMPORTANT FOR LIST VIEW as it depends
        JewelleryItem tempItem = TrayController.selectedTray.firstItem;
        while (tempItem != null) {
            ItemController.ic.items.getItems().add(tempItem);
            tempItem = tempItem.nextItem;
        }

    }

    //DELETES SELECTED CASE ON LIST VIEW
    public void deleteAppointment(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE &&
                items.getSelectionModel().getSelectedIndex() >= 0)
            items.getItems().remove(items.getSelectionModel()
                    .getSelectedIndex());
    }


    //NAVIGATION METHOD
    public void goJewelleryToDisplayTray(ActionEvent actionEvent) {
        Scene scene = null;
        if (ItemController.itemToTray == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("displayTrayMenu.fxml"));

            try {
                ItemController.itemToTray = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage s = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow(); // loading already initialized scene from Scene scene = null
        s.setScene(ItemController.itemToTray);

        DisplayTray tempTray22 = StoreMenuController.selectedCase.firstTray;

        TrayController.tc.trays.getItems().clear();

        while (tempTray22 != null) {
            TrayController.tc.trays.getItems().add(tempTray22);
            tempTray22 = tempTray22.nextTray;
        }
    }

    public void goJewelleryToMaterialContent(ActionEvent actionEvent) {
        selectedItem = (JewelleryItem) items.getSelectionModel().getSelectedItem();

        Scene scene = null;
        if (ItemController.itemtoMaterial == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jewelleryMaterial.fxml"));

            try {
                ItemController.itemtoMaterial = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage s = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow(); // loading already initialized scene from Scene scene = null
        s.setScene(ItemController.itemtoMaterial);

        MaterialContent tempMat11 = ItemController.selectedItem.firstMaterial;

        MaterialController.mc.materials.getItems().clear();

        while (tempMat11 != null) {
            MaterialController.mc.materials.getItems().add(tempMat11);
            tempMat11 = tempMat11.nextMaterial;
        }
    }


    //REFRESHES LIST VIEW TO ONLY SHOW RELEVANT DATA

    public void onRefreshItems(ActionEvent actionEvent) {
        JewelleryItem tempItem4 = TrayController.selectedTray.firstItem;

        ItemController.ic.items.getItems().clear();

        while (tempItem4 != null) {
            ItemController.ic.items.getItems().add(tempItem4);
            tempItem4 = tempItem4.nextItem;
        }
    }

    public TextField getJewelleryDescription() {
        return jewelleryDescription;
    }

    public void initialize() {
        ic = this;
    }


}
