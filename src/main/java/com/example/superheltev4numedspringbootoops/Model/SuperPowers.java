package com.example.superheltev4numedspringbootoops.Model;

public class SuperPowers {

    int powerID;
    String powerName;
    String powerLevel;

    public SuperPowers(int powerID, String powerName, String powerLevel) {
        this.powerID = powerID;
        this.powerName = powerName;
        this.powerLevel = powerLevel;
    }

    public int getPowerID() {
        return powerID;
    }

    public void setPowerID(int powerID) {
        this.powerID = powerID;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(String powerLevel) {
        this.powerLevel = powerLevel;
    }
}
