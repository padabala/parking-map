package com.adabala.parkingmap.location;

import com.google.android.gms.maps.model.LatLngBounds;

import java.util.ArrayList;

/**
 * Created by adabala on 05/11/2017.
 */

public class LocationData {

    private Bounds bounds;
    private ArrayList<Zone> zones;

    public LocationData() {

    }

    public LocationData(Bounds bounds, ArrayList<Zone> zones) {
        this.bounds = bounds;
        this.zones = zones;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public ArrayList<Zone> getZones() {
        return zones;
    }

    public void setZones(ArrayList<Zone> zones) {
        this.zones = zones;
    }

    public LatLngBounds getLatLngBounds() {
        return this.bounds.bounds;
    }
}
