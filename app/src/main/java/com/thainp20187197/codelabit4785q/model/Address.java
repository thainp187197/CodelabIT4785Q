package com.thainp20187197.codelabit4785q.model;

import java.io.Serializable;

public class Address implements Serializable {
    private final String street;
    private final String suite;
    private final String city;
    private final String zipcode;
    private final double[] geo;

    public Address(String street, String suite, String city, String zipcode, String lat, String lng) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = new double[] { Double.parseDouble(lat), Double.parseDouble(lng) };
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public double getLatitude() {
        return geo[0];
    }

    public double getLongitude () {
        return geo[1];
    }
}
