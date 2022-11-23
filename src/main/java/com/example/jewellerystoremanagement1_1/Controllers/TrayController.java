package com.example.jewellerystoremanagement1_1.Controllers;

import com.example.jewellerystoremanagement1_1.JewelleryApplication;
import com.example.jewellerystoremanagement1_1.Models.DisplayCase;
import com.example.jewellerystoremanagement1_1.Models.DisplayTray;
import com.example.jewellerystoremanagement1_1.Models.JewelleryItem;
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

import static com.example.jewellerystoremanagement1_1.JewelleryApplication.addNewDisplayTray;

public class TrayController {

    //Fields used by constructors
    public static TrayController tc;
    public static DisplayTray selectedTray;
    public ListView trays;
    public TextField trayUID;
    public TextField widthText;
    public TextField heightText;
    public Button addTrayButton;
    public static Scene theSceneToCase;
    public static Scene theSceneToItem;
    public Button backToDisplayCase;
    public Button goToJewelleryItem;
    public TextField inlayMaterialColourText;
    public Button deleteTrays;
    public Button refreshTrays;

    public void initialize() {
        tc = this;
    }

    public int addTrayUID() {
        return Integer.parseInt(trayUID.getText());
    }

    public int addTrayWidth() {
        return Integer.parseInt(widthText.getText());
    }

    public int addTrayLength() {
        return Integer.parseInt(heightText.getText());
    }

    public String addInlayMaterialColour() {
        return addInlayMaterialColour();
    }


    public void addTrayUID(ActionEvent actionEvent) {
    }

    public void addTrayWidth(ActionEvent actionEvent) {
    }

    public void addTrayHeight(ActionEvent actionEvent) {
    }

    public void addInlayMaterialColour(ActionEvent actionEvent) {
    }

    //change scene
    public void goToDisplayCase(ActionEvent actionEvent) {


        Scene scene = null;
        if (TrayController.theSceneToCase == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jewelleryStoreMenu.fxml"));

            try {
                TrayController.theSceneToCase = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage s = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow(); // loading already initialized scene from Scene scene = null
        s.setScene(TrayController.theSceneToCase);

        DisplayCase tempCase22 = JewelleryApplication.firstCase;

        StoreMenuController.smc.cases.getItems().clear();

        while (tempCase22 != null) {
            StoreMenuController.smc.cases.getItems().add(tempCase22);
            tempCase22 = tempCase22.nextCase;
        }

    }

    // Go To Jewellery Item Screen

    public void goToJewelleryItem(ActionEvent actionEvent) {
        selectedTray = (DisplayTray) trays.getSelectionModel().getSelectedItem();


        Scene scene = null;
        if (TrayController.theSceneToItem == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jewelleryItem.fxml"));

            try {
                TrayController.theSceneToItem = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage s = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow(); // loading already initialized scene from Scene scene = null
        s.setScene(TrayController.theSceneToItem);


        JewelleryItem tempItem44 = TrayController.selectedTray.firstItem;

        ItemController.ic.items.getItems().clear();

        while (tempItem44 != null) {
            ItemController.ic.items.getItems().add(tempItem44);
            tempItem44 = tempItem44.nextItem;
        }


    }

    //ADD METHOD
    public void onAddTray(ActionEvent actionEvent) {

        addNewDisplayTray(StoreMenuController.selectedCase, addTrayUID(), inlayMaterialColourText.getText(), addTrayWidth(), addTrayLength());


        //PRINTS LINKED LIST CONTENT TO CONSOLE
        DisplayTray temp = StoreMenuController.selectedCase.firstTray;
        System.out.println("\nList of Display Trays\n===========================");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.nextTray;
        }


        //CLEARS LIST VIEW
        TrayController.tc.trays.getItems().clear();

        //adds most recent to list view --- IMPORTANT FOR LIST VIEW as it depends
        DisplayTray tempTray = StoreMenuController.selectedCase.firstTray;
        while (tempTray != null) {
            TrayController.tc.trays.getItems().add(tempTray);
            tempTray = tempTray.nextTray;
        }

    }

    //DELETING ALL CASES AND CLEARING LIST VIEW
    public void onDeleteAllTrays(ActionEvent actionEvent) {
        JewelleryApplication.firstTray = null;
        trays.getItems().clear();
        System.out.println("Deleted All Trays!");


    }


    //Initialize makes sure everything is safely loaded before the application runs

    //DELETES SELECTED CASE ON LIST VIEW
    public void deleteAppointment(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE &&
                trays.getSelectionModel().getSelectedIndex() >= 0)
            trays.getItems().remove(trays.getSelectionModel()
                    .getSelectedIndex());
    }


    //Refreshes List View to remove any unwanted information
    public void onRefreshTrays(ActionEvent actionEvent) {
        DisplayTray tempTray2 = StoreMenuController.selectedCase.firstTray;

        TrayController.tc.trays.getItems().clear();

        while (tempTray2 != null) {
            TrayController.tc.trays.getItems().add(tempTray2);
            tempTray2 = tempTray2.nextTray;
        }
    }


}
