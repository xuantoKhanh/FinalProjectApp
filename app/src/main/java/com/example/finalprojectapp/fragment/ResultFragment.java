package com.example.finalprojectapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.finalprojectapp.HistoryData.Data;
import com.example.finalprojectapp.HistoryData.MySharedPreferences;
import com.example.finalprojectapp.Measurement_Results;
import com.example.finalprojectapp.R;
import com.example.finalprojectapp.HistoryData.UIModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ResultFragment extends Fragment {

    Float i;

    DatabaseReference mData;
    TextView textViewHR, textViewSpo2, text;
    public static ArrayList<Data> mList = new ArrayList<>();
    String keys = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_results, container, false);

        textViewSpo2 = (TextView) view.findViewById(R.id.spValue);
        textViewHR = (TextView) view.findViewById(R.id.hrValue);
        text = (TextView) view.findViewById(R.id.banner);
        getSPFInstance();
        mData = FirebaseDatabase.getInstance().getReference();
        keys = ResultFragment.spf.getString("LISTDATA");
        if (!keys.equalsIgnoreCase(""))
            mList = UIModel.getInstance().provideGSon().fromJson(ResultFragment.spf.getString("LISTDATA"), new TypeToken<ArrayList<Data>>() {
            }.getType());
        getDatatoObject();

        mData.child("Heart rate").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.e("HR -- ", snapshot.getValue().toString());
                textViewHR.setText(snapshot.getValue().toString());
                //Toast.makeText(getActivity(), "Your Heart Rate is abnormal!", Toast.LENGTH_LONG).show();

                float i = Float.parseFloat(snapshot.getValue().toString());
                if (i < 60.00 || i > 100.00) {
                    Toast.makeText(getActivity(), "Your Heart Rate is abnormal!", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mData.child("SpO2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.e("SP -- ", snapshot.getValue().toString());
                textViewSpo2.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return view;
    }

    public void getDatatoObject() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Store");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Data data = snapshot.getValue(Data.class);
                Log.e("Go here", UIModel.getInstance().provideGSon().toJson(data));

                if (data != null) {
                    if (!keys.equalsIgnoreCase(""))
                        mList = UIModel.getInstance().provideGSon().fromJson(ResultFragment.spf.getString("LISTDATA"), new TypeToken<ArrayList<Data>>() {
                        }.getType());
                    mList.add(data);
                    getSPFInstance().setString("LISTDATA", UIModel.getInstance().provideGSon().toJson(mList));
                    Log.e("mList", mList.size() + "");
                    if (HistoryFragment.isResume && HistoryFragment.mdataAdapter != null) {
                        HistoryFragment.mdataAdapter.setListaData(data);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }

    public static MySharedPreferences spf;

    public MySharedPreferences getSPFInstance() {
        if (spf == null) {
            spf = new MySharedPreferences(getContext());
        }
        return spf;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
