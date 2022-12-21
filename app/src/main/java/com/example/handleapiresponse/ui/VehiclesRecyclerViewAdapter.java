package com.example.handleapiresponse.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.handleapiresponse.R;
import com.example.handleapiresponse.model.Vehicle;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VehiclesRecyclerViewAdapter extends RecyclerView.Adapter<VehiclesRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Vehicle> vehicleList;
    private Context context;

    public VehiclesRecyclerViewAdapter(ArrayList<Vehicle> vehicleList, Context context) {
        this.vehicleList = vehicleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_cell, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vehicle vehicle = vehicleList.get(position);
        holder.tv_line_one.setText("Vehicle Number : "+vehicle.getNumberPlate());
        holder.tv_line_two.setText("Vehicle Asset ID : "+vehicle.getAssetsId());
        holder.tv_line_three.setText("DOP : "+vehicle.getDateTime());
        holder.tv_line_four.setText("GPS Status : "+vehicle.getGps());
        holder.tv_line_five.setText("Bettry Type : "+vehicle.getBatt());
    }

    @Override
    public int getItemCount() {
        if (vehicleList != null && vehicleList.size() > 0)
            return vehicleList.size();
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv_line_one, tv_line_two, tv_line_four, tv_line_five, tv_line_three;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_line_one = itemView.findViewById(R.id.tv_line_one);
            tv_line_two = itemView.findViewById(R.id.tv_line_two);
            tv_line_three = itemView.findViewById(R.id.tv_line_three);
            tv_line_four = itemView.findViewById(R.id.tv_line_four);
            tv_line_five = itemView.findViewById(R.id.tv_line_five);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Vehicle " + (vehicleList.get(getAdapterPosition()).getNumberPlate() +" is clicked"), Toast.LENGTH_SHORT).show();
        }


    }
    public void refreshData(ArrayList<Vehicle> dataList){
        this.vehicleList = dataList;
        notifyDataSetChanged();
    }
}
