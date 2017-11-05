package com.adabala.parkingmap.location;


import android.content.Context;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by adabala on 31/10/2017.
 */

public class LocationDataLoader {

    private Context mContext;

    private Gson gson;

    private Location location;

    public LocationDataLoader(Context context) {
        this.mContext = context;
        try {
            gson = new Gson();
            location = gson.fromJson(loadJSONFromAsset(), Location.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    private String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream inputStream = mContext.getAssets().open("location_data.json");

            int size = inputStream.available();

            byte[] buffer = new byte[size];

            inputStream.read(buffer);

            inputStream.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    /*
    * Get current location data
    */

    public Location getLocation() {
        return location;
    }
}
