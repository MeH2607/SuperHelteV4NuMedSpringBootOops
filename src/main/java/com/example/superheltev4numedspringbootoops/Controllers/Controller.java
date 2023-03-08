package com.example.superheltev4numedspringbootoops.Controllers;

import com.example.superheltev4numedspringbootoops.Model.SuperHero;
import com.example.superheltev4numedspringbootoops.Repositories.Database;
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

    Database db;

    public Controller(){
        db = new Database();
    }

@GetMapping(path="/")
public ResponseEntity<List<SuperHero>>getAllHeroes(){
ArrayList<SuperHero> heroList = db.getAllHeroesDB();
    return new ResponseEntity<List<SuperHero>>(heroList, HttpStatus.OK);
}

@GetMapping(path="/{realName}")
    public ResponseEntity<SuperHero> getHeroFromRealName(@PathVariable String realName){
        SuperHero hero = db.GetHeroFromNameDB(realName);
        return new ResponseEntity<>(hero, HttpStatus.OK);
}
}

