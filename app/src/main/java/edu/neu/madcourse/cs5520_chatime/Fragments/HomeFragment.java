package edu.neu.madcourse.cs5520_chatime.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.neu.madcourse.cs5520_chatime.BottleActivity;
import edu.neu.madcourse.cs5520_chatime.MainActivity;
import edu.neu.madcourse.cs5520_chatime.R;


public class HomeFragment extends Fragment {

    Button createBottle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        createBottle = view.findViewById(R.id.create_bottle_Btn);
        createBottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BottleActivity.class);
                startActivity(intent); ;
            }
        });
    }

    public HomeFragment() {
        // Required empty public constructor
    }
}