package org.mychko.weatheranalysis;

import static org.mychko.weatheranalysis.CityName.MSK;
import static org.mychko.weatheranalysis.CityName.OMSK;
import static org.mychko.weatheranalysis.CityName.SPB;

import java.util.HashMap;

public class City {
    private CityName cityName;
    private Coord coord;
    public static final HashMap<CityName, Coord> cityCoord = new HashMap<>();

    static {
        initCityCoord();
    }

    public City(CityName cityName, Coord coord) {
        this.setCityName(cityName);
        this.setCoord(coord);
    }

    public City(CityName cityName) {
        this(cityName, cityCoord.get(cityName));
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

    private static void initCityCoord() {
        cityCoord.put(MSK, new Coord("55.751244", "37.618423"));
        cityCoord.put(SPB, new Coord("59.94117", "30.324928"));
        cityCoord.put(OMSK, new Coord("54.983334", "73.366669"));
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