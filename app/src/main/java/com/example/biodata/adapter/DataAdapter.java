package com.example.biodata.adapter;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biodata.R;
import com.example.biodata.model.DataModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>{
    Context context;
    List<DataModel> dataModelList;

    public DataAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutdetail,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        final DataModel dataModel = dataModelList.get(position);
        holder.imgCircle.setImageResource(dataModel.getImageId());
        holder.tvName.setText(dataModel.getName());
        holder.tvAge.setText(dataModel.getAge());
        holder.tvGender.setText(dataModel.getGender());

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }


    public class DataViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgCircle;
        TextView tvName, tvAge, tvGender;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCircle = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvGender = itemView.findViewById(R.id.tvGender);
        }


    }
}
