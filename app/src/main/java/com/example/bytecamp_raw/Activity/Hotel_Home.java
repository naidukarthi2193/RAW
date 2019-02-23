package com.example.bytecamp_raw.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.bytecamp_raw.Adapter.hotel_home;
import com.example.bytecamp_raw.Model.hotel_home_model;
import com.example.bytecamp_raw.R;

import java.util.ArrayList;
import java.util.List;

public class Hotel_Home extends AppCompatActivity {
    private RecyclerView contributions;
    private RecyclerView.Adapter contriAdapter;
    private List<hotel_home_model> listItems;
    private CardView card1;
    private CardView card2;
    private CardView card3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel__home);

        contributions=findViewById(R.id.contri_recycler);
        contributions.setHasFixedSize(true);
        contributions.setLayoutManager(new LinearLayoutManager(this));
        listItems=new ArrayList<>();
        listItems.add(new hotel_home_model("12 Jan 2018","12:30 pm","IN PROGRESS",1));
        listItems.add(new hotel_home_model("13 Jan 2018","12:30 pm","DONATED",2));
        listItems.add(new hotel_home_model("14 Jan 2018","12:30 pm","DONATED",2));
        listItems.add(new hotel_home_model("15 Jan 2018","12:30 pm","COMPOST",3));
        listItems.add(new hotel_home_model("16 Jan 2018","12:30 pm","COMPOST",3));
        contriAdapter = new hotel_home(this,listItems);
        contributions.setAdapter(contriAdapter);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
////                Intent intent1 = new Intent(Hotel_Home.this,);
//                intent1.putExtra("date","12 January 2018");
//                intent1.putExtra("date","12:30 pm");
//                intent1.putExtra("date",1);
//                startActivity(intent1);
            }
        });






    }
}
