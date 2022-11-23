package com.example.jewellerystoremanagement1_1.Controllers;

import com.example.jewellerystoremanagement1_1.JewelleryApplication;
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

import static com.example.jewellerystoremanagement1_1.JewelleryApplication.addNewMaterialContent;

public class MaterialController {

    //Fields used by constructors

    public static MaterialController mc;
    public TextField materialName;
    public TextField materialDescription;
    public TextField materialWeight;
    public TextField materialQuality;
    public Button addMaterial;
    public ListView materials;
    public Button materialToJewellery;
    public static Scene materialToItem;


    //RETURN TYPES

    public String addMaterialName() {
        return materialName.getText();
    }


    public String addMaterialDescription() {
        return materialDescription.getText();

    }

    public int addMaterialQuality() {
        return Integer.parseInt(materialQuality.getText());

    }

    public int addMaterialWeight() {
        return Integer.parseInt(materialWeight.getText());

    }

    //void

    public void addMaterialName(ActionEvent actionEvent) {
    }

    public void addMaterialWeight(ActionEvent actionEvent) {
    }

    public void addMaterialQuality(ActionEvent actionEvent) {
    }

    public void addMaterialDescription(ActionEvent actionEvent) {
    }


    public void onAddMaterial(ActionEvent actionEvent) {

        addNewMaterialContent(ItemController.selectedItem, addMaterialName(), addMaterialDescription(), addMaterialWeight(), addMaterialQuality());

        //PRINTS TO CONSOLE WHAT WAS ADDED
        MaterialContent tempMat = ItemController.selectedItem.firstMaterial;

        System.out.println("\nList of Material Content\n===========================");
        while (tempMat != null) {
            System.out.println(tempMat);
            tempMat = tempMat.nextMaterial;
        }

        //CLEAR THE LISTVIEW

       materials.getItems().clear();


        //adds most recent to list view --- IMPORTANT FOR LIST VIEW as it depends
        MaterialContent tempMaterial = ItemController.selectedItem.firstMaterial;
        while (tempMaterial != null) {
            materials.getItems().add(tempMaterial);
            tempMaterial = tempMaterial.nextMaterial;
        }


        JewelleryItem tempItem44 = TrayController.selectedTray.firstItem;

        ItemController.ic.items.getItems().clear();

        while (tempItem44 != null) {
            ItemController.ic.items.getItems().add(tempItem44);
            tempItem44 = tempItem44.nextItem;
        }


    }

    //DELETES SELECTED CASE ON LIST VIEW
    public void deleteAppointment(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE &&
                materials.getSelectionModel().getSelectedIndex() >= 0)
            materials.getItems().remove(materials.getSelectionModel()
                    .getSelectedIndex());
    }

    public void goMaterialToJewellery(ActionEvent actionEvent) {
        Scene scene = null;
        if (MaterialController.materialToItem == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jewelleryItem.fxml"));

            try {
                MaterialController.materialToItem = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage s = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow(); // loading already initialized scene from Scene scene = null
        s.setScene(MaterialController.materialToItem);
    }

    public void initialize() {

        mc = this;
    }


}
