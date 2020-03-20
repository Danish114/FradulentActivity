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

import com.t4solution.fradulentactivity.DB.DBHelper;
import com.t4solution.fradulentactivity.MainActivity;
import com.t4solution.fradulentactivity.R;
import com.t4solution.fradulentactivity.model.AccountPayableHeadOffice;

import java.util.ArrayList;
import java.util.List;

public class Adapter_AccountPayableHeadOffice extends RecyclerView.Adapter<Adapter_AccountPayableHeadOffice.AccountPayableHeadOfficeViewHolder> {

    Context context;
    List<AccountPayableHeadOffice> accountPayableHeadOfficeList;
    Button buttonCancelReason,buttonSaveShowReason,buttonClearShowReason;
    ImageButton imgbtnCancelShowReason;
    EditText editTextShowUser,editTextShowUserDepartment,editTextShowPenaltyClause,editTextShowSurchargePerLitre,editTextShowPenaltyPercentOfProduct,editTextShowLumsum,editTextShowtotal,editTextShowRemarks;
    private Dialog dialog;

    public Adapter_AccountPayableHeadOffice(Context context, List<AccountPayableHeadOffice> accountPayableHeadOfficeList) {
        this.context = context;
        this.accountPayableHeadOfficeList = accountPayableHeadOfficeList;
    }
    public Adapter_AccountPayableHeadOffice(){

    }


