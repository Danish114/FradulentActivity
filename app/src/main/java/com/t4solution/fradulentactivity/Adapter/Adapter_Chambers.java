package com.t4solution.fradulentactivity.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t4solution.fradulentactivity.R;
import com.t4solution.fradulentactivity.model.Chambers;

import java.util.List;

public class Adapter_Chambers extends RecyclerView.Adapter<Adapter_Chambers.ChamberViewHolder> {

    int status=0;
    Context context;
    List<Chambers> chambersList;
    private int selected_position=0;

    public Adapter_Chambers(Context context, List<Chambers> chambersList) {
        this.context = context;
        this.chambersList = chambersList;
    }

    @NonNull
    @Override
    public ChamberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycleview_chambers, parent, false);
        return new Adapter_Chambers.ChamberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChamberViewHolder holder, int position) {

        TextView tv_chamber = holder.tv_chamber;

        tv_chamber.setText(chambersList.get(position).getChamber());
        holder.itemView.setBackgroundColor(selected_position == position ? Color.RED : Color.TRANSPARENT);


    }

    @Override
    public int getItemCount() {
        return chambersList.size();
    }

    public class ChamberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout linearLayout;
        TextView tv_chamber;
        public ChamberViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            tv_chamber=itemView.findViewById(R.id.tv_Chamber);
            linearLayout=itemView.findViewById(R.id.layout_chamber);
        }

        @Override
        public void onClick(View v) {
            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;

            // Updating old as well as new positions
            notifyItemChanged(selected_position);
            selected_position = getAdapterPosition();
            notifyItemChanged(selected_position);

        }
    }

}
