package com.example.finalprojectapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.finalprojectapp.Data;
import com.example.finalprojectapp.MySharedPreferences;
import com.example.finalprojectapp.R;
import com.example.finalprojectapp.UIModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ResultFragment extends Fragment {

    DatabaseReference mData;
    TextView textViewHR, textViewSpo2, text;
    public static ArrayList<Data> mList = new ArrayList<>();

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


        mData.child("Store/hr").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.e("HR -- ", snapshot.getValue().toString());
                textViewHR.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mData.child("Store/sp").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.e("SP -- ", snapshot.getValue().toString());
                textViewSpo2.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mList = UIModel.getInstance().provideGSon().fromJson(ResultFragment.spf.getString("LISTDATA"), new TypeToken<ArrayList<Data>>() {
        }.getType());
        getDatatoObject();

        return view;
    }

    public void getDatatoObject() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Store");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Data data = snapshot.getValue(Data.class);
                mList.add(data);
                getSPFInstance().setString("LISTDATA", UIModel.getInstance().provideGSon().toJson(mList));
                Log.e("mList", mList.size() + "");

                if (HistoryFragment.isResume && HistoryFragment.mdataAdapter != null) {
                    HistoryFragment.mdataAdapter.setListaData(data);
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
}
