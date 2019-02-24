package com.example.bytecamp_raw.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.bytecamp_raw.Model.HotelModel;
import com.example.bytecamp_raw.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class MissionDetail extends AppCompatActivity {
    Button start,end;
    public android.support.v7.widget.Toolbar toolbar;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_detail);
        Intent i = getIntent();
        final String name = i.getStringExtra("name");
        start = findViewById(R.id.start_location);
        end = findViewById(R.id.end_location);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final ArrayList<HotelModel> arrayList = new ArrayList<HotelModel>();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double lat = 23.09090;
                double lng= 30.090323;
                String strUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lng + " (" + "Label which you want" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double lat = 23.09090;
                double lng= 30.090323;
                String strUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lng + " (" + "Label which you want" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        mDatabase.child("hotel").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot uniquesnapshot : dataSnapshot.getChildren()){
                    Log.d("DetailActivity ", "Food Type " + uniquesnapshot.getValue(HotelModel.class).getFoodType());
                    if (uniquesnapshot.getValue(HotelModel.class).getFoodType().equals("abc")){
                        arrayList.add(uniquesnapshot.getValue(HotelModel.class));
                        Log.d(TAG, "onCreate: " + arrayList.get(0).getFoodType());

                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
