package com.example.bytecamp_raw.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bytecamp_raw.Model.HotelModel;
import com.example.bytecamp_raw.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by venkat on 24/2/19.
 */
public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.MyViewHolder> {

    public HotelsAdapter(ArrayList<HotelModel> hotelModels) {
        this.hotelModels = hotelModels;
    }
    ArrayList<HotelModel> hotelModels;

    @NonNull
    @Override
    public HotelsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.hotel_card, viewGroup, false);
        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull HotelsAdapter.MyViewHolder myViewHolder, int i) {
                HotelModel hotelModel = hotelModels.get(i);
                myViewHolder.hotelName.setText(hotelModel.getFoodType());
                myViewHolder.description.setText(hotelModel.getDescription());
        Log.d("HotelsAdapter", "onBindViewHolder: " + hotelModel.getName());
    }

    @Override
    public int getItemCount() {
        return (hotelModels == null) ? 0 : hotelModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView hotelName, description, year, genre;

        public MyViewHolder(View view) {
            super(view);
            hotelName = (TextView) view.findViewById(R.id.hotel_nm);
            description = (TextView) view.findViewById(R.id.hotel_desptn);
        }
    }
}
