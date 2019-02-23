package com.example.bytecamp_raw.Activity.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bytecamp_raw.R;
import com.example.bytecamp_raw.Services.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by venkat on 23/2/19.
 */
public class AddFoodFragment extends BottomSheetDialogFragment {
    BottomSheetDialog bottomSheetDialog;
    FirebaseDatabase database;
    DatabaseReference myref;
    EditText hotelName,foodType,foodQty,foodFresh;
    Button submit;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        bottomSheetDialog = new BottomSheetDialog(getActivity(), R.style.BottomSheetDialogTheme);
        View sheetView = getActivity().getLayoutInflater().inflate(R.layout.add_food, null);
        bottomSheetDialog.setContentView(sheetView);
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogTheme);
        bottomSheetDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        bottomSheetDialog.show();
        database = FirebaseDatabase.getInstance();
        myref = database.getReference("hotel");
        hotelName = sheetView.findViewById(R.id.hotel_name);
        foodType = sheetView.findViewById(R.id.food_type);
        foodQty = sheetView.findViewById(R.id.food_quantity);
        foodFresh = sheetView.findViewById(R.id.food_freshness);
        submit = sheetView.findViewById(R.id.bt_confirm);
        final Date currentTime = Calendar.getInstance().getTime();

        final GPSTracker gps = new GPSTracker(getActivity());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myref =  FirebaseDatabase.getInstance().getReference();
                myref.child("hotel").child(hotelName.getText().toString()).child("FoodType").setValue(foodType.getText().toString());
                myref.child("hotel").child(hotelName.getText().toString()).child("Freshness").setValue(foodFresh.getText().toString());
                myref.child("hotel").child(hotelName.getText().toString()).child("Quantity").setValue(foodQty.getText().toString());
                myref.child("hotel").child(hotelName.getText().toString()).child("Location").child("Lat").setValue("22.539970");
                myref.child("hotel").child(hotelName.getText().toString()).child("Location").child("Long").setValue("88.370240");
                myref.child("hotel").child(hotelName.getText().toString()).child("DonationTime").setValue(currentTime.toString());

            }
        });

        return bottomSheetDialog;
    }

    @Override
    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }


}
