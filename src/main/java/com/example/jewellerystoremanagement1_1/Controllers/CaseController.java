package com.example.jewellerystoremanagement1_1.Controllers;

import com.example.jewellerystoremanagement1_1.JewelleryApplication;
import com.example.jewellerystoremanagement1_1.Models.DisplayCase;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.jewellerystoremanagement1_1.JewelleryApplication.addNewDisplayCase;
import static com.example.jewellerystoremanagement1_1.JewelleryApplication.firstCase;

public class CaseController {

    //Fields used by constructors
    public TextField caseUID;
    public CheckBox caseMounted;
    public CheckBox caseLit;
    public ListView cases;
    public Button addFinishedCaseButton;
    public CaseController next = null;
    public static Scene theScene2;


    public int getCaseUID() {
        return Integer.parseInt(caseUID.getText());
    }

    public Boolean getWallMounted() {
        return caseMounted.isSelected();
    }

    public Boolean getLit() {
        return caseLit.isSelected();
    }

    //ON CREATING A NEW CASE, GO BACK TO JEWELLERY STORE MENU
    public void onFinishedCase(ActionEvent back) {

        //METHOD TO ADD CASES TO LISTVIEW


        //ADDING TO LINK LIST
        addNewDisplayCase(getCaseUID(), caseLit.isSelected(), caseMounted.isSelected());


        DisplayCase temp = JewelleryApplication.firstCase;

        //prints to console what was added.
        System.out.println("\nList of Display Cases\n===========================");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.nextCase;
        }


        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jewelleryStoreMenu.fxml"));
        Scene scene = null;
        if (CaseController.theScene2 == null)
            try {
                theScene2 = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        Stage s = (Stage) ((Button) back.getSource()).getScene().getWindow();
        s.setScene(theScene2);


        //adds most recent to list view --- IMPORTANT FOR LIST VIEW
//        StoreMenuController.smc.cases.getItems().add(JewelleryApplication.firstCase);

        DisplayCase tempCase22 = JewelleryApplication.firstCase;

        StoreMenuController.smc.cases.getItems().clear();

        while (tempCase22 != null) {
            StoreMenuController.smc.cases.getItems().add(tempCase22);
            tempCase22 = tempCase22.nextCase;
        }
    }
}








