package com.mapmyindia.ceinfo.silvassa.utils;

/**
 * Created by Manujay K. Yadav on 13-04-2017.
 * <p>
 * Collection of Math operations for bearing ,distance on maps
 *
 * @link https://web.archive.org/web/20150107173642/http://www.yourhomenow.com/house/haversine.html
 * @link http://www.movable-type.co.uk/scripts/latlong.html
 */

/*
* Bearing

A rhumb line is a straight line on a Mercator projection, with an angle on the projec­tion equal to the compass bearing.*/

public class MapUtils {

    private static final Double RoE = 6371.0; //Radius of Earth in Km

    public static Double Ibearing(Double lat1, Double lng1, Double lat2, Double lng2) {

        Double rlat1 = Math.toRadians(lat1);
        Double rlat2 = Math.toRadians(lat2);

        Double dlng = Math.toRadians(lng2 - lng1);
        Double dlat = Math.toRadians(lat2 - lat1);

        Double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) + Math.cos(rlat1) * Math.cos(rlat2) * Math.sin(dlng / 2) * Math.sin(dlng / 2);

        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double d = RoE * c;

        return d;
    }
}
