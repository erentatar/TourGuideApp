package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TourGuideAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 5;
    private Context mContext;

    /**
     * Create a new {@link TourGuideAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public TourGuideAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CityFragment();
            case 1:
                return new MonumentsFragment();
            case 2:
                return new MuseumsFragment();
            case 3:
                return new ParksFragment();
            case 4:
                return new ShoppingFragment();
            default:
                return null;
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.city_name);
            case 1:
                return mContext.getString(R.string.location_monuments);
            case 2:
                return mContext.getString(R.string.location_museums);
            case 3:
                return mContext.getString(R.string.location_parks);
            case 4:
                return mContext.getString(R.string.location_shopping);
            default:
                return null;
        }
    }
}

