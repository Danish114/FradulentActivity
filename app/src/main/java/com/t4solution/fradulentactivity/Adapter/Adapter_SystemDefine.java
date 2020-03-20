package com.t4solution.fradulentactivity.Adapter;

import android.app.Dialog;
import android.content.Context;
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
import com.t4solution.fradulentactivity.model.SystemDefined;

import java.util.List;

public class Adapter_SystemDefine extends RecyclerView.Adapter<Adapter_SystemDefine.SystemDefineViewHolder> {

    Context context;
    List<SystemDefined> systemDefinedList;
    Dialog dialog;
    Button buttonCancelReason,buttonSaveShowReason,buttonClearShowReason;
    ImageButton imgbtnCancelShowReason;
    EditText editTextShowUser,editTextShowUserDepartment,editTextShowPenaltyClause,editTextShowSurchargePerLitre,editTextShowPenaltyPercentOfProduct,editTextShowLumsum,editTextShowtotal,editTextShowRemarks;


    public Adapter_SystemDefine(Context context, List<SystemDefined> systemDefinedList) {
        this.context = context;
        this.systemDefinedList = systemDefinedList;
    }

    @NonNull
    @Override
    public SystemDefineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycleview_system_defined, parent, false);

        return new Adapter_SystemDefine.SystemDefineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SystemDefineViewHolder holder, int position) {

        holder.tv_SystemDefinedReason.setText(systemDefinedList.get(position).getReason());
        holder.tv_SystemDefinedSurchargePerLiter.setText(systemDefinedList.get(position).getSurchargePerLiter());
        holder.tv_SystemDefinedpenalty.setText(systemDefinedList.get(position).getPenalty());
        holder.tv_SystemDefinedPenaltyCause.setText(systemDefinedList.get(position).getPenaltyClause());
        holder.tv_SystemDefinedPenaltyCaseNo.setText(systemDefinedList.get(position).getPenaltyCaseNo());

    }

    @Override
    public int getItemCount() {
        return systemDefinedList.size();
    }

    public class SystemDefineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_SystemDefinedReason,tv_SystemDefinedPenaltyCause,tv_SystemDefinedPenaltyCaseNo,tv_SystemDefinedSurchargePerLiter,tv_SystemDefinedpenalty;

        public SystemDefineViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_SystemDefinedpenalty=itemView.findViewById(R.id.tv_SystemDefinedPenalty);
            tv_SystemDefinedPenaltyCaseNo=itemView.findViewById(R.id.tv_SystemDefinedPenaltyCaseNo);
            tv_SystemDefinedPenaltyCause=itemView.findViewById(R.id.tv_systemdefinedPenaltyCause);
            tv_SystemDefinedReason=itemView.findViewById(R.id.tv_SystemDefinedReason);
            tv_SystemDefinedSurchargePerLiter=itemView.findViewById(R.id.tv_SystemDefinedSurchargesPerLiter);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.equals(itemView)) {
                setShowReasonDialogBox();
            }
        }

        private void setShowReasonDialogBox() {
   /*         AlertDialog.Builder builder = new AlertDialog.Builder(context);
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
                        Toast.makeText(context, "Adapter SystemDefined unable to clear field  " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            });

            buttonSaveShowReason.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        int idPosition = getAdapterPosition();
                        String id = String.valueOf(idPosition);
                        Toast.makeText(context, " position is " + id, Toast.LENGTH_LONG).show();
                        SystemDefined systemDefined = new SystemDefined();
                        systemDefined.setId(idPosition);
                        String user = editTextShowUser.getText().toString();
                        systemDefined.setUser(user);
                        String penalty = editTextShowPenaltyPercentOfProduct.getText().toString();
                        systemDefined.setPenalty(penalty);
                        String userDepartment = editTextShowUserDepartment.getText().toString();
                        systemDefined.setUserDepartment(userDepartment);
                        String penaltyClause = editTextShowPenaltyClause.getText().toString();
                        systemDefined.setPenaltyClause(penaltyClause);
                        String surchargePerLitre = editTextShowSurchargePerLitre.getText().toString();
                        systemDefined.setSurchargePerLiter(surchargePerLitre);
                        String lumSum = editTextShowLumsum.getText().toString();
                        systemDefined.setLumSum(lumSum);
                        String total = editTextShowtotal.getText().toString();
                        systemDefined.setTotal(total);
                        String remarks = editTextShowRemarks.getText().toString();
                        systemDefined.setRemarks(remarks);
/*
                        Adapter_AccountPayableHeadOffice adapter_accountPayableHeadOffice=new Adapter_AccountPayableHeadOffice();

                      *//*  int position =getAdapterPosition();
                        accountPayableHeadOfficeList.remove(position);
                        notifyItemRemoved(position);
                        accountPayableHeadOfficeList.add(position,systemDefined);
                        adapter_accountPayableHeadOffice.notifyDataSetChanged();

                        new DBHelper(context).UpdateAccountPayableHeadOffice(systemDefined);
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

            SystemDefined systemDefined = systemDefinedList.get(getAdapterPosition());
            try {
                editTextShowUser.setText(systemDefined.getUser());
                editTextShowPenaltyPercentOfProduct.setText(systemDefined.getPenalty());
                editTextShowUserDepartment.setText(systemDefined.getUserDepartment());
                editTextShowPenaltyClause.setText(systemDefined.getPenaltyClause());
                editTextShowSurchargePerLitre.setText(systemDefined.getSurchargePerLiter());
                editTextShowLumsum.setText(systemDefined.getLumSum());
                editTextShowtotal.setText(systemDefined.getTotal());
                editTextShowRemarks.setText(systemDefined.getRemarks());

            } catch (Exception e) {
                Toast.makeText(context, "Adapter LogisticHeadOffice  " + e.getMessage(), Toast.LENGTH_LONG).show();
            }

/*
            alertDialog = builder.create();
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.show();
*/
            dialog.show();
        }


    }
}
