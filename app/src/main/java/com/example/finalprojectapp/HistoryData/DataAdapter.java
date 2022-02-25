package com.example.finalprojectapp.HistoryData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.finalprojectapp.R;
import com.example.finalprojectapp.fragment.HistoryFragment;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>{

    private List<Data> mListData;
    public DataAdapter(List<Data> mListData) {
        this.mListData = mListData;
    }

    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public DataAdapter() {
    }

    public void setListaData(Data datas){
        mListData.add(datas);
        notifyDataSetChanged();
    }

    public void setDatas(ArrayList<Data> datas){
        if(datas != null && !datas.isEmpty()) {
            mListData = new ArrayList<>();
            mListData.addAll(datas);
            notifyDataSetChanged();
        }

    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //tạo view cho Recycler view là file item_data
        //gán view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) { //gán data và ánh xạ view

        Data data1 = mListData.get(position);
        if(data1 == null) {
            return;
        }

        viewBinderHelper.bind(holder.swipeRevealLayout, String.valueOf(data1.getHr()));
        holder.tvSp.setText(" " + data1.getSp());
        holder.tvHR.setText(" " + data1.getHr());
        holder.tvTime.setText(" " + data1.getTime());

        holder.layoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                HistoryFragment.listHistory.mListData.remove(holder.getAdapterPosition());
               mListData.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() { //trả item tại vị trí postion
        if(mListData != null){
            return mListData.size();
        }
        return 0;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView tvSp, tvHR, tvTime;
        private SwipeRevealLayout swipeRevealLayout;
        private LinearLayout layoutDelete;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            swipeRevealLayout = itemView.findViewById(R.id.swipe);
            layoutDelete      = itemView.findViewById(R.id.layout_deleter);
            tvSp   = itemView.findViewById(R.id.textViewSp);
            tvHR   = itemView.findViewById(R.id.textViewHR);
            tvTime = itemView.findViewById(R.id.textViewTime);
        }
    }

}
