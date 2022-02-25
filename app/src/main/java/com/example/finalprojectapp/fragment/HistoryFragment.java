package com.example.finalprojectapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectapp.HistoryData.Data;
import com.example.finalprojectapp.HistoryData.DataAdapter;
import com.example.finalprojectapp.R;
import com.example.finalprojectapp.HistoryData.UIModel;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {


    private RecyclerView recycleView;
    public static DataAdapter mdataAdapter;
    public static Boolean isResume = false;
    private static ArrayList<Data> listHistory = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);


        //khoi tao
        recycleView = (RecyclerView) view.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycleView.setLayoutManager(linearLayoutManager);

        if(ResultFragment.spf != null){
            listHistory = UIModel.getInstance().provideGSon().fromJson(ResultFragment.spf.getString("LISTDATA"),new TypeToken<ArrayList<Data>>() {
            }.getType() );

        }

        mdataAdapter = new DataAdapter();
        mdataAdapter.setDatas(listHistory);
        recycleView.setAdapter(mdataAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recycleView.addItemDecoration(itemDecoration);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        isResume = true;
    }
}
