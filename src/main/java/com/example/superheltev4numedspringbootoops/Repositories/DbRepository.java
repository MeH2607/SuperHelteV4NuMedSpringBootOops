package com.example.superheltev4numedspringbootoops.Repositories;

import com.example.superheltev4numedspringbootoops.DTO.HeroCityDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowerCountDTO;
import com.example.superheltev4numedspringbootoops.DTO.HeroPowersDTO;
import com.example.superheltev4numedspringbootoops.Model.SuperHero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository("database_repository")
public class DbRepository implements RepositoryInterface{

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;

    String SQL;
    ResultSet rs;
    Statement stmt;
    PreparedStatement ps;

    StubRepository shp;

    public DbRepository() {

        shp = new StubRepository();
    }





    public ArrayList<SuperHero> getAllHeroesDB() {
        ArrayList<SuperHero> heroList = new ArrayList<>();
        System.out.println(db_url + " " + uid + " " + pwd);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superherodb", "root", "mohamed")) {
            SQL = "select heroID, heroName, realName, creationYEar from superhero";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {

                int id = rs.getInt("heroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                heroList.add(new SuperHero(id, heroName, realName, creationYear));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return heroList;
    }

    public SuperHero getHeroFromNameDB(String heroNameINput) {
        SuperHero hero = null;
        System.out.println(db_url + " " + uid + " " + pwd);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superherodb", "root", "mohamed")) {
            SQL = "select heroID, heroName, realName, creationYEar from superhero where heroName = ?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, heroNameINput);
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("heroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                hero = new SuperHero(id, heroName, realName, creationYear);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return hero;
    }

    // 2. En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder: heroName, realName og antallet af superkræfter (Superpower)
    public ArrayList<HeroPowerCountDTO> getListOfNamesAndNoOfPowers() {
        ArrayList<HeroPowerCountDTO> heroList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superherodb", "root", "mohamed")) {
            SQL = "select heroName, realName,count(powerID) from superHero join superPower_superhero using(heroID) group by heroID;";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int powerCount = rs.getInt("count(powerID)");
                heroList.add(new HeroPowerCountDTO(heroName, realName, powerCount));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return heroList;
    }
    public  HeroPowerCountDTO getNameAndNoOfPowersFromName(String heroNameInput) {
        HeroPowerCountDTO hero = null;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superherodb", "root", "mohamed")) {
            SQL = "select heroName, realName,count(powerID) from superHero join superPower_superhero using(heroID) group by heroID HAVING heroName = ?;";
            ps = con.prepareStatement(SQL);
            ps.setString(1, heroNameInput);
            rs = ps.executeQuery();
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int powerCount = rs.getInt("count(powerID)");
                hero = new HeroPowerCountDTO(heroName, realName, powerCount);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return hero;
    }



    public ArrayList<HeroPowersDTO> getListOfNamesAndPowers() {
        ArrayList<HeroPowersDTO> heroList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superherodb", "root", "mohamed")) {
            SQL = "select heroName, realname, powerName from superHero left outer join superPower_superhero using(heroID) left outer join superpower using(powerID)";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            String currentName = "";
            HeroPowersDTO currentDTO = null;
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                if(heroName.equals(currentName)){
                    currentDTO.addPower(rs.getString("powerName"));
                }
                else{
                    currentDTO = new HeroPowersDTO(heroName, realName);
                    currentName = heroName;
                    currentDTO.addPower(rs.getString("powerName"));
                }
                heroList.add(currentDTO);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return heroList;
    }

    public HeroPowersDTO getNameAndPowersFromName(String heroNameInput){
        HeroPowersDTO hero = null;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superherodb", "root", "mohamed")) {
            SQL = "select heroName, realname, powerName from superHero left outer join superPower_superhero using(heroID) left outer join superpower using(powerID) HAVING Heroname=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, heroNameInput);
            rs = ps.executeQuery();
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                hero = new HeroPowersDTO(heroName, realName);
                while(rs.next()){
                    hero.addPower(rs.getString("powerName"));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return hero;
    }






    //4. En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder: heroName og by (City)*/
    public ArrayList<HeroCityDTO> getListOfNamesAndCity() {
        ArrayList<HeroCityDTO> heroList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superherodb", "root", "mohamed")) {
            SQL = "select heroName, cityname from superhero join city using(zipcode) order by cityname";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            String currentCity = "";
            HeroCityDTO currentDTO = null;
            while (rs.next()) {
                String cityName = rs.getString("cityName");
                    if (cityName.equals(currentCity)) {
                        currentDTO.addHeroName(rs.getString("heroName"));
                    } else {
                        currentDTO = new HeroCityDTO(cityName);
                        currentCity = cityName;
                        currentDTO.addHeroName(rs.getString("heroName"));
                    }
                heroList.add(currentDTO);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return heroList;
    }

    public HeroCityDTO getNamesAndCityFromCity(String cityNameInput){
        return new HeroCityDTO("cityname");
    }

   /* public SuperHero GetHeroFromNameID(int IDInput) {
        SuperHero hero = null;
        System.out.println(db_url + " " + uid + " " + pwd);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superherodb", "root", "mohamed")) {
            SQL = "select heroID, heroName, realName, creationYEar from superhero where heroID = ?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, IDInput);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("heroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                hero = new SuperHero(id, heroName, realName, creationYear);
            }
            System.out.println(hero.getHeroName());
            return hero;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }*/
}


