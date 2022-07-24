package org.mychko.weatheranalysis;

import java.util.HashMap;

public class City {
    private CityName cityName;
    private Coord coord;
    private HashMap<CityName, Coord> cityCoord;

    public City(CityName cityName, Coord coord) {
        this.setCityName(cityName);
        this.setCoord(coord);
    }

    //TODO вынести координаты в HashMap
    public City(CityName cityName) {
        this(cityName, new Coord("59.94117", "30.324928"));
    }

    public CityName getCityName() {
        return cityName;
    }

    public void setCityName(CityName cityName) {
        this.cityName = cityName;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public static class Coord {
        private String lat;
        private String lon;

        public Coord (String lat, String lon) {
            this.setLat(lat);
            this.setLon(lon);
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }
    }
}