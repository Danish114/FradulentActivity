package com.t4solution.fradulentactivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t4solution.fradulentactivity.R;
import com.t4solution.fradulentactivity.model.FraudulentActivity;

import java.util.List;

public class Adapter_FraudulentActivity extends RecyclerView.Adapter<Adapter_FraudulentActivity.FraudulentActivityViewHolder> {

    Context context;
    List<FraudulentActivity> fraudulentActivityList;

    public Adapter_FraudulentActivity(Context context, List<FraudulentActivity> fraudulentActivityList) {
        this.context = context;
        this.fraudulentActivityList = fraudulentActivityList;
    }

    @NonNull
    @Override
    public FraudulentActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycleview_fradulent_activity, parent, false);
        return new Adapter_FraudulentActivity.FraudulentActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FraudulentActivityViewHolder holder, int position) {

        holder.tv_FraudulentActivityInvolvementIn.setText(fraudulentActivityList.get(position).getInvolvementIn());
        holder.tv_FraudulentActivityQuantity.setText(fraudulentActivityList.get(position).getQuantity());
        holder.tv_FraudulentActivityRemarks.setText(fraudulentActivityList.get(position).getRemarks());
        holder.imageButton_Attahment.setImageResource(R.drawable.ic_attachment);

    }

    @Override
    public int getItemCount() {
        return fraudulentActivityList.size();
    }

    public class FraudulentActivityViewHolder extends RecyclerView.ViewHolder{

        TextView tv_FraudulentActivityInvolvementIn,tv_FraudulentActivityQuantity,tv_FraudulentActivityRemarks;
        ImageButton imageButton_Attahment;

        public FraudulentActivityViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_FraudulentActivityInvolvementIn=itemView.findViewById(R.id.tv_FraudulentActivityInvolvementIn);
            tv_FraudulentActivityQuantity=itemView.findViewById(R.id.tv_FraudulentActivityQuantity);
            tv_FraudulentActivityRemarks=itemView.findViewById(R.id.tv_FraudulentActivityRemarks);
            imageButton_Attahment=itemView.findViewById(R.id.imageButton_Attachment);

        }
    }
}
