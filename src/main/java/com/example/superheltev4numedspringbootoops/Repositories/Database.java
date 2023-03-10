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
public class Database implements RepositoryInterface{

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

    public Database() {

        shp = new StubRepository();
    }

    /*


3. En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder: heroName, realName, superkræfter (Superpower)

4. En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder: heroName og by (City)*/

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

    public SuperHero GetHeroFromNameDB(String realNameInput) {
        SuperHero hero = null;
        System.out.println(db_url + " " + uid + " " + pwd);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superherodb", "root", "mohamed")) {
            SQL = "select heroID, heroName, realName, creationYEar from superhero where realName = ?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, realNameInput);
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
                if(cityName.equals(currentCity)){
                    currentDTO.addHeroName(rs.getString("heroName"));
                }
                else{
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


