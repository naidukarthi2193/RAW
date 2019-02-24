package com.example.bytecamp_raw.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bytecamp_raw.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login_Page extends AppCompatActivity {

    private DatabaseReference mDatabase;
    EditText userName,pass1,pass2;
    Button hotel,volunteer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);
        userName = findViewById(R.id.user_name);
        pass1 = findViewById(R.id.pass1);
        pass2 = findViewById(R.id.pass2);
        hotel = findViewById(R.id.hotel_button);
        volunteer = findViewById(R.id.volunteer_button);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hotelIntent = new Intent(getApplicationContext(),Hotel_Home.class);
                startActivity(hotelIntent);
            }
        });
        volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.child("volunteer").child("username").child("name").setValue(userName.getText().toString());
                mDatabase.child("volunteer").child("username").child("count").setValue(0);
                Intent volunteerIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(volunteerIntent);
            }
        });


    }
}
