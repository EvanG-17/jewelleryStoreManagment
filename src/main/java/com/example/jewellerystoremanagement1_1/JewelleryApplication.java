package com.example.jewellerystoremanagement1_1;

import com.example.jewellerystoremanagement1_1.Models.DisplayCase;
import com.example.jewellerystoremanagement1_1.Models.DisplayTray;
import com.example.jewellerystoremanagement1_1.Models.JewelleryItem;
import com.example.jewellerystoremanagement1_1.Models.MaterialContent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class JewelleryApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jewelleryStoreMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Evan Tynan Geary : J.S Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Adding new display cases

    //make own linked list class and linked node class

    //Linked list for Display Case
    public static DisplayCase firstCase;
    public static DisplayTray firstTray;
    public static JewelleryItem firstItem;
    public static MaterialContent firstMaterial;

    public static void addNewDisplayCase(int UID, boolean wallMounted, boolean lit) {
        DisplayCase dc = new DisplayCase();
        dc.setUID(UID);
        dc.setWallMounted(wallMounted);
        dc.setLit(lit);
        dc.nextCase = JewelleryApplication.firstCase;
        JewelleryApplication.firstCase = dc;


        DisplayCase temp = firstCase;
        while (temp != null) {
            temp = temp.getNextCase();
        }

    }

    //Linked list for Display Tray

    public static void addNewDisplayTray(DisplayCase dc, int id, String colour, int width, int height) {
        DisplayTray dt = new DisplayTray();
        dt.setIdentifier(id);
        dt.setInlayColour(colour);
        dt.setDimensions(width, height);
        dt.setDisplayCase(dc);

        dt.nextTray = dc.firstTray;
        dc.firstTray = dt;

    }


    public static void addNewJewelleryItem(DisplayTray dt, String description, String type, String gender, String url, int price) {
        JewelleryItem ji = new JewelleryItem();
        ji.setDescription(description);
        ji.setType(type);
        ji.setGender(gender);
        ji.setUrl(url);
        ji.setPrice(price);

        ji.nextItem = dt.firstItem;
        dt.firstItem = ji;

    }

    public static void addNewMaterialContent(JewelleryItem ji, String material, String materialdescription, int weight, int quality) {
        MaterialContent mc = new MaterialContent();
        mc.setMaterial(material);
        mc.setMaterialDescription(materialdescription);
        mc.setWeight(weight);
        mc.setQuality(quality);

        mc.nextMaterial = ji.firstMaterial;
        ji.firstMaterial = mc;

    }

}


