package com.example.superheltev4numedspringbootoops.DTO;

public class HeroPowerCountDTO {


        String heroName;
        String realName;
        int powerCount;

        public HeroPowerCountDTO(String heroName, String realName, int powerCount) {
            this.heroName = heroName;
            this.realName = realName;
            this.powerCount = powerCount;
        }

        public String getHeroName() {
            return heroName;
        }

        public void setHeroName(String heroName) {
            this.heroName = heroName;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getPowerCount() {
            return powerCount;
        }

        public void setPowerCount(int powerCount) {
            this.powerCount = powerCount;
        }
    }
