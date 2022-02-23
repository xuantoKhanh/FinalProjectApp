package com.example.finalprojectapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>{

    public DataAdapter(List<Data> mListData) {
        this.mListData = mListData;
    }

    private List<Data> mListData;



    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);

        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Data data = mListData.get(position);
        if(data == null) {
            return;
        }
        holder.tvSp.setText(" " + data.getSp());
        holder.tvHR.setText(" " + data.getHr());
        holder.tvTime.setText(" " + data.getTime());

    }

    @Override
    public int getItemCount() {
        if(mListData != null){
            return mListData.size();
        }
        return 0;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView tvSp, tvHR, tvTime;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);


            tvSp   = itemView.findViewById(R.id.textViewSp);
            tvHR   = itemView.findViewById(R.id.textViewHR);
            tvTime = itemView.findViewById(R.id.textViewTime);
        }
    }

}
