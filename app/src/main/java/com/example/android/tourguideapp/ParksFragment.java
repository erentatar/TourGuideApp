package com.example.android.tourguideapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParksFragment extends Fragment {


    public ParksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.park_name_1), getString(R.string.park_desc_1), getString(R.string.park_uri_1), R.drawable.park_image_1));
        locations.add(new Location(getString(R.string.park_name_2), getString(R.string.park_desc_2), getString(R.string.park_uri_2), R.drawable.park_image_2));
        locations.add(new Location(getString(R.string.park_name_3), getString(R.string.park_desc_3), getString(R.string.park_uri_3), R.drawable.park_image_3));
        locations.add(new Location(getString(R.string.park_name_4), getString(R.string.park_desc_4), getString(R.string.park_uri_4), R.drawable.park_image_4));
        locations.add(new Location(getString(R.string.park_name_5), getString(R.string.park_desc_5), getString(R.string.park_uri_5), R.drawable.park_image_5));
        locations.add(new Location(getString(R.string.park_name_6), getString(R.string.park_desc_6), getString(R.string.park_uri_6), R.drawable.park_image_6));
        locations.add(new Location(getString(R.string.park_name_7), getString(R.string.park_desc_7), getString(R.string.park_uri_7), R.drawable.park_image_7));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Add event listener so we can handle clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Location location = locations.get(position);
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse(location.getUri());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    getActivity().startActivity(mapIntent);
                }
            }
        });

        return rootView;
    }

}
