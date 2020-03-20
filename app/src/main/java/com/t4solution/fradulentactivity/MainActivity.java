package com.t4solution.fradulentactivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.t4solution.fradulentactivity.Adapter.Adapter_AccountPayableHeadOffice;
import com.t4solution.fradulentactivity.Adapter.Adapter_Chambers;
import com.t4solution.fradulentactivity.Adapter.Adapter_FraudulentActivity;
import com.t4solution.fradulentactivity.Adapter.Adapter_LogisticHeadOffice;
import com.t4solution.fradulentactivity.Adapter.Adapter_SystemDefine;
import com.t4solution.fradulentactivity.DB.DBHelper;
import com.t4solution.fradulentactivity.model.AccountPayableHeadOffice;
import com.t4solution.fradulentactivity.model.AddMoreReason;
import com.t4solution.fradulentactivity.model.Chambers;
import com.t4solution.fradulentactivity.model.FraudulentActivity;
import com.t4solution.fradulentactivity.model.LogisticHeadOffice;
import com.t4solution.fradulentactivity.model.SystemDefined;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    DBHelper dbHelper;
    List<SystemDefined> systemDefinedList=new ArrayList<>();
    List<FraudulentActivity> fraudulentActivityList=new ArrayList<>();
    List<Chambers> chambersList=new ArrayList<>();
    List<LogisticHeadOffice> logisticHeadOfficeList=new ArrayList<>();
    List<AccountPayableHeadOffice> accountPayableHeadOfficeList=new ArrayList<>();
    private ImageButton imageButtonforCollapse1,imageButtonforCollapse2,imageButtonforCollapse3,imageButtonforCollapse4;
    private int statusCollapseButton1=0,statusCollapseButton2=0,statusCollapseButton3=0,statusCollapseButton4=0;
    private LinearLayout layoutTobeCollapse1,layoutTobeCollapse2,layoutTobeCollapse3,layoutTobeCollapse4;
    EditText dateEditText;
    Dialog dialog;
    Adapter_AccountPayableHeadOffice adapter;
    EditText editTextSurchargePerLiter,editTextTotal,editTextLumsum,editTextPenaltyOfProduct,editTextRemarks;
    AlertDialog alertDialog;
    MaterialSpinner spinnerofReason,spinnerOfPenaltyClause,spinnerOfPenaltyCase;


    public void addMoreReason(View view){


      setAddMoreReasonDialogbox();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //     AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);


        clearData();

        saveFradulentActivityDummy();

        saveAccountPayableHeadOfficeDummy();

        saveSystemDefinedDummy();

        saveLogisticHeadOfficeDummy();

        setSystemDefinedRecycleView();

        setFraudulentActivityRecycleView();

        setChamberRecycleView();

        setLogisticHeadOfficeRecycleView();

        setAccountPayableHeadOfficeRecycleView();

// changes to remember last spinner position
        /*int spinnerPosition = 0;
        String strpos1 = prfs.getString("SPINNER1_VALUE", "");
        if (strpos1 != null || !strpos1.equals(null) || !strpos1.equals("")) {
            strpos1 = prfs.getString("SPINNER1_VALUE", "");
            spinnerPosition = adapter1.getPosition(strpos1);
            spinner1.setSelection(spinnerPosition);
            spinnerPosition = 0;
        }*/

        DatePickerDialog.OnDateSetListener ondate = new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                String displayDate = "";
                if(dayOfMonth < 10){
                    displayDate = "0"+dayOfMonth;
                }else{
                    displayDate = dayOfMonth+"";
                }

                if(monthOfYear < 9){
                    displayDate += "-0"+(monthOfYear+1);
                }else{
                    displayDate += "-"+(monthOfYear+1);
                }

                dateEditText.setText(displayDate + "-" + String.valueOf(year));

                /*
                dateEditText.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear + 1)
                        + "-" + String.valueOf(year));*/
            }
        };



    }

    public void showHideDetailButton(View view){

        int id=view.getId();

        switch (id){

            case R.id.imageButtonforCollapse1:
                layoutTobeCollapse1 =findViewById(R.id.layoutTobeCollapse);
                imageButtonforCollapse1 =findViewById(R.id.imageButtonforCollapse1);
                if(statusCollapseButton1 == 0){
                    statusCollapseButton1 = 1;
                    layoutTobeCollapse1.setVisibility(View.GONE);
                    imageButtonforCollapse1.setImageResource(R.drawable.ic_arrow_down);
                }else
                {
                    statusCollapseButton1 = 0;
                    layoutTobeCollapse1.setVisibility(View.VISIBLE);
                    imageButtonforCollapse1.setImageResource(R.drawable.ic_up_arrow);
                }

                break;

            case R.id.imageButtonforCollapse2:
                layoutTobeCollapse2 =findViewById(R.id.layoutTobeCollapse2);
                imageButtonforCollapse2 =findViewById(R.id.imageButtonforCollapse2);
                if(statusCollapseButton2 == 0){
                    statusCollapseButton2 = 1;
                    layoutTobeCollapse2.setVisibility(View.GONE);
                    imageButtonforCollapse2.setImageResource(R.drawable.ic_arrow_down);
                }else
                {
                    statusCollapseButton2 = 0;
                    layoutTobeCollapse2.setVisibility(View.VISIBLE);
                    imageButtonforCollapse2.setImageResource(R.drawable.ic_up_arrow);
                }

                break;

            case R.id.imageButtonforCollapse3:
                layoutTobeCollapse3 =findViewById(R.id.layoutTobeCollapse3);
                imageButtonforCollapse3 =findViewById(R.id.imageButtonforCollapse3);
                if(statusCollapseButton3 == 0){
                    statusCollapseButton3 = 1;
                    layoutTobeCollapse3.setVisibility(View.GONE);
                    imageButtonforCollapse3.setImageResource(R.drawable.ic_arrow_down);
                }else
                {
                    statusCollapseButton3 = 0;
                    layoutTobeCollapse3.setVisibility(View.VISIBLE);
                    imageButtonforCollapse3.setImageResource(R.drawable.ic_up_arrow);
                }

                break;

            case R.id.imageButtonforCollapse4:
                layoutTobeCollapse4 =findViewById(R.id.layoutTobeCollapse4);
                imageButtonforCollapse4 =findViewById(R.id.imageButtonforCollapse4);
                if(statusCollapseButton4 == 0){
                    statusCollapseButton4 = 1;
                    layoutTobeCollapse4.setVisibility(View.GONE);
                    imageButtonforCollapse4.setImageResource(R.drawable.ic_arrow_down);
                }else
                {
                    statusCollapseButton4 = 0;
                    layoutTobeCollapse4.setVisibility(View.VISIBLE);
                    imageButtonforCollapse4.setImageResource(R.drawable.ic_up_arrow);
                }
                break;
        }


    }

