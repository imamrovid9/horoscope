package com.tugas.ramalanzodiac;

import java.io.Serializable;
import java.util.List;

public class MainModel  {

        private String sunsign;
        private String horoscope;

        public String getSunsign() {
            return sunsign;
        }

        public void setSunsign(String sunsign) {
            this.sunsign = sunsign;
        }

        public String getHoroscope() {
            return horoscope;
        }

        public void setHoroscope(String horoscope) {
            this.horoscope = horoscope;
        }
        @Override
        public String toString() {
            return "MainModel{" +
                    "sunsign='" + sunsign + '\'' +
                    ", horoscope='" + horoscope + '\'' +
                    '}';
        }




}
