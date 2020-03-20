package com.t4solution.fradulentactivity.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t4solution.fradulentactivity.R;
import com.t4solution.fradulentactivity.model.LogisticHeadOffice;

import java.util.ArrayList;
import java.util.List;

public class Adapter_LogisticHeadOffice extends RecyclerView.Adapter<Adapter_LogisticHeadOffice.LogisticHeadOfficeViewHolder> {

    Context context;
    Dialog dialog;
    List<LogisticHeadOffice> logisticHeadOfficeList;
    Button buttonCancelReason,buttonSaveShowReason,buttonClearShowReason;
    ImageButton imgbtnCancelShowReason;
    EditText editTextShowUser,editTextShowUserDepartment,editTextShowPenaltyClause,editTextShowSurchargePerLitre,editTextShowPenaltyPercentOfProduct,editTextShowLumsum,editTextShowtotal,editTextShowRemarks;

    public Adapter_LogisticHeadOffice(Context context, List<LogisticHeadOffice> logisticHeadOfficeList) {
        this.context = context;
        this.logisticHeadOfficeList = logisticHeadOfficeList;
    }

    @NonNull
    @Override
    public LogisticHeadOfficeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.recycleview_logistic_head_officce, parent, false);

        return new Adapter_LogisticHeadOffice.LogisticHeadOfficeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull LogisticHeadOfficeViewHolder holder, int position) {

        holder.tv_LogisticHeadOffice_Penalty.setText(logisticHeadOfficeList.get(position).getPenalty());
        holder.tv_LogisticHeadOffice_PenaltyClauseNo.setText(logisticHeadOfficeList.get(position).getPenaltyCaseNo());
        holder.tv_LogisticHeadOffice_PenaltyCause.setText(logisticHeadOfficeList.get(position).getPenaltyClause());
        holder.tv_LogisticHeadOffice_Reason.setText(logisticHeadOfficeList.get(position).getReason());
        holder.tv_LogisticHeadOffice_SurchargePerLiter.setText(logisticHeadOfficeList.get(position).getSurchargePerLiter());

    }

    @Override
    public int getItemCount() {
        return logisticHeadOfficeList.size();
    }

    public class LogisticHeadOfficeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        Layout layout;
        TextView tv_LogisticHeadOffice_Reason, tv_LogisticHeadOffice_PenaltyClauseNo, tv_LogisticHeadOffice_SurchargePerLiter, tv_LogisticHeadOffice_Penalty, tv_LogisticHeadOffice_PenaltyCause;

        public LogisticHeadOfficeViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_LogisticHeadOffice_Penalty = itemView.findViewById(R.id.tv_LogisticHeadOffice_Penalty);
            tv_LogisticHeadOffice_PenaltyCause = itemView.findViewById(R.id.tv_LogisticHeadOffice_PenaltyCaseNo);
            tv_LogisticHeadOffice_PenaltyClauseNo = itemView.findViewById(R.id.tv_LogisticHeadOffice_PenaltyClause);
            tv_LogisticHeadOffice_Reason = itemView.findViewById(R.id.tv_LogisticHeadOffice_Reason);
            tv_LogisticHeadOffice_SurchargePerLiter = itemView.findViewById(R.id.tv_LogisticHeadOffice_SurchargePerLiter);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.equals(itemView)) {
                setShowReasonDialogBox();
            }
        }

        private void setShowReasonDialogBox() {
/*
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            ViewGroup viewGroup = itemView.findViewById(android.R.id.content);
            View inflate = LayoutInflater.from(context).inflate(R.layout.show_reason, viewGroup, false);
            builder.setView(inflate);
*/
            dialog = new Dialog(context, android.R.style.Theme_Translucent);
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.show_reason);
            dialog.setCancelable(false);

            editTextShowUser = dialog.findViewById(R.id.editTextShowUser);
            editTextShowUserDepartment = dialog.findViewById(R.id.editTextShowUserDepartment);
            editTextShowPenaltyClause = dialog.findViewById(R.id.editTextShowPenaltyClause);
            editTextShowSurchargePerLitre = dialog.findViewById(R.id.editTextShowSurchargePerLitre);
            editTextShowPenaltyPercentOfProduct = dialog.findViewById(R.id.editTextShowPenaltyPercentOfProduct);
            editTextShowLumsum = dialog.findViewById(R.id.editTextShowLumsum);
            editTextShowtotal = dialog.findViewById(R.id.editTextShowtotal);
            editTextShowRemarks = dialog.findViewById(R.id.editTextShowRemarks);
            imgbtnCancelShowReason = dialog.findViewById(R.id.imgbtnCancelShowReason);
            buttonCancelReason = dialog.findViewById(R.id.buttonCancelReason);
            buttonSaveShowReason = dialog.findViewById(R.id.buttonSaveShowReason);
            buttonClearShowReason = dialog.findViewById(R.id.buttonClearShowReason);
            buttonClearShowReason.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        editTextShowUser.setText("");
                        editTextShowPenaltyPercentOfProduct.setText("");
                        editTextShowUserDepartment.setText("");
                        editTextShowPenaltyClause.setText("");
                        editTextShowSurchargePerLitre.setText("");
                        editTextShowLumsum.setText("");
                        editTextShowtotal.setText("");
                        editTextShowRemarks.setText("");

                    } catch (Exception e) {
                        Toast.makeText(context, "Adapter LogisticHeadOffice unable to clear field  " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            });

            buttonSaveShowReason.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<LogisticHeadOffice> aPHList = new ArrayList<>();
                    try {
                        int idPosition = getAdapterPosition();
                        String id = String.valueOf(idPosition);
                        Toast.makeText(context, " position is " + id, Toast.LENGTH_LONG).show();
                        LogisticHeadOffice logisticHeadOffice = new LogisticHeadOffice();
                        logisticHeadOffice.setId(idPosition);
                        String user = editTextShowUser.getText().toString();
                        logisticHeadOffice.setUser(user);
                        String penalty = editTextShowPenaltyPercentOfProduct.getText().toString();
                        logisticHeadOffice.setPenalty(penalty);
                        String userDepartment = editTextShowUserDepartment.getText().toString();
                        logisticHeadOffice.setUserDepartment(userDepartment);
                        String penaltyClause = editTextShowPenaltyClause.getText().toString();
                        logisticHeadOffice.setPenaltyClause(penaltyClause);
                        String surchargePerLitre = editTextShowSurchargePerLitre.getText().toString();
                        logisticHeadOffice.setSurchargePerLiter(surchargePerLitre);
                        String lumSum = editTextShowLumsum.getText().toString();
                        logisticHeadOffice.setLumSum(lumSum);
                        String total = editTextShowtotal.getText().toString();
                        logisticHeadOffice.setTotal(total);
                        String remarks = editTextShowRemarks.getText().toString();
                        logisticHeadOffice.setRemarks(remarks);
/*
                        Adapter_AccountPayableHeadOffice adapter_accountPayableHeadOffice=new Adapter_AccountPayableHeadOffice();

                      *//*  int position =getAdapterPosition();
                        accountPayableHeadOfficeList.remove(position);
                        notifyItemRemoved(position);
                        accountPayableHeadOfficeList.add(position,logisticHeadOffice);
                        adapter_accountPayableHeadOffice.notifyDataSetChanged();

                        new DBHelper(context).UpdateAccountPayableHeadOffice(logisticHeadOffice);
*/
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(context, "unable to update a user " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });

            buttonCancelReason.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            imgbtnCancelShowReason.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            LogisticHeadOffice logisticHeadOffice = logisticHeadOfficeList.get(getAdapterPosition());
            try {
                editTextShowUser.setText(logisticHeadOffice.getUser());
                editTextShowPenaltyPercentOfProduct.setText(logisticHeadOffice.getPenalty());
                editTextShowUserDepartment.setText(logisticHeadOffice.getUserDepartment());
                editTextShowPenaltyClause.setText(logisticHeadOffice.getPenaltyClause());
                editTextShowSurchargePerLitre.setText(logisticHeadOffice.getSurchargePerLiter());
                editTextShowLumsum.setText(logisticHeadOffice.getLumSum());
                editTextShowtotal.setText(logisticHeadOffice.getTotal());
                editTextShowRemarks.setText(logisticHeadOffice.getRemarks());

            } catch (Exception e) {
                Toast.makeText(context, "Adapter LogisticHeadOffice  " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
/*
            alertDialog = builder.create();
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));*/
            dialog.show();
        }

    }
}
