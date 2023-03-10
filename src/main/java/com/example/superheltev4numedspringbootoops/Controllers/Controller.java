package com.example.superheltev4numedspringbootoops.Controllers;

import com.example.superheltev4numedspringbootoops.DTO.HeroCityDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowerCountDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowersDTO;
import com.example.superheltev4numedspringbootoops.Model.SuperHero;
import com.example.superheltev4numedspringbootoops.Repositories.RepositoryInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(path = "herov4")
public class Controller {

    private final RepositoryInterface repository;

    public Controller(ApplicationContext context, @Value("${SuperHelteV4NuMedSpringBootOops.repository.impl}") String impl){
        repository = (RepositoryInterface) context.getBean(impl);

    }

@GetMapping(path="/")
public ResponseEntity<List<SuperHero>>getAllHeroes(){
ArrayList<SuperHero> heroList = repository.getAllHeroesDB();
    return new ResponseEntity<List<SuperHero>>(heroList, HttpStatus.OK);
}

@GetMapping(path="/{heroName}")
    public ResponseEntity<SuperHero> getHeroFromName(@PathVariable String heroName){
        SuperHero hero = repository.getHeroFromNameDB(heroName);
        return new ResponseEntity<>(hero, HttpStatus.OK);
}

@GetMapping(path="powerCount")
    public ResponseEntity<List<HeroPowerCountDTO>> getHeroPowerCount(){
       ArrayList<HeroPowerCountDTO> heroList = repository.getListOfNamesAndNoOfPowers();
     return new ResponseEntity<>(heroList, HttpStatus.OK);
}
    @GetMapping(path="powerCount/{heroName}")
    public ResponseEntity<HeroPowerCountDTO> getHeroPowerCountByName(@PathVariable String heroName){
        HeroPowerCountDTO hero = repository.getNameAndNoOfPowersFromName(heroName);
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }

@GetMapping(path="powers")
    public ResponseEntity<List<HeroPowersDTO>> getHeroPowers(){
    System.out.println("test1");
        ArrayList<HeroPowersDTO> heroList = repository.getListOfNamesAndPowers();
    System.out.println(heroList);
        return new ResponseEntity<>(heroList, HttpStatus.OK);
}

    @GetMapping(path="powers/{heroName}")
    public ResponseEntity<HeroPowersDTO> getHeroPowerListByName(@PathVariable String heroName){
        HeroPowersDTO hero = repository.getNameAndPowersFromName(heroName);
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }

@GetMapping(path="cities")
    public ResponseEntity<List<HeroCityDTO>> getHeroesInAllCities(){
        ArrayList<HeroCityDTO> heroList = repository.getListOfNamesAndCity();
        return new ResponseEntity<>(heroList, HttpStatus.OK);
}

@GetMapping(path="cities/{cityName}")
    public ResponseEntity<HeroCityDTO> getNamesAndCityFromCity(@PathVariable String cityName){
        HeroCityDTO hero = repository.getNamesAndCityFromCity(cityName);
        return new ResponseEntity<>(hero, HttpStatus.OK);
}
}

