package com.example.bytecamp_raw.Activity.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bytecamp_raw.Activity.MissionDetail;
import com.example.bytecamp_raw.Activity.startMission;
import com.example.bytecamp_raw.Model.HotelModel;
import com.example.bytecamp_raw.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by venkat on 23/2/19.
 */
public class ActivityFragment  extends Fragment {
    private DatabaseReference mDatabase;
    Button start;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment, container, false);
        SharedPreferences prefs =getActivity().getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        final String name = prefs.getString("name",null);
        Log.d("ActivityFragment", "onCreateView: " + name);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        start = view.findViewById(R.id.start_button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), startMission.class);
                startActivity(intent);
            }
        });
//        mDatabase.child("volunteer").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
//                        if (dataSnapshot1.getValue(HotelModel.class).getName().equals(name)){
//                                String HotelName = dataSnapshot1.getValue(HotelModel.class).getName();
//                                String FoodType = dataSnapshot1.getValue(HotelModel.class).getFoodType();
//                                String Quantity = dataSnapshot1.getValue(HotelModel.class).getQuantity();
//                                String Freshness = dataSnapshot1.getValue(HotelModel.class).getFreshness();
//
//                        }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        return view;
    }
}
