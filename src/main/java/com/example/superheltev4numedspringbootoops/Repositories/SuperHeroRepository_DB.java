package com.example.superheltev4numedspringbootoops.Repositories;

import org.springframework.stereotype.Repository;
import com.example.superheltev4numedspringbootoops.Model.SuperHero;

import java.util.ArrayList;

@Repository
public class SuperHeroRepository_DB {


        ArrayList<SuperHero> heroDatabase;
        ArrayList<String> nameList;

        public SuperHeroRepository_DB() {
            nameList = new ArrayList<>();
           heroDatabase = new ArrayList<>();
        }

        private ArrayList<SuperHero> findSuperheroList = new ArrayList<>();


        public ArrayList<SuperHero> getHeroDatabase() {
            return heroDatabase;
        }

        public void setHeroDatabase(ArrayList<SuperHero> heroDatabase) {
            this.heroDatabase = heroDatabase;
        }

        public ArrayList<SuperHero> getFindSuperheroList() {
            return findSuperheroList;
        }


     /*   public SuperHero addToDatabase(String superheroName, String realName, int creationYear) {
            SuperHero newHero = new SuperHero(superheroName, realName, creationYear);
            heroDatabase.add(newHero);
            return newHero;
        }*/

        public SuperHero addToDatabase(SuperHero hero) {
            heroDatabase.add(hero);
            return hero;
        }


        //Samler en gruppe af helte, når man skal gemme resultater. Bruges til når der skal redigeres.
        public ArrayList<SuperHero> searchForHeroList(String searchName) {
            SuperHero hero;
            findSuperheroList.clear(); //Clear for at når man søger flere gange så gemmes de gamle svar ikke

            for (int n = 0; n < heroDatabase.size(); n++) {
                hero = heroDatabase.get(n);
                if (hero.getHeroName().toLowerCase().contains(searchName.toLowerCase()))
                    findSuperheroList.add(hero);
            }
            return findSuperheroList;
        }

        public void deleteHero(int heroToDelete) {

            //Fjerner 1 fra bruger input for at matche arraylist index
            int deleteOnIndex = heroToDelete - 1;

            //Printer ud før der slettes så man stadig kan hente den slettede helts navn.
            System.out.println(heroDatabase.get(deleteOnIndex).getHeroName() + " has been deleted");

            heroDatabase.remove(deleteOnIndex);
        }

        public void deleteHero(String heroName) {

            for (SuperHero s : heroDatabase) {
                if (s.getHeroName().equals(heroName)) {
                    heroDatabase.remove(s);
                    break;
                }
            }
        }

        public void editHeroName(SuperHero newHero) {
            for (SuperHero s : heroDatabase) {
                if (s.getHeroName().equals(newHero.getHeroName())){
                    int index =  heroDatabase.indexOf(s);
                    heroDatabase.set(index, newHero);
                }
            }
        }

    }
