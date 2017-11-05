package com.adabala.parkingmap;

import android.app.Application;

import com.adabala.parkingmap.dagger.AppComponent;
import com.adabala.parkingmap.dagger.AppModule;
import com.adabala.parkingmap.dagger.DaggerAppComponent;

/**
 * Created by adabala on 05/11/2017.
 */

public class ParkingMapApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AppModule appModule = new AppModule(this);

        appComponent = DaggerAppComponent.builder().appModule(appModule).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