    @NonNull
    @Override
    public AccountPayableHeadOfficeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.recycleview_account_payable, parent, false);

        return new Adapter_AccountPayableHeadOffice.AccountPayableHeadOfficeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountPayableHeadOfficeViewHolder holder, int position) {

        holder.tv_AccountPayableHeadOfficeReason.setText(accountPayableHeadOfficeList.get(position).getReason());
        holder.tv_AccountPayableHeadOfficePenality.setText(accountPayableHeadOfficeList.get(position).getPenalty());
        holder.tv_AccountPayableHeadOfficePenaltyCase.setText(accountPayableHeadOfficeList.get(position).getPenaltyCaseNo());
        holder.tv_AccountPayableHeadOfficePenaltyClauseNo.setText(accountPayableHeadOfficeList.get(position).getPenaltyClause());
        holder.tv_AccountPayableHeadOfficeSurchargePerLiter.setText(accountPayableHeadOfficeList.get(position).getSurchargePerLiter());
        holder.imageButtonClose.setImageResource(R.drawable.ic_deletebutton);

    }

    @Override
    public int getItemCount() {
        return accountPayableHeadOfficeList.size();
    }

    public class AccountPayableHeadOfficeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_AccountPayableHeadOfficeReason,tv_AccountPayableHeadOfficePenaltyClauseNo,tv_AccountPayableHeadOfficePenaltyCase,tv_AccountPayableHeadOfficeSurchargePerLiter,tv_AccountPayableHeadOfficePenality;
        ImageButton imageButtonClose;

        public AccountPayableHeadOfficeViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_AccountPayableHeadOfficePenality=itemView.findViewById(R.id.tv_AccountPayableHeadOfficePenalty);
            tv_AccountPayableHeadOfficePenaltyCase=itemView.findViewById(R.id.tv_AccountPayableHeadOfficePenaltyCase);
            tv_AccountPayableHeadOfficePenaltyClauseNo=itemView.findViewById(R.id.tv_AccountPayableHeadOfficePenaltyClauseNo);
            tv_AccountPayableHeadOfficeReason=itemView.findViewById(R.id.tv_AccountPayableHeadOfficeReason);
            tv_AccountPayableHeadOfficeSurchargePerLiter=itemView.findViewById(R.id.tv_AccountPayableHeadOfficeSurchargePerLiter);
            imageButtonClose=itemView.findViewById(R.id.imageButton_AccountPayableHeadOfficeClose);
            imageButtonClose.setOnClickListener(this);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if(v.equals(imageButtonClose)){
                //removeAt(getAdapterPosition());
                removeAt( accountPayableHeadOfficeList.get(getAdapterPosition()).getId());
            }else if (v.equals(itemView)) {
                setShowReasonDialogBox();
            }/* else if (v.equals(buttonCancelReason)) {

                alertDialog.dismiss();

            } else if (v.equals(imgbtnCancelShowReason)) {
                alertDialog.dismiss();
            }*/
        }

        private void setShowReasonDialogBox() {
     /*       AlertDialog.Builder builder=new AlertDialog.Builder(context);
            ViewGroup viewGroup=itemView.findViewById(android.R.id.content);
            View inflate = LayoutInflater.from(context).inflate(R.layout.show_reason, viewGroup, false);
            builder.setView(inflate);
*/
            dialog = new Dialog(context, android.R.style.Theme_Translucent);
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.show_reason);
            dialog.setCancelable(false);

            editTextShowUser= dialog.findViewById(R.id.editTextShowUser);
            editTextShowUserDepartment= dialog.findViewById(R.id.editTextShowUserDepartment);
            editTextShowPenaltyClause= dialog.findViewById(R.id.editTextShowPenaltyClause);
            editTextShowSurchargePerLitre= dialog.findViewById(R.id.editTextShowSurchargePerLitre);
            editTextShowPenaltyPercentOfProduct= dialog.findViewById(R.id.editTextShowPenaltyPercentOfProduct);
            editTextShowLumsum= dialog.findViewById(R.id.editTextShowLumsum);
            editTextShowtotal= dialog.findViewById(R.id.editTextShowtotal);
            editTextShowRemarks= dialog.findViewById(R.id.editTextShowRemarks);
            imgbtnCancelShowReason= dialog.findViewById(R.id.imgbtnCancelShowReason);
            buttonCancelReason= dialog.findViewById(R.id.buttonCancelReason);
            buttonSaveShowReason= dialog.findViewById(R.id.buttonSaveShowReason);
            buttonClearShowReason= dialog.findViewById(R.id.buttonClearShowReason);

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

                    }catch (Exception e){
                        Toast.makeText(context,"Adapter AccountPayableHeadOffice unable to clear field  " +e.getMessage(),Toast.LENGTH_LONG).show();
                    }

                }
            });

            buttonSaveShowReason.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<AccountPayableHeadOffice> aPHList=new ArrayList<>();

                    try {
                        int id=accountPayableHeadOfficeList.get(getAdapterPosition()).getId();
                        Toast.makeText(context," position is " + id,Toast.LENGTH_LONG).show();
                        AccountPayableHeadOffice accountPayableHeadOffice=new AccountPayableHeadOffice();
                        accountPayableHeadOffice.setId(id);
                        String user = editTextShowUser.getText().toString();
                        accountPayableHeadOffice.setUser(user);
                        String penalty = editTextShowPenaltyPercentOfProduct.getText().toString();
                        accountPayableHeadOffice.setPenalty(penalty);
                        String userDepartment = editTextShowUserDepartment.getText().toString();
                        accountPayableHeadOffice.setUserDepartment(userDepartment);
                        String penaltyClause = editTextShowPenaltyClause.getText().toString();
                        accountPayableHeadOffice.setPenaltyClause(penaltyClause);
                        String surchargePerLitre = editTextShowSurchargePerLitre.getText().toString();
                        accountPayableHeadOffice.setSurchargePerLiter(surchargePerLitre);
                        String lumSum = editTextShowLumsum.getText().toString();
                        accountPayableHeadOffice.setLumSum(lumSum);
                        String total = editTextShowtotal.getText().toString();
                        accountPayableHeadOffice.setTotal(total);
                        String remarks = editTextShowRemarks.getText().toString();
                        accountPayableHeadOffice.setRemarks(remarks);

    //                    adapter_accountPayableHeadOffice.notifyDataSetChanged();

                        new DBHelper(context).UpdateAccountPayableHeadOffice(accountPayableHeadOffice);
                        ((MainActivity) context).setAccountPayableHeadOfficeRecycleView();

                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(context,"unable to update a user "+e.getMessage(),Toast.LENGTH_LONG).show();
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

            AccountPayableHeadOffice accountPayableHeadOffice = accountPayableHeadOfficeList.get(getAdapterPosition());
try {
    editTextShowUser.setText(accountPayableHeadOffice.getUser());
    editTextShowPenaltyPercentOfProduct.setText(accountPayableHeadOffice.getPenalty());
    editTextShowUserDepartment.setText(accountPayableHeadOffice.getUserDepartment());
    editTextShowPenaltyClause.setText(accountPayableHeadOffice.getPenaltyClause());
    editTextShowSurchargePerLitre.setText(accountPayableHeadOffice.getSurchargePerLiter());
    editTextShowLumsum.setText(accountPayableHeadOffice.getLumSum());
    editTextShowtotal.setText(accountPayableHeadOffice.getTotal());
    editTextShowRemarks.setText(accountPayableHeadOffice.getRemarks());

}catch (Exception e){
    Toast.makeText(context,"Adapter AccountPayableHeadOffice  " +e.getMessage(),Toast.LENGTH_LONG).show();
}
/*
            dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            */
            dialog.show();
        }

        private void removeAt(int id) {
            try{

              //  accountPayableHeadOfficeList.remove(position);
              //  notifyItemRemoved(position);
              //  notifyItemRangeChanged(position, accountPayableHeadOfficeList.size());
                new DBHelper(context).deleteAccPayHO(id);
                ((MainActivity) context).setAccountPayableHeadOfficeRecycleView();
            }catch (Exception e){
                Toast.makeText(context,"unable to deleting row "+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }


    }

}
