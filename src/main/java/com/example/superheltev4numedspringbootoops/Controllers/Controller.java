package com.example.superheltev4numedspringbootoops.Controllers;

import com.example.superheltev4numedspringbootoops.DTO.HeroCityDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowerCountDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowersDTO;
import com.example.superheltev4numedspringbootoops.Model.SuperHero;
import com.example.superheltev4numedspringbootoops.Repositories.Database;
import com.example.superheltev4numedspringbootoops.Repositories.RepositoryInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

/*@GetMapping(path="/{realName}")
    public ResponseEntity<SuperHero> getHeroFromRealName(@PathVariable String realName){
        SuperHero hero = repository.GetHeroFromNameDB(realName);
        return new ResponseEntity<>(hero, HttpStatus.OK);
}*/

@GetMapping(path="powerCount")
    public ResponseEntity<List<HeroPowerCountDTO>> getHeroPowerCount(){
       ArrayList<HeroPowerCountDTO> heroList = repository.getListOfNamesAndNoOfPowers();
     return new ResponseEntity<>(heroList, HttpStatus.OK);
}

@GetMapping(path="powers")
    public ResponseEntity<List<HeroPowersDTO>> getHeroPowers(){
    System.out.println("test1");
        ArrayList<HeroPowersDTO> heroList = repository.getListOfNamesAndPowers();
    System.out.println(heroList);
        return new ResponseEntity<>(heroList, HttpStatus.OK);
}
@GetMapping(path="cities")
    public ResponseEntity<List<HeroCityDTO>> getHeroesInAllCities(){
    System.out.println("CityWok");
        ArrayList<HeroCityDTO> heroList = repository.getListOfNamesAndCity();
        return new ResponseEntity<>(heroList, HttpStatus.OK);
}

    //TODO hvorfor virker det her ikke
/*@GetMapping("/herov4")
    public ResponseEntity<SuperHero> getHeroFromID(@RequestParam int heroID){
        SuperHero hero = db.GetHeroFromNameID(heroID);
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }*/
}

