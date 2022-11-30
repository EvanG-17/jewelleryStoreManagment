package com.example.jewellerystoremanagement1_1.Models;

public class DisplayCase {


    public DisplayCase nextCase;
    public DisplayTray firstTray;
    public DisplayCase getNextCase = null;


    private int UID;
    private boolean isLit;
    private boolean isWallMounted;


    public DisplayCase getNextCase() {
        return nextCase;
    }

    public DisplayCase setNextCase(DisplayCase nextCase) {
        this.nextCase = nextCase;
        return this;
    }

    public int getUID() {
        return UID;
    }

    public DisplayCase setUID(int UID) {
        this.UID = UID;
        return this;
    }

    public boolean isLit() {
        return isLit;
    }

    public DisplayCase setLit(boolean lit) {
        isLit = lit;
        return this;
    }

    public boolean isWallMounted() {
        return isWallMounted;
    }

    public DisplayCase setWallMounted(boolean wallMounted) {
        isWallMounted = wallMounted;
        return this;
    }

    @Override
    public String toString() {
        return           "UID   " + UID +
                        ", Is the case Lit?   " + isLit +
                        ", Is the case WallMounted?   " + isWallMounted;
    }
}
