package com.example.jewellerystoremanagement1_1.Controllers;

import com.example.jewellerystoremanagement1_1.JewelleryApplication;
import com.example.jewellerystoremanagement1_1.Models.DisplayCase;
import com.example.jewellerystoremanagement1_1.Models.DisplayTray;
import com.example.jewellerystoremanagement1_1.Models.JewelleryItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.io.IOException;

public class TreeViewController {
    public static TreeViewController tv;
    public TreeView listAll;
    public Button ListToMain;
    public static Scene theTreeToCase;
    public ListView listViewAll;
    public Button listAllStock;

    public void onListAll(TreeView.EditEvent editEvent) {
    
    }

    public void onListToMain(ActionEvent actionEvent) {
        if (TreeViewController.theTreeToCase == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jewelleryStoreMenu.fxml"));

            try {
                TreeViewController.theTreeToCase = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage s = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow(); // loading already initialized scene from Scene scene = null
        s.setScene(TreeViewController.theTreeToCase);

        DisplayCase tempCase22 = JewelleryApplication.firstCase;

        StoreMenuController.smc.cases.getItems().clear();

        while (tempCase22 != null) {
            StoreMenuController.smc.cases.getItems().add(tempCase22);
            tempCase22 = tempCase22.nextCase;
        }
    }

    // View all method
    public void onListAllStock(ActionEvent actionEvent) {
        listViewAll.getItems().clear();
        DisplayCase tempDC = JewelleryApplication.firstCase;
        while (tempDC != null) {
            //ADD DC - Display Case
            TreeViewController.tv.listViewAll.getItems().add(tempDC);
            DisplayTray tempDT = tempDC.firstTray;
                while (tempDT != null){
                    //ADD DT - Display Tray
                    TreeViewController.tv.listViewAll.getItems().add("\t" + tempDT);
                    JewelleryItem tempJT = tempDT.firstItem;
                    while (tempJT != null){
                        //Add list to list view ADD JT - Jewellery Item
                        TreeViewController.tv.listViewAll.getItems().add("\t \t "+ tempJT);
                        tempJT = tempJT.nextItem;
                    }
                    tempDT= tempDT.nextTray;
            }
                tempDC= tempDC.nextCase;
        }
    }



    public void initialize() {

        tv = this;
    }



}
