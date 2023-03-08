package com.example.superheltev4numedspringbootoops.Model;

public class City {
    int zipcode;
    String cityName;

    public City(int zipcode, String cityName) {
        this.zipcode = zipcode;
        this.cityName = cityName;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
