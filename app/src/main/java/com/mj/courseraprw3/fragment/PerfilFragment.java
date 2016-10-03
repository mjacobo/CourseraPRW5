package com.mj.courseraprw3.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.mj.courseraprw3.Adapter.ProfileAdapter;
import com.mj.courseraprw3.R;
import com.mj.courseraprw3.pets;

import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    ArrayList<pets> myPetList, mojo;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Random random;
    private TextView  PetName;
    private CircularImageView PetPic;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        setMojo();
        setData(0);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.rcvMyPetMatrix);
        mRecyclerView.setHasFixedSize(true);
        PetName = (TextView) v.findViewById(R.id.actvProfilePetName);
        PetPic  = (CircularImageView) v.findViewById(R.id.civProfilePhoto);
        PetName.setText(mojo.get(0).getName());
        PetPic.setImageResource(mojo.get(0).getPicture());

        mLayoutManager = new GridLayoutManager(getActivity(),3);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new ProfileAdapter(myPetList);
        mRecyclerView.setAdapter(mAdapter);


        return v;
    }


    public void setData(int element)
    {
        int maxPic = 0;

        random = new Random();
        myPetList = new ArrayList<>();
        maxPic = random.nextInt(20);
        for(int i=0; i < maxPic; i++ ) {
            myPetList.add(new pets(mojo.get(element).getId(), mojo.get(element).getName(),random.nextInt(10), mojo.get(element).getPicture()));
        }
    }

    public void receiveEle(int element){
        PetName.setText(mojo.get(element).getName());
        PetPic.setImageResource(mojo.get(element).getPicture());
        myPetList.clear();
        setData(element);
        mRecyclerView.setAdapter(new ProfileAdapter(myPetList));
        mRecyclerView.invalidate();
    }

    void setMojo (){
        mojo = new ArrayList<>();

        mojo.add(new pets(1,"Beary",1, R.drawable.bear));
        mojo.add(new pets(2,"Beavery",2, R.drawable.beaver));
        mojo.add(new pets(3,"Caty",3, R.drawable.cat));
        mojo.add(new pets(4,"Cowy",4, R.drawable.cow));
        mojo.add(new pets(5,"Doggy",5, R.drawable.dog));
        mojo.add(new pets(6,"Elephanty",6, R.drawable.elephant));
        mojo.add(new pets(7,"Goaty",7, R.drawable.goat));
        mojo.add(new pets(8,"Horsy",8, R.drawable.horse));
        mojo.add(new pets(9,"Jiraffy",9, R.drawable.jiraff));
        mojo.add(new pets(10,"Lamby",10, R.drawable.lamb));
        mojo.add(new pets(11,"Monkey",11, R.drawable.monkey));
        mojo.add(new pets(12,"Moosy",12, R.drawable.moose));
        mojo.add(new pets(13,"Owly",13, R.drawable.owl));
        mojo.add(new pets(14,"Pandy",14, R.drawable.panda));
        mojo.add(new pets(15,"Piggy",15, R.drawable.pig));
        mojo.add(new pets(16,"Ramy",16, R.drawable.ram));
        mojo.add(new pets(17,"Rhiny",17, R.drawable.rhino));
        mojo.add(new pets(18,"Tiggy",18, R.drawable.tiger));
        mojo.add(new pets(19,"Turkky",19, R.drawable.turkey));
        mojo.add(new pets(20,"Zebry",20, R.drawable.zebra));
    }
}
