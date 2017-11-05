package com.adabala.parkingmap.dagger;

import com.adabala.parkingmap.ParkingActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adabala on 05/11/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(ParkingActivity parkingActivity);
}
