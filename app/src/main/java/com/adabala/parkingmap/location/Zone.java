package com.adabala.parkingmap.location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import static com.adabala.parkingmap.location.Defaults.DEFAULT_POINT;

/**
 * Created by adabala on 05/11/2017.
 */

public class Zone {

    private static final String TAG = Zone.class.getSimpleName();

    private String id;
    private String polygon;
    private String name;
    private int payment_is_allowed;
    private double max_duration;
    private float service_price;
    private int depth;
    private int draw;
    private int sticker_equired;
    private String currency;
    private String contact_email;
    private String point;
    private String country;
    private String provider_id;
    private String provider_name;

    public Zone() {

    }

    public Zone(String id, String polygon, String name, int payment_is_allowed, double max_duration, float service_price, int depth, int draw, int sticker_equired, String currency, String contact_email, String point, String country, String provider_id, String provider_name) {
        this.id = id;
        this.polygon = polygon;
        this.name = name;
        this.payment_is_allowed = payment_is_allowed;
        this.max_duration = max_duration;
        this.service_price = service_price;
        this.depth = depth;
        this.draw = draw;
        this.sticker_equired = sticker_equired;
        this.currency = currency;
        this.contact_email = contact_email;
        this.point = point;
        this.country = country;
        this.provider_id = provider_id;
        this.provider_name = provider_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPolygon() {
        return polygon;
    }

    public void setPolygon(String polygon) {
        this.polygon = polygon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPayment_is_allowed() {
        return payment_is_allowed == 1;
    }

    public void setPayment_is_allowed(int payment_is_allowed) {
        this.payment_is_allowed = payment_is_allowed;
    }

    public double getMax_duration() {
        return max_duration;
    }

    public void setMax_duration(double max_duration) {
        this.max_duration = max_duration;
    }

    public float getService_price() {
        return service_price;
    }

    public void setService_price(float service_price) {
        this.service_price = service_price;
    }

    public String getServicePrice() {
        return String.valueOf(service_price);
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int isSticker_equired() {
        return sticker_equired;
    }

    public void setSticker_equired(int sticker_equired) {
        this.sticker_equired = sticker_equired;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getPoint() {
        return point;
    }

    public LatLng getPointLatLng() {
        try {
            String[] latlongs = point.split(" ");
            return new LatLng(Double.parseDouble(latlongs[0]), Double.parseDouble(latlongs[1]));
        } catch (Exception e) {
            e.printStackTrace();
            return DEFAULT_POINT;
        }
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(String provider_id) {
        this.provider_id = provider_id;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public ArrayList<LatLng> getPolygonLatLngArray() {
        ArrayList<LatLng> latLngList = new ArrayList<>();
        try {
            for(String latlngString : polygon.split(",")) {
                String[] latlng = latlngString.trim().split(" ");
                latLngList.add(new LatLng(Double.parseDouble(latlng[0]), Double.parseDouble(latlng[1])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latLngList;
    }
}
