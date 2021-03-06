package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class TourAdapter extends ArrayAdapter<Tour> {
    private Context context;


    public TourAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Tour> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);


            ImageView PhotoImageView = (ImageView) listItemView.findViewById(R.id.image_view);
            TextView headTextView = (TextView) listItemView.findViewById(R.id.head);
            TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description);
            TextView locationTextView = (TextView)listItemView.findViewById(R.id.profile_location);
            TextView contactTextView = (TextView)listItemView.findViewById(R.id.profile_contacts);

            Tour tour = getItem(position);
            boolean isPhoto = tour.getPhotoUrl() != null;
            if  (isPhoto) {
                Glide.with(PhotoImageView.getContext())
                        .load(tour.getPhotoUrl())
                        .into(PhotoImageView);

                headTextView.setText(tour.getHead());
                descriptionTextView.setText(tour.getDescription());

            }

            else {
                PhotoImageView.setVisibility(View.GONE);
                headTextView.setText(tour.getHead());
                descriptionTextView.setText(tour.getDescription());
                locationTextView.setText(tour.getLocation());
                contactTextView.setText(tour.getContact());
            }


        }

        return listItemView;




    }
}