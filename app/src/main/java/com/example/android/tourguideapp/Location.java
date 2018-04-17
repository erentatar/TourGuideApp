package com.example.android.tourguideapp;

public class Location {

    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private String mLocationName;
    private String mDescription;
    private String mUri;

    public Location(String locationName, String description, String uri, int imageResourceId) {
        mLocationName = locationName;
        mDescription = description;
        mUri = uri;
        mImageResourceId = imageResourceId;
    }

    public Location(String locationName, String description, String uri) {
        mLocationName = locationName;
        mDescription = description;
        mUri = uri;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getUri() {
        return mUri;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
