package com.example.jewellerystoremanagement1_1.Controllers;

import com.example.jewellerystoremanagement1_1.JewelleryApplication;
import com.example.jewellerystoremanagement1_1.Models.DisplayCase;
import com.example.jewellerystoremanagement1_1.Models.DisplayTray;
import com.example.jewellerystoremanagement1_1.Models.JewelleryItem;
import com.example.jewellerystoremanagement1_1.Models.MaterialContent;
import com.example.jewellerystoremanagement1_1.Controllers.ItemController;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;

public class StoreMenuController {

    //Fields used by constructors
    public static StoreMenuController smc;
    public static Scene theScene;
    public Button createCaseButton;
    public ListView cases;
    public ListView items;
    public Button createTrayButton;
    public static Scene TheScene;
    public static Scene theScene3;
    public static Scene mainToList;
    public static DisplayCase selectedCase;
    public static DisplayCase firstCase;
    public static DisplayTray selectedTray;
    public Button deleteCases;
    public Button resetStock;
    public ListView trays;
    public Button refreshCases;
    public Button load;
    public Button save;
    public Button mainListAll;
    public ListView searchList;
    public TextField search;
    public Button searchButton;
    public Button totalPrice;

    //method made in lab with peter to open a new scene, get the window and display

    public void onCreateCaseButton(ActionEvent createCase) {
        Scene scene = null;
        if (StoreMenuController.theScene == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("addDisplayCaseMenu.fxml"));

            try {
                StoreMenuController.theScene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage s = (Stage) ((Button) createCase.getSource()).getScene().getWindow(); // loading already initialized scene from Scene scene = null
        s.setScene(StoreMenuController.theScene);
    }


    //Out putting most recent Linked List data to console and also opening a new window.

    public void onCreateTrayButton(ActionEvent actionEvent) {
        selectedCase = (DisplayCase) cases.getSelectionModel().getSelectedItem();

        Scene scene = null;
        if (StoreMenuController.theScene3 == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("displayTrayMenu.fxml"));

            try {
                StoreMenuController.theScene3 = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage s = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow(); // loading already initialized scene from Scene scene = null
        s.setScene(StoreMenuController.theScene3);


        System.out.println(selectedCase.toString());


        //Refreshes list view to show most up to date information

        DisplayTray tempTray22 = StoreMenuController.selectedCase.firstTray;

        TrayController.tc.trays.getItems().clear();

        while (tempTray22 != null) {
            TrayController.tc.trays.getItems().add(tempTray22);
            tempTray22 = tempTray22.nextTray;
        }

    }

    // Opens list all menu
    public void onMainListAll(ActionEvent actionEvent) {
        Scene scene = null;
        if (StoreMenuController.mainToList == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("treeViewScene.fxml"));

            try {
                StoreMenuController.mainToList = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage s = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow(); // loading already initialized scene from Scene scene = null
        s.setScene(StoreMenuController.mainToList);
    }




    //DELETES SELECTED CASE ON LIST VIEW
    public void deleteAppointment(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE &&
                cases.getSelectionModel().getSelectedIndex() >= 0)
            cases.getItems().remove(cases.getSelectionModel()
                    .getSelectedIndex());
    }


    //DELETING ALL CASES AND CLEARING LIST VIEW
    public void onDeleteAllCases(ActionEvent actionEvent) {
        JewelleryApplication.firstCase = null;
        cases.getItems().clear();
        System.out.println("Deleted All Cases!");

    }


    //RESETS ENTIRE FACILITY

    public void onResetAllStock(ActionEvent actionEvent) {
        JewelleryApplication.firstCase = null;
        JewelleryApplication.firstTray = null;
        JewelleryApplication.firstItem = null;
        JewelleryApplication.firstMaterial = null;

        cases.getItems().clear();
        if (TrayController.tc.trays != null) {
            TrayController.tc.trays.getItems().clear();
        }
        if (ItemController.ic.items != null) {
            ItemController.ic.items.getItems().clear();
        }
    }
    //makes sure everything is safely loaded before the application runs

    public void selectTray(MouseEvent mouseEvent) {
    }

    //Refreshes List View to remove any unwanted information
    public void onRefreshCases(ActionEvent actionEvent) {
        DisplayCase tempCase22 = JewelleryApplication.firstCase;

        StoreMenuController.smc.cases.getItems().clear();
        while (tempCase22 != null) {
            StoreMenuController.smc.cases.getItems().add(tempCase22);
            tempCase22 = tempCase22.nextCase;
        }
    }

    //Save method using XStream
    public void onSave() throws Exception {
        System.out.println("\nSaving...\n===========================");
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Jewellery.xml"));
        out.writeObject(JewelleryApplication.firstCase);
        out.close();

        System.out.println(JewelleryApplication.firstCase);
        System.out.println("\n===========================\nSaved!");
    }

    //Load method using XStream
    public void onLoad() throws Exception {

        System.out.println("\nLoading...\n===========================");
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{DisplayCase.class, DisplayTray.class, JewelleryItem.class, MaterialContent.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("Jewellery.xml"));
        JewelleryApplication.firstCase = (DisplayCase) in.readObject();
        in.close();


        //Loads all cases
        DisplayCase tempCase22 = JewelleryApplication.firstCase;

        StoreMenuController.smc.cases.getItems().clear();

        while (tempCase22 != null) {
            StoreMenuController.smc.cases.getItems().add(tempCase22);
            tempCase22 = tempCase22.nextCase;
        }

        //Loads all Trays
        DisplayTray tempTray22 = StoreMenuController.selectedCase.firstTray;

        TrayController.tc.trays.getItems().clear();

        while (tempTray22 != null) {
            TrayController.tc.trays.getItems().add(tempTray22);
            tempTray22 = tempTray22.nextTray;
        }

        //Loads all Items
        JewelleryItem tempItem44 = TrayController.selectedTray.firstItem;

        ItemController.ic.items.getItems().clear();

        while (tempItem44 != null) {
            ItemController.ic.items.getItems().add(tempItem44);
            tempItem44 = tempItem44.nextItem;
        }

        //Loads all materials

        MaterialContent tempMat11 = ItemController.selectedItem.firstMaterial;

        MaterialController.mc.materials.getItems().clear();

        while (tempMat11 != null) {
            MaterialController.mc.materials.getItems().add(tempMat11);
            tempMat11 = tempMat11.nextMaterial;
        }
    }



    //Using same method as List All Stock with drill down through cases,trays the items
    public void onSearchJewellery(ActionEvent actionEvent) {

        System.out.println("Searching.....");
        System.out.println("\n" + "Searched for: " + search.getText());

        DisplayCase tempDC = JewelleryApplication.firstCase;
        while (tempDC != null) {
            DisplayTray tempDT = tempDC.firstTray;
            while (tempDT != null){
                JewelleryItem tempJT = tempDT.firstItem;
                while (tempJT != null){
                    if (tempJT.getDescription().contains(search.getText()))
                        searchList.getItems().add(String.valueOf(tempJT));
                    tempJT = tempJT.nextItem;
                }
                tempDT= tempDT.nextTray;
            }
            tempDC= tempDC.nextCase;
        }

        System.out.println("\n" + "Found the following search results: ");
        System.out.println( "\n" + searchList.getItems());
    }




    public void initialize() {
        smc = this;
    }

    //Calculates total price of jewellery items
    public void onTotalPrice(ActionEvent actionEvent) {
        DisplayCase tempDC = JewelleryApplication.firstCase;
        while (tempDC != null) {
            //ADD DC - Display Case
            DisplayTray tempDT = tempDC.firstTray;
            while (tempDT != null) {
                //ADD DT - Display Tray
                JewelleryItem tempJT = tempDT.firstItem;
                while (tempJT != null) {
                    //Add list to list view ADD JT - Jewellery Item
                    tempJT = tempJT.nextItem;
                }
                tempDT = tempDT.nextTray;
            }
            tempDC = tempDC.nextCase;
        }
    }
}