/*    private void initListeners() {
        showHideDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            }
        });
    }*/


    public void saveAddMoreReason(View view){

        AddMoreReason addMoreReason;
        List<AccountPayableHeadOffice> accountPayableHeadOfficeList=new ArrayList<>();
        try{
            AccountPayableHeadOffice accountPayableHeadOffice=new AccountPayableHeadOffice();
            addMoreReason=new AddMoreReason();

            /*String reason = spinnerofReason.getSelectedItem().toString();
            accountPayableHeadOffice.setReason(reason);
            String penaltyCase = spinnerOfPenaltyCase.getSelectedItem().toString();
            accountPayableHeadOffice.setPenaltyCaseNo(penaltyCase);
            String penaltyClause = spinnerOfPenaltyClause.getSelectedItem().toString();
            accountPayableHeadOffice.setPenaltyClause(penaltyClause);
            */
            String surchargePerLitre= editTextSurchargePerLiter.getText().toString();
            accountPayableHeadOffice.setSurchargePerLiter(surchargePerLitre);
            String total=editTextTotal.getText().toString();
            accountPayableHeadOffice.setTotal(total);
            String remarks=editTextRemarks.getText().toString();
            accountPayableHeadOffice.setRemarks(remarks);
            String penaltyOfProduct = editTextPenaltyOfProduct.getText().toString();
            accountPayableHeadOffice.setPenalty(penaltyOfProduct);
            addMoreReason.setPenaltyPercentOfProduct(penaltyOfProduct);
            String lumsum = editTextLumsum.getText().toString();
            accountPayableHeadOffice.setLumSum(lumsum);
            new DBHelper(this).insertAccountPayableHeadOfficeData(accountPayableHeadOffice);
            setAccountPayableHeadOfficeRecycleView();
            dialog.dismiss();


        }catch (Exception ex){
            ex.printStackTrace();
            Toast.makeText(MainActivity.this,"unable to add more reason"+ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void cancelAddMoreReason(View view){

        dialog.dismiss();
    }

    public void clearAddMoreReason(View view){

        editTextSurchargePerLiter.setText("");
        editTextLumsum.setText("");
        editTextPenaltyOfProduct.setText("");
        editTextTotal.setText("");
        editTextRemarks.setText("");

    }

    private void clearData() {

        try {
            dbHelper=new DBHelper(this);
            dbHelper.deleteRecordsDummy();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setAddMoreReasonDialogbox() {
//        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//        ViewGroup viewGroup=findViewById(android.R.id.content);
//        View inflate = LayoutInflater.from(this).inflate(R.layout.add_more_reason, viewGroup, false);



        dialog = new Dialog(MainActivity.this, android.R.style.Theme_Translucent);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add_more_reason);
        dialog.setCancelable(false);

        editTextSurchargePerLiter=dialog.findViewById(R.id.editTextSurchargePerLiter);
        editTextLumsum=dialog.findViewById(R.id.editTextLumsum);
        editTextPenaltyOfProduct=dialog.findViewById(R.id.editTextPenaltyPercentOfProduct);
        editTextRemarks=dialog.findViewById(R.id.editTextRemarks);
        editTextTotal=dialog.findViewById(R.id.editTextTotal);

        spinnerOfPenaltyClause=dialog.findViewById(R.id.spinnerOfPenaltyClasuse);
        spinnerOfPenaltyCase=dialog.findViewById(R.id.spinnerOfPenaltyCase);
        spinnerofReason=dialog.findViewById(R.id.spinnerOfReason);

       /* builder.setView(dialog);

        setSpinnerforReason(dialog);

        setSpinnerforpenaltyCase(dialog);

        setSpinnerforPenaltyClauseNo(dialog);

        alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

*/
       dialog.show();
    }

// ..........set Spinners..............

    private void setSpinnerforPenaltyClauseNo(View inflate) {
        Spinner spinner1= inflate.findViewById(R.id.spinnerOfPenaltyClasuse);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                MainActivity.this, R.array.ccy_array,
                R.layout.contact_spinner_row_nothing_selected);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
// Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);
    }

    private void setSpinnerforpenaltyCase(View inflate) {
        Spinner spinner1= inflate.findViewById(R.id.spinnerOfPenaltyCase);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                MainActivity.this, R.array.ccy_array,
                R.layout.contact_spinner_row_nothing_selected);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
// Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);
    }

    private void setSpinnerforReason(View inflate) {
        Spinner spinner1= inflate.findViewById(R.id.spinnerOfReason);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                MainActivity.this, R.array.ccy_array,
                R.layout.contact_spinner_row_nothing_selected);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
// Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);
    }

//  ..........set and save list of data from database in recyclerview.........Start

    private void saveAccountPayableHeadOfficeDummy() {
        try {
            List<AccountPayableHeadOffice> listAcPayHeadOffice = new ArrayList<AccountPayableHeadOffice>();
            AccountPayableHeadOffice accountPayableHeadOffice;
        for (int i = 0; i <= 3; i++) {
                accountPayableHeadOffice = new AccountPayableHeadOffice();
                accountPayableHeadOffice.setReason("Reason "+i);
                accountPayableHeadOffice.setPenaltyClause("Clause No " + i);
                accountPayableHeadOffice.setPenaltyCaseNo("Case" + i);
                accountPayableHeadOffice.setPenalty("20%");
                accountPayableHeadOffice.setSurchargePerLiter("Surcharge" + i);
                listAcPayHeadOffice.add(accountPayableHeadOffice);
                Log.i("list",accountPayableHeadOffice.toString());
                new DBHelper(this).insertAccountPayableHeadOfficeData(accountPayableHeadOffice);
            }
        }catch (Exception ex){
            Log.d("MainActivity","Error saveAccountPayableHeadOfficeDummy =" + ex.getMessage());

        }

    }

    public void setAccountPayableHeadOfficeRecycleView() {

        List<AccountPayableHeadOffice> listAcPayHeadOffice =  dbHelper.getAccountPayableHeadOfficeList();



        //accountPayableHeadOfficeList.add(new AccountPayableHeadOffice("Reason ABC","123A","234b","2000 Rs","20%",R.drawable.ic_deletebutton));
        //accountPayableHeadOfficeList.add(new AccountPayableHeadOffice("Reason ABC","123A","234b","2000 Rs","20%",R.drawable.ic_deletebutton));
        //accountPayableHeadOfficeList.add(new AccountPayableHeadOffice("Reason ABC","123A","234b","2000 Rs","20%",R.drawable.ic_deletebutton));

        RecyclerView recyclerViewAccountPayableHeadOffice = findViewById(R.id.recycleView_AccountPayable);
        recyclerViewAccountPayableHeadOffice.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter_AccountPayableHeadOffice(this,listAcPayHeadOffice);
        recyclerViewAccountPayableHeadOffice.setAdapter(adapter);
    }

    private void saveLogisticHeadOfficeDummy(){

    try{
        List<LogisticHeadOffice> logisticHeadOfficeList=new ArrayList<LogisticHeadOffice>();
        LogisticHeadOffice logisticHeadOffice;
        for (int i = 0; i <=3 ; i++) {
            logisticHeadOffice = new LogisticHeadOffice();
            logisticHeadOffice.setReason("Reason 123 "+i);
            logisticHeadOffice.setPenaltyClause("Clasue No "+i);
            logisticHeadOffice.setPenaltyCaseNo("Case no "+i);
            logisticHeadOffice.setSurchargePerLiter("123"+i);
            logisticHeadOffice.setPenalty("20%");

        logisticHeadOfficeList.add(logisticHeadOffice);

        new DBHelper(this).insertLogisticHeadOfficeData(logisticHeadOffice);

    }

}catch (Exception e){
e.printStackTrace();
        Toast.makeText(MainActivity.this,"MainActivity:Logistic  "+e.getMessage(),Toast.LENGTH_LONG).show();
}
    }

    private void setLogisticHeadOfficeRecycleView() {
       /* logisticHeadOfficeList.add(new LogisticHeadOffice("Reason ABC","123A","234b","2000 Rs","20%"));
        logisticHeadOfficeList.add(new LogisticHeadOffice("Reason ABC","123A","234b","2000 Rs","20%"));
        logisticHeadOfficeList.add(new LogisticHeadOffice("Reason ABC","123A","234b","2000 Rs","20%"));
*/
        List<LogisticHeadOffice> logisticHeadOfficeList = new DBHelper(this).getLogisticHeadOfficeList();
        RecyclerView recyclerViewLogisticHeadOffice = findViewById(R.id.recycleView_LogisticHeadOffice);
        recyclerViewLogisticHeadOffice.setLayoutManager(new LinearLayoutManager(this));
        Adapter_LogisticHeadOffice adapter = new Adapter_LogisticHeadOffice(this,logisticHeadOfficeList);
        recyclerViewLogisticHeadOffice.setAdapter(adapter);
    }

    private void setChamberRecycleView() {

        chambersList.add(new Chambers("Chamber 1"));
        chambersList.add(new Chambers("Chamber 2"));
        chambersList.add(new Chambers("Chamber 3"));
        chambersList.add(new Chambers("Chamber 4"));

        RecyclerView recyclerViewChamber = findViewById(R.id.recycleView_Chamber);
        recyclerViewChamber.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        Adapter_Chambers adapter = new Adapter_Chambers(this, chambersList);
        recyclerViewChamber.setAdapter(adapter);
    }

    private void saveFradulentActivityDummy(){

        try {
            List<FraudulentActivity> listFraudulentActivities = new ArrayList<FraudulentActivity>();
            FraudulentActivity fraudulentActivity;

            for (int i = 0; i <= 3; i++) {
                fraudulentActivity = new FraudulentActivity();
                fraudulentActivity.setInvolvementIn("InvolvementIN "+i);
                fraudulentActivity.setQuantity("000" + i);
                fraudulentActivity.setRemarks("XYZ 00" + i);
                fraudulentActivity.setAttachment(R.id.imageButton_Attachment);
                listFraudulentActivities.add(fraudulentActivity);

                new DBHelper(this).insertFradulentActivityData(fraudulentActivity);
            }
        }catch (Exception ex){
            Toast.makeText(MainActivity.this,"MainActivity:SystemDefined  "+ex.getMessage(),Toast.LENGTH_LONG).show();
            Log.d("MainActivity","Error fradulentActivityDummy =" + ex.getMessage());

        }
    }

    private void setFraudulentActivityRecycleView() {

        List<FraudulentActivity> fradulentActivityList = new DBHelper(this).getFradulentActivityList();

       /* fraudulentActivityList.add(new FraudulentActivity("ABC Reason","123","XYZ 123",R.drawable.ic_attachment));
        fraudulentActivityList.add(new FraudulentActivity("ABC Reason","123","XYZ 123",R.drawable.ic_attachment));
        fraudulentActivityList.add(new FraudulentActivity("ABC Reason","123","XYZ 123",R.drawable.ic_attachment));
*/

        RecyclerView recyclerViewFraudulentActivity = findViewById(R.id.recycleView_Fraudulent);
        recyclerViewFraudulentActivity.setLayoutManager(new LinearLayoutManager(this));
        Adapter_FraudulentActivity adapter = new Adapter_FraudulentActivity(this,fradulentActivityList);
        recyclerViewFraudulentActivity.setAdapter(adapter);
    }

    private void saveSystemDefinedDummy(){

        try {
            List<SystemDefined> systemDefinedList=new ArrayList<>();
            SystemDefined systemDefined;
            for (int i = 0; i <= 3; i++) {
                systemDefined = new SystemDefined();
                systemDefined.setReason("ABC "+i);
                systemDefined.setPenaltyClause("Clasue "+i);
                systemDefined.setPenaltyCaseNo("Case123 "+ i);
                systemDefined.setSurchargePerLiter("123 "+i);
                systemDefined.setPenalty("20%");
                systemDefinedList.add(systemDefined);
                new DBHelper(this).insertSystemDefinedData(systemDefined);
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this,"MainActivity:SystemDefined  "+e.getMessage(),Toast.LENGTH_LONG).show();
            Log.d("MainActivity","Error SystemDefinedDummy =" + e.getMessage());

        }

    }

    private void setSystemDefinedRecycleView() {

/*
        systemDefinedList.add(new SystemDefined("Reason ABC","123A","234b","2000 RS","20%"));
        systemDefinedList.add(new SystemDefined("Reason ABC","123A","234b","2000 RS","20%"));
        systemDefinedList.add(new SystemDefined("Reason ABC","123A","234b","2000 RS","20%"));
*/
        List<SystemDefined> systemDefinedList = new DBHelper(this).getSystemDefinedList();

        RecyclerView recyclerViewSystemDefined = findViewById(R.id.recycleView_SystemDefined);
        recyclerViewSystemDefined.setLayoutManager(new LinearLayoutManager(this));
        Adapter_SystemDefine adapter = new Adapter_SystemDefine(this, systemDefinedList);
        recyclerViewSystemDefined.setAdapter(adapter);
    }


    //  ..........set and save list of data from database in recyclerview.........End

  /*  private void showDatePicker() {
        DatePickerFragment date = new DatePickerFragment();
        *//**
         * Set Up Current Date Into dialog
         *//*
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        *//**
         * Set Call back to capture selected date
         *//*
        date.setCallBack(ondate);
        date.show(getFragmentManager(), "Date Picker");
    }
*/
}
