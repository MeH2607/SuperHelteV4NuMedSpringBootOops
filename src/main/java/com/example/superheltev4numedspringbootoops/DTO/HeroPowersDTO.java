package com.example.superheltev4numedspringbootoops.DTO;

import java.util.ArrayList;
import java.util.List;

public class HeroPowersDTO {
    String heroName;
    String realName;
    List<String> powerList;

    public HeroPowersDTO(String heroName, String realName){
        this.heroName = heroName;
        this.realName = realName;
        this.powerList = new ArrayList<>();
    }
   public HeroPowersDTO(String heroName, String realName, ArrayList<String>powerList){
        this.heroName = heroName;
        this.realName = realName;
        this.powerList = powerList;
    }

    public void addPower(String powerName){
        powerList.add(powerName);
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<String> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<String> powerList) {
        this.powerList = powerList;
    }
}
