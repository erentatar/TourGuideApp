package com.example.android.tourguideapp;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Activity context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        ViewHolder holder;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder();
            holder.nameTextView = listItemView.findViewById(R.id.name_text_view);
            holder.descTextView = listItemView.findViewById(R.id.description_text_view);
            holder.imageView = listItemView.findViewById(R.id.image);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        Location currentLocation = getItem(position);

        holder.nameTextView.setText(currentLocation.getLocationName());
        holder.descTextView.setText(currentLocation.getDescription());

        if (currentLocation.hasImage()) {
            holder.imageView.setImageResource(currentLocation.getImageResourceId());
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }

    static class ViewHolder {
        TextView nameTextView;
        TextView descTextView;
        ImageView imageView;
    }
}

