package com.adabala.parkingmap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.adabala.parkingmap.location.LocationDataLoader;
import com.adabala.parkingmap.location.Zone;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.HashMap;

import javax.inject.Inject;

public class ParkingActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marker;

    private HashMap<String, Zone> zoneHashMap;

    @Inject
    LocationDataLoader locationDataLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        ((ParkingMapApplication)getApplication()).getAppComponent().inject(ParkingActivity.this);

        zoneHashMap = new HashMap<>();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in current location and move the camera
        final LatLng currentLocation = locationDataLoader.getLocation().getCurrentLocationLatLong();
        marker = mMap.addMarker(new MarkerOptions().position(currentLocation).title("Current Location"));
        mMap.setLatLngBoundsForCameraTarget(locationDataLoader.getLocation().getLocationData().getLatLngBounds());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 14.0f));
        addPolygons();

        mMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(Polygon polygon) {
                Zone zone = zoneHashMap.get(polygon.getTag());
                if(zone != null) {
                    if(marker != null) {
                        marker.remove();
                    }
                    marker = mMap.addMarker(new MarkerOptions().position(zone.getPointLatLng())
                            .title(getString(R.string.price, zone.getServicePrice(), zone.getCurrency())));
                    marker.showInfoWindow();
                    polygon.setFillColor(getResources().getColor(R.color.selectedPolygon));
                }
            }
        });
    }

    private void addPolygons() {

        for(Zone zone : locationDataLoader.getLocation().getLocationData().getZones()){
            PolygonOptions poly = new PolygonOptions();

            if(zone.isPayment_is_allowed()) {
                poly.fillColor(getResources().getColor(R.color.paymentAllowed));
            } else {
                poly.fillColor(getResources().getColor(R.color.paymentNotAllowed));
            }

            poly.clickable(true);

            poly.addAll(zone.getPolygonLatLngArray());

            // Done! Add to map.
            Polygon polygon = mMap.addPolygon(poly);
            polygon.setClickable(true);
            polygon.setTag(zone.getId());
            zoneHashMap.put(zone.getId(), zone);
        }
    }
}
