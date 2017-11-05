package com.adabala.parkingmap.location;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by adabala on 05/11/2017.
 */

public class Location {

    private String current_location;
    private LocationData location_data;

    public Location() {
    }

    public Location(String current_location, LocationData location_data) {
        this.current_location = current_location;
        this.location_data = location_data;
    }

    public String getCurrentLocation() {
        return current_location;
    }

    public void setCurrentLocation(String current_location) {
        this.current_location = current_location;
    }

    public LocationData getLocationData() {
        return location_data;
    }

    public void setLocationData(LocationData location_data) {
        this.location_data = location_data;
    }

    public LatLng getCurrentLocationLatLong() {
        try {
            String[] latlongs = current_location.split(",");
            return new LatLng(Double.parseDouble(latlongs[0]), Double.parseDouble(latlongs[1]));
        } catch (Exception e) {
            e.printStackTrace();
            return new LatLng(0.00, 0.00);
        }
    }
}
