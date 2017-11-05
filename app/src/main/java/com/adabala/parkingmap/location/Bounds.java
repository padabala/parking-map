package com.adabala.parkingmap.location;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/**
 * Created by adabala on 05/11/2017.
 */

public class Bounds {

    public double east;
    public double west;
    public double north;
    public double south;

    public LatLngBounds bounds;

    public Bounds(double east, double west, double north, double south) {
        this.east = east;
        this.west = west;
        this.north = north;
        this.south = south;

        LatLng southWest = new LatLng(south, west);
        LatLng northEast = new LatLng(north, east);
        bounds = new LatLngBounds(southWest, northEast);
    }
}
