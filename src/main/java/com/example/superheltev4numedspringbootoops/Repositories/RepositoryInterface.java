package com.example.superheltev4numedspringbootoops.Repositories;

import com.example.superheltev4numedspringbootoops.DTO.HeroCityDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowerCountDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowersDTO;
import com.example.superheltev4numedspringbootoops.Model.SuperHero;

import java.util.ArrayList;

public interface RepositoryInterface {

    public ArrayList<SuperHero> getAllHeroesDB();

    public ArrayList<HeroPowerCountDTO> getListOfNamesAndNoOfPowers();

    public ArrayList<HeroPowersDTO> getListOfNamesAndPowers();

    public ArrayList<HeroCityDTO> getListOfNamesAndCity();


}
