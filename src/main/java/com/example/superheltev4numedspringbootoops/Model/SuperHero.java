package com.example.superheltev4numedspringbootoops.Model;

public class SuperHero {

    int heroID;
    String heroName;
    String realName;
    int creationYear;
    int zipcode;

    public SuperHero(int heroID, String heroName, String realName, int creationYear, int zipcode) {
        this.heroID = heroID;
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.zipcode = zipcode;
    }
public SuperHero(String heroName, String realName, int creationYear, int zipcode) {

        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.zipcode = zipcode;
    }

    public SuperHero(int heroID, String heroName, String realName, int ceationYear){
        this.heroID = heroID;
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
    }

    public int getHeroID() {
        return heroID;
    }

    public void setHeroID(int heroID) {
        this.heroID = heroID;
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

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
