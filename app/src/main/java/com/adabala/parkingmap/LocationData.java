package com.adabala.parkingmap;


import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by adabala on 31/10/2017.
 */

public class LocationData {

    private Context mContext;

    public LocationData(Context context) {
        this.mContext = context;
        loadJSONFromAsset();
    }

    public String loadJSONFromAsset() {
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
}
