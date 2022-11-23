package com.example.jewellerystoremanagement1_1.Models;

public class JewelleryItem {

    public JewelleryItem nextItem;
    public MaterialContent firstMaterial;
    public JewelleryItem getNextItem = null;


    private String description;
    private String type;
    private String gender;
    private String url;
    private int price;

    private DisplayTray dt;

    public JewelleryItem getNextTray() {
        return nextItem;
    }

    public JewelleryItem getNextItem() {
        return nextItem;
    }

    public JewelleryItem setNextItem(JewelleryItem nextItem) {
        this.nextItem = nextItem;
        return this;
    }

    public MaterialContent getFirstItem() {
        return firstMaterial;
    }

    public JewelleryItem setFirstItem(MaterialContent firstMaterial) {
        this.firstMaterial = firstMaterial;
        return this;
    }

    public JewelleryItem getGetNextItem() {
        return getNextItem;
    }

    public JewelleryItem setGetNextItem(JewelleryItem getNextItem) {
        this.getNextItem = getNextItem;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JewelleryItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getType() {
        return type;
    }

    public JewelleryItem setType(String type) {
        this.type = type;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public JewelleryItem setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public JewelleryItem setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public JewelleryItem setPrice(int price) {
        this.price = price;
        return this;
    }


    @Override
    public String toString() {
        return
                "Jewellery Item Description:  " + description +
                        "   Jewellery Type:  " + type +
                        "   Jewellery Gender:  " + gender +
                        "   Jewellery URl:  " + url +
                        "   Jewellery Price:  " + price;
    }

    public void setDisplayTray(DisplayTray dt) {
        this.dt = dt;
    }
}
