package com.example.superheltev4numedspringbootoops.Repositories;

import com.example.superheltev4numedspringbootoops.DTO.HeroCityDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowerCountDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowersDTO;
import com.example.superheltev4numedspringbootoops.Model.SuperHero;

import java.util.ArrayList;

public interface RepositoryInterface {

     ArrayList<SuperHero> getAllHeroesDB();
     SuperHero getHeroFromNameDB(String heroNameInput);

     ArrayList<HeroPowerCountDTO> getListOfNamesAndNoOfPowers();
    HeroPowerCountDTO getNameAndNoOfPowersFromName(String heroNameInput);

     ArrayList<HeroPowersDTO> getListOfNamesAndPowers();
     HeroPowersDTO getNameAndPowersFromName(String heroNameInput);

     ArrayList<HeroCityDTO> getListOfNamesAndCity();
    HeroCityDTO getNamesAndCityFromCity(String cityNameInput);



    }
