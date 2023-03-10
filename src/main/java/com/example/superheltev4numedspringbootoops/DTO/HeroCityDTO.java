package com.example.superheltev4numedspringbootoops.DTO;

import java.util.ArrayList;
import java.util.List;

public class HeroCityDTO {
String cityName;
List<String> heroNameList;

public HeroCityDTO(String cityName){
    this.cityName = cityName;
    this.heroNameList = new ArrayList<>();
}

public HeroCityDTO(String cityName, ArrayList<String> heroNameList){
    this.cityName = cityName;
    this.heroNameList = heroNameList;
}

    public void addHeroName(String heroName){
        heroNameList.add(heroName);
    }
    public void addHeroName(ArrayList<String> heroNames){
        heroNameList = heroNames;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<String> getHeroNameList() {
        return heroNameList;
    }

    public void setHeroNameList(List<String> heroNameList) {
        this.heroNameList = heroNameList;
    }
}
