package com.example.bytecamp_raw.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bytecamp_raw.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailHotelActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);
        mDatabase = FirebaseDatabase.getInstance().getReference();

    }
}
