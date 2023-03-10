package com.example.superheltev4numedspringbootoops.Repositories;

import com.example.superheltev4numedspringbootoops.DTO.HeroCityDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowerCountDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowersDTO;
import com.example.superheltev4numedspringbootoops.Model.City;
import com.example.superheltev4numedspringbootoops.Model.SuperPowers;
import org.springframework.stereotype.Repository;
import com.example.superheltev4numedspringbootoops.Model.SuperHero;

import java.util.ArrayList;
import java.util.List;

@Repository("stub_repository")
public class StubRepository implements RepositoryInterface {


    ArrayList<SuperHero> heroDatabase;
    ArrayList<HeroPowerCountDTO> heroPowerCountList;
    ArrayList<HeroPowersDTO> heroPowersListList;
    ArrayList<HeroCityDTO> cityList;
    ArrayList<String> nameList;

    public StubRepository() {
        nameList = new ArrayList<>();

        heroDatabase = new ArrayList<>(List.of(
                new SuperHero(1, "Superman", "Clark Kent", 1940),
                new SuperHero(2, "Batman", "Bruce Wayne", 1950),
                new SuperHero(3, "Spider-Man", "Peter Parker", 1969),
                new SuperHero(4, "Ham der egentlig er null, men for opgaven så er han ikke null", "Hancock", 2010)
        ));

        heroPowerCountList = new ArrayList<>(List.of(
                new HeroPowerCountDTO("Super Man", "Clark Kent", 3),
                new HeroPowerCountDTO("Batman", "Bruce Wayne", 1),
                new HeroPowerCountDTO("Spider-Man", "Peter Parker", 1),
                new HeroPowerCountDTO("Ham der egentlig er null, men for opgaven så er han ikke null", "Hancock", 1)
        ));

        heroPowersListList = new ArrayList<>(List.of(
                new HeroPowersDTO("Super Man", "Clark Kent", new ArrayList<>(List.of("Lasers", "Flight", "Strength"))),
                new HeroPowersDTO("Batman", "Bruce Wayne", new ArrayList<>(List.of("Money"))),
                new HeroPowersDTO("Spider-Man", "Peter Parker", new ArrayList<>(List.of("Lasers"))),
                new HeroPowersDTO("Ham der egentlig er null, men for opgaven så er han ikke null", "Hancock", new ArrayList<>(List.of("Flight")))
        ));

        cityList = new ArrayList<>(List.of(
                new HeroCityDTO("Brøndby", new ArrayList<>(List.of("Spider-man"))),
                new HeroCityDTO("Hvidovre", new ArrayList<>(List.of("Batman", "Ham der egentlig er null, men for opgaven så er han ikke null"))),
                new HeroCityDTO("Rødovre", new ArrayList<>(List.of("Super Man")))
        ));
    }

    public ArrayList<SuperHero> getAllHeroesDB() {

        return heroDatabase;
    }

    public ArrayList<HeroPowerCountDTO> getListOfNamesAndNoOfPowers() {
        return heroPowerCountList;
    }

    public ArrayList<HeroPowersDTO> getListOfNamesAndPowers() {
        return heroPowersListList;
    }

    public ArrayList<HeroCityDTO> getListOfNamesAndCity() {
        return cityList;
    }
}
