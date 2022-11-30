package com.example.jewellerystoremanagement1_1.Models;

import com.example.jewellerystoremanagement1_1.Controllers.MaterialController;

public class MaterialContent {

    public static MaterialController mc;
    public MaterialContent nextMaterial;
    public MaterialContent getNextMaterial = null;

    private String material;
    private String materialdescription;
    private int weight;
    private int quality;
    
    
    private DisplayCase dc;
    private JewelleryItem ji;


    public MaterialContent getNextMaterial() {
        return nextMaterial;
    }

    public MaterialContent NextMaterial(MaterialContent nextMaterial) {
        this.nextMaterial = nextMaterial;
        return this;
    }

    public String getMaterial() {
        return material;
    }

    public MaterialContent setMaterial(String material) {
        this.material = material;
        return this;
    }

    public MaterialContent getGetNextMaterial() {
        return getNextMaterial;
    }

    public MaterialContent setGetNextMaterial(MaterialContent getNextMaterial) {
        this.getNextMaterial = getNextMaterial;
        return this;
    }

    public String getMaterialdescription() {
        return materialdescription;
    }

    public MaterialContent setMaterialDescription(String materialdescription) {
        this.materialdescription = materialdescription;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public MaterialContent setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public int getQuality() {
        return quality;
    }

    public MaterialContent setQuality(int quality) {
        this.quality = quality;
        return this;
    }


    public String toString() {
        return
                "Material Content:  " + material +
                        "   Material Description:  " + materialdescription +
                        "   Material Weight:  " + weight +
                        "g" +
                        "   Material Quality:  " + quality
                        + " /10";

    }

    public MaterialContent setJewelleryItem(JewelleryItem ji) {
        this.ji = ji;
        return this;
    }
}
