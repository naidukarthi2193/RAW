package com.example.bytecamp_raw.Activity.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.bytecamp_raw.Adapter.HotelsAdapter;
import com.example.bytecamp_raw.Model.HotelModel;
import com.example.bytecamp_raw.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by venkat on 23/2/19.
 */
public class DistributionFragment extends Fragment {

    RecyclerView recyclerView;
    HotelsAdapter adapter;
    HotelModel model;
    ArrayList<HotelModel> hotelList;
    private DatabaseReference mDatabase;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.distribution_fragment, container, false);
        recyclerView = view.findViewById(R.id.distribution_recycler);
        hotelList = new ArrayList<HotelModel>();
        adapter = new HotelsAdapter(hotelList,getActivity());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL,false);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("hotel").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot uniquesnapshot : dataSnapshot.getChildren()){
      //              for (DataSnapshot dataSnapshot1 : uniquesnapshot.child("d").getChildren()) {

                  //      Log.d("DetailActivity", "onDataChange: " + uniquesnapshot.getValue());
                   //     Log.d("DetailActivity ", "Food Type " + uniquesnapshot.getValue(HotelModel.class).getName());
//                        model = uniquesnapshot.getValue(HotelModel.class);
                   //     Log.d(TAG, "onDataChange: " + model.getName());
                        if (model != null) {
                            hotelList.add(uniquesnapshot.getValue(HotelModel.class));
   //                     }
                    }
                }
//                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Log.d(TAG, "onDataChange: " + adapter.getItemCount());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        adapter.notifyDataSetChanged();
        return view;
    }
}
