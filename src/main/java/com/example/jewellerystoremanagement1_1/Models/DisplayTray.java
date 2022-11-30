package com.example.jewellerystoremanagement1_1.Models;

public class DisplayTray {

    public DisplayTray nextTray;
    public JewelleryItem firstItem;
    public DisplayTray getNextTray = null;


    private int id;
    private String colour;
    private int width;
    private int height;
    private DisplayCase dc;




    public DisplayTray getNextTray() {
        return nextTray;
    }


    public DisplayTray setNextTray(DisplayTray nextTray) {
        this.nextTray = nextTray;
        return this;
    }

    public void setIdentifier(int id) {
        this.id = id;
    }

    public void setInlayColour(String colour) {
        this.colour = colour;
    }

    public void setDimensions(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public JewelleryItem getFirstItem() {
        return firstItem;
    }

    public DisplayTray setFirstItem(JewelleryItem firstItem) {
        this.firstItem = firstItem;
        return this;
    }

    public DisplayTray getGetNextTray() {
        return getNextTray;
    }

    public DisplayTray setGetNextTray(DisplayTray getNextTray) {
        this.getNextTray = getNextTray;
        return this;
    }

    public int getId() {
        return id;
    }

    public DisplayTray setId(int id) {
        this.id = id;
        return this;
    }

    public String getColour() {
        return colour;
    }

    public DisplayTray setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public DisplayTray setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public DisplayTray setHeight(int height) {
        this.height = height;
        return this;
    }

    @Override
    public String toString() {
        return "Display Tray UID:  " + id +
                "   Inlay Material Colour:   " + colour +
                "   Display Tray Width:  " + width +
                "   Display Tray Height:  " + height;
    }

    public DisplayTray(int id, String colour, int width, int height) {
        this.id = id;
        this.colour = colour;
        this.width = width;
        this.height = height;
    }

    public void setDisplayCase(DisplayCase dc) {
        this.dc = dc;
    }

    public DisplayTray(){}
}
