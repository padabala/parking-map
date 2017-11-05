package com.adabala.parkingmap.dagger;

import android.app.Application;
import android.content.Context;

import com.adabala.parkingmap.location.LocationDataLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adabala on 05/11/2017.
 */

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public LocationDataLoader provideLocationDataLoader(Context context) {
        return new LocationDataLoader(context);
    }
}
