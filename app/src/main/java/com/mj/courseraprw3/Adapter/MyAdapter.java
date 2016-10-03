package com.mj.courseraprw3.Adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mj.courseraprw3.R;
import com.mj.courseraprw3.db.ConstructorPets;
import com.mj.courseraprw3.pets;

import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * Created by leyenda1 on 16/09/2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    ArrayList<pets> mDataset;
    Activity activity;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView  nName;
        public TextView  mLikes;
        public ImageView mImageView;
        public ImageView mButton ;

        public ViewHolder(View view) {
            super(view);
            nName      = (TextView)  view.findViewById(R.id.actvPetName);
            mLikes     = (TextView)  view.findViewById(R.id.actvLikes);
            mImageView = (ImageView) view.findViewById(R.id.acivPetPicture);
            mButton    = (ImageView) view.findViewById(R.id.acivWhiteBone);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<pets> myDataset, Activity activity) {
        this.mDataset     = myDataset;
        this.activity     = activity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        // ...

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final String myName = mDataset.get(position).getName();
        final int mpos = position;
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nName.setText(mDataset.get(position).getName());
        holder.mLikes.setText(String.valueOf(mDataset.get(position).getLikes()));
        holder.mImageView.setImageResource(mDataset.get(position).getPicture());


        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstructorPets consPets  = new ConstructorPets(activity);

                consPets.giveLike(mDataset.get(mpos));
                Toast.makeText(activity, "Diste like a: " + myName, Toast.LENGTH_SHORT).show();
                holder.mLikes.setText(String.valueOf(consPets.gatherPetLikes(mDataset.get(mpos))));

            }
        });



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}

