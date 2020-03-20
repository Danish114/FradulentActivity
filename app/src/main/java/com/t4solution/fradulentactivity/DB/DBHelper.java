package com.t4solution.fradulentactivity.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.t4solution.fradulentactivity.model.AccountPayableHeadOffice;
import com.t4solution.fradulentactivity.model.FraudulentActivity;
import com.t4solution.fradulentactivity.model.LogisticHeadOffice;
import com.t4solution.fradulentactivity.model.SystemDefined;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private String TAG = "DB";
    public static final String DATABASE_NAME = "APL.db";
    public static final int DATABASE_VERSION = 1;
    private Context mContext;
    public SQLiteDatabase Database;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext=context;
        SQLiteDatabase db=this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    /*    db.execSQL(
                "CREATE TABLE IF NOT EXISTS  `Table_AddMoreReason` (\n" +
                        "  `id` Integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `Reason` Text(200) DEFAULT NULL,\n" +
                        "  `PenaltyClause` Text(50) DEFAULT NULL,\n" +
                        "  `PenaltyCaseNo` Text(20) DEFAULT NULL,\n" +
                        "  `SurchargePerLiter` Text(20) DEFAULT NULL,\n" +
                        "  `PenaltyPercentOfProduct` Text(20) DEFAULT NULL,\n" +
                        "  `Lumsum` Text(200) DEFAULT NULL,\n" +
                        "  `Total` Text(100) DEFAULT NULL,\n" +
                        "  `Remarks` Text(200) DEFAULT NULL\n" +
                        ") ;"
    );*/

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS  `Fradulent_Activity_Table` (\n" +
                        "  `id` Integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `InvolvementIn` Text(200) DEFAULT NULL,\n" +
                        "  `Quantity` Text(50) DEFAULT NULL,\n" +
                        "  `Remarks` Text(200) DEFAULT NULL\n" +
                        ") ;"
        );

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS  `AccountPayableHeadOffice_Table` (\n" +
                        "  `id` Integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `Reason` Text(200) DEFAULT NULL,\n" +
                        "  `PenaltyClause` Text(50) DEFAULT NULL,\n" +
                        "  `PenaltyCaseNo` Text(20) DEFAULT NULL,\n" +
                        "  `SurchargePerLiter` Text(20) DEFAULT NULL,\n" +
                        "  `Penalty` Text(20) DEFAULT NULL\n" +
                        ") ;"
        );

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS  `LogisticHeadOffice_Table` (\n" +
                        "  `id` Integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `Reason` Text(20) DEFAULT NULL,\n" +
                        "  `PenaltyClasuse` Text(50) DEFAULT NULL,\n" +
                        "  `PenaltyCaseNo` Text(20) DEFAULT NULL,\n" +
                        "  `SurchargePerLiter` Text(20) DEFAULT NULL,\n" +
                        "  `Penalty` Text(20) DEFAULT NULL\n" +
                        ") ;"
        );

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS  `SystemDefined_Table` (\n" +
                        "  `id` Integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `Reason` Text(200) DEFAULT NULL,\n" +
                        "  `PenaltyClasuse` Text(50) DEFAULT NULL,\n" +
                        "  `PenaltyCaseNo` Text(20) DEFAULT NULL,\n" +
                        "  `SurchargePerLiter` Text(20) DEFAULT NULL,\n" +
                        "  `Penalty` Text(20) DEFAULT NULL\n" +
                        ") ;"
        );



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)  {

        onCreate(db);

    }
    public void deleteAccPayHO(int id) {
        SQLiteDatabase db=getReadableDatabase();

        try {

            db.delete("AccountPayableHeadOffice_Table","id="+id,null);

//            del=db.delete("AccountPayableHeadOffice_Table","id='"+id+"'",null)>0;
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(mContext,"unable to delete row "+ e.getMessage(),Toast.LENGTH_LONG).show();
        }finally {
            db.close();
        }
//        db.execSQL("delete from AccountPayableHeadOffice_Table where id='"+id+"'");
    }

   /* public Long insetAddMoreReason(AddMoreReason addMoreReason){
        Long idInsert =-1L;
        SQLiteDatabase db=this.getReadableDatabase();

        try{
            ContentValues contentValues=new ContentValues();
            contentValues.put("Reason",addMoreReason.getReason());
            contentValues.put("PenaltyClause",addMoreReason.getPenaltyClause());
            contentValues.put("PenaltyCaseNo",addMoreReason.getPenaltyCase());
            contentValues.put("SurchargePerLiter",addMoreReason.getSurchargePerLiter());
            contentValues.put("PenaltyPercentOfProduct",addMoreReason.getPenaltyPercentOfProduct());
            contentValues.put("Lumsum",addMoreReason.getLumsum());
            contentValues.put("Total",addMoreReason.getTotal());
            contentValues.put("Remarks",addMoreReason.getRemarks());

            idInsert=db.insert("Table_AddMoreReason",null,contentValues);

        }catch (SQLException e){
            e.printStackTrace();
            Toast.makeText(mContext,"DBHelper:insertAccountPayableHeadOfficeData "+ e.getMessage(),Toast.LENGTH_LONG ).show();

        }finally {
            if (db!=null){

                db.close();
            }
        }
        return idInsert;
    }

    public List<AddMoreReason> getAddMoreReason(){
        Cursor res=null;
        List<AddMoreReason> addMoreReasonList=null;
        SQLiteDatabase db=null;
        try{
            addMoreReasonList=new ArrayList<AddMoreReason>();
            db=getReadableDatabase();
            res=db.rawQuery("select * from Table_AddMoreReason ",null);
            res.moveToFirst();
            while (res.isAfterLast()==false){

                AddMoreReason addMoreReason=new AddMoreReason();
                addMoreReason.setId(res.getInt(res.getColumnIndex("id")));
                addMoreReason.setReason(res.getString(res.getColumnIndex("Reason")));
                addMoreReason.setPenaltyClause(res.getString(res.getColumnIndex("PenaltyClause")));
                addMoreReason.setPenaltyCase(res.getString(res.getColumnIndex("PenaltyCaseNo")));
                addMoreReason.setPenaltyPercentOfProduct(res.getString(res.getColumnIndex("PenaltyPercentOfProduct")));
                addMoreReason.setSurchargePerLiter(res.getString(res.getColumnIndex("SurchargePerLiter")));
                addMoreReason.setLumsum(res.getString(res.getColumnIndex("Lumsum")));
                addMoreReason.setTotal(res.getString(res.getColumnIndex("Total")));
                addMoreReason.setRemarks(res.getString(res.getColumnIndex("Remarks")));

                addMoreReasonList.add(addMoreReason);
                res.moveToNext();
            }
        }catch (Exception ex){

            ex.printStackTrace();
            Toast.makeText(mContext,"DBHelper:unable to get list of add more reason "
                    + ex.getMessage(),Toast.LENGTH_LONG ).show();

        }finally {
            if (db != null)
                db.close();
        }
        return addMoreReasonList;
    }*/

    public Long insertAccountPayableHeadOfficeData(AccountPayableHeadOffice accountPayableHeadOffice){
        Long idInsert = -1L;
        SQLiteDatabase db=this.getReadableDatabase();

        try{
            ContentValues contentValues=new ContentValues();
            contentValues.put("Reason",accountPayableHeadOffice.getReason());
            contentValues.put("PenaltyClause",accountPayableHeadOffice.getPenaltyClause());
            contentValues.put("PenaltyCaseNo",accountPayableHeadOffice.getPenaltyCaseNo());
            contentValues.put("SurchargePerLiter",accountPayableHeadOffice.getSurchargePerLiter());
            contentValues.put("Penalty",accountPayableHeadOffice.getPenalty());
            idInsert=db.insert("AccountPayableHeadOffice_Table",null,contentValues);

        }catch (SQLException e){
            e.printStackTrace();
            Toast.makeText(mContext,"DBHelper:insertAccountPayableHeadOfficeData = Unable to save records "
                    + accountPayableHeadOffice.getPenaltyCaseNo().toString(),Toast.LENGTH_LONG ).show();

        }finally {
            if (db!=null)
                db.close();
        }
        return idInsert;
    }

    public boolean  UpdateAccountPayableHeadOffice(AccountPayableHeadOffice accountPayableHeadOffice) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues;
        Boolean res=false;
        try {
            contentValues=new ContentValues();
            contentValues.put("Reason",accountPayableHeadOffice.getReason());
            contentValues.put("PenaltyClause",accountPayableHeadOffice.getPenaltyClause());
            contentValues.put("PenaltyCaseNo",accountPayableHeadOffice.getPenaltyCaseNo());
            contentValues.put("SurchargePerLiter",accountPayableHeadOffice.getSurchargePerLiter());
            contentValues.put("Penalty",accountPayableHeadOffice.getPenalty());


            res= db.update("AccountPayableHeadOffice_Table", contentValues, "id='" + accountPayableHeadOffice.getId()+"'", null) > 0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } finally {

            db.close();
        }

        return res;
    }

    public List<AccountPayableHeadOffice> getAccountPayableHeadOfficeList() {

        Cursor res=null;
        List<AccountPayableHeadOffice> list=null;
        SQLiteDatabase db=null;

        try{
            list=new ArrayList<AccountPayableHeadOffice>();
            db=getReadableDatabase();

            res = db.rawQuery("select * from AccountPayableHeadOffice_Table ",null);
            res.moveToFirst();
            while (res.isAfterLast()==false){
                AccountPayableHeadOffice accountPayableHeadOffice=new AccountPayableHeadOffice();
                accountPayableHeadOffice.setId(res.getInt(res.getColumnIndex("id")));
                accountPayableHeadOffice.setReason(res.getString(res.getColumnIndex("Reason")));
                accountPayableHeadOffice.setPenaltyClause(res.getString(res.getColumnIndex("PenaltyClause")));
                accountPayableHeadOffice.setPenaltyCaseNo(res.getString(res.getColumnIndex("PenaltyCaseNo")));
                accountPayableHeadOffice.setPenalty(res.getString(res.getColumnIndex("Penalty")));
                accountPayableHeadOffice.setSurchargePerLiter(res.getString(res.getColumnIndex("SurchargePerLiter")));

                list.add(accountPayableHeadOffice);
                res.moveToNext();

            }

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(mContext,"DBHelper:return AcountPayableHeadOfficeData "
                    +e.getMessage(),Toast.LENGTH_LONG ).show();

        } finally {
            if (db != null)
                db.close();
        }
        return list;
    }


    public Long insertLogisticHeadOfficeData(LogisticHeadOffice logisticHeadOffice){
        Long idInsert = -1L;
        SQLiteDatabase db=this.getReadableDatabase();

        try{
            ContentValues contentValues=new ContentValues();
            contentValues.put("Reason",logisticHeadOffice.getReason());
            contentValues.put("PenaltyClasuse",logisticHeadOffice.getPenaltyClause());
            contentValues.put("PenaltyCaseNo",logisticHeadOffice.getPenaltyCaseNo());
            contentValues.put("SurchargePerLiter",logisticHeadOffice.getSurchargePerLiter());
            contentValues.put("Penalty",logisticHeadOffice.getPenalty());
            idInsert=db.insert("LogisticHeadOffice_Table",null,contentValues);

        }catch (SQLException e){
            e.printStackTrace();
            Toast.makeText(mContext,"DBHelper:insertLogisticHeadOfficeData  "
                    + e.getMessage(),Toast.LENGTH_LONG ).show();

        }finally {
            if (db!=null)
                db.close();
        }
        return idInsert;
    }

    public List<LogisticHeadOffice> getLogisticHeadOfficeList(){

        Cursor res=null;
        List<LogisticHeadOffice> list=null;
        SQLiteDatabase db=null;

        try{
            list=new ArrayList<LogisticHeadOffice>();
            db=getReadableDatabase();

            res=db.rawQuery("select * from LogisticHeadOffice_Table ",null);
            res.moveToFirst();
            while (res.isAfterLast()==false){
                LogisticHeadOffice logisticHeadOffice=new LogisticHeadOffice();
                logisticHeadOffice.setId(res.getInt(res.getColumnIndex("id")));
                logisticHeadOffice.setReason(res.getString(res.getColumnIndex("Reason")));
                logisticHeadOffice.setPenaltyClause(res.getString(res.getColumnIndex("PenaltyClasuse")));
                logisticHeadOffice.setPenaltyCaseNo(res.getString(res.getColumnIndex("PenaltyCaseNo")));
                logisticHeadOffice.setPenalty(res.getString(res.getColumnIndex("Penalty")));
                logisticHeadOffice.setSurchargePerLiter(res.getString(res.getColumnIndex("SurchargePerLiter")));

                list.add(logisticHeadOffice);
                res.moveToNext();

            }

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(mContext,"DBHelper:getAccountPayableHeadOfficeData  "
                    + e.getMessage(),Toast.LENGTH_LONG ).show();

        } finally {
            if (db != null)
                db.close();
        }
        return list;
    }

    public Long insertSystemDefinedData(SystemDefined systemDefined){
        Long idInsert = -1L;
        SQLiteDatabase db=this.getReadableDatabase();

        try{
            ContentValues contentValues=new ContentValues();
            contentValues.put("Reason",systemDefined.getReason());
            contentValues.put("PenaltyClasuse",systemDefined.getPenaltyClause());
            contentValues.put("PenaltyCaseNo",systemDefined.getPenaltyCaseNo());
            contentValues.put("SurchargePerLiter",systemDefined.getSurchargePerLiter());
            contentValues.put("Penalty",systemDefined.getPenalty());

            idInsert=db.insert("SystemDefined_Table",null,contentValues);
        }catch (SQLException e){
            e.printStackTrace();
            Toast.makeText(mContext,"DBHelper:insertSystemDefinedData   "
                    + e.getMessage(),Toast.LENGTH_LONG ).show();

        }finally {
            if (db!=null)
                db.close();
        }
        return idInsert;
    }

    public List<SystemDefined> getSystemDefinedList(){

        Cursor res=null;
        List<SystemDefined> list=null;
        SQLiteDatabase db=null;

        try{
            list=new ArrayList<SystemDefined>();
            db=getReadableDatabase();

            res=db.rawQuery("select * from SystemDefined_Table ",null);
            res.moveToFirst();
            while (res.isAfterLast()==false){
                SystemDefined systemDefined=new SystemDefined();
                systemDefined.setId(res.getInt(res.getColumnIndex("id")));
                systemDefined.setReason(res.getString(res.getColumnIndex("Reason")));
                systemDefined.setPenaltyClause(res.getString(res.getColumnIndex("PenaltyClasuse")));
                systemDefined.setPenaltyCaseNo(res.getString(res.getColumnIndex("PenaltyCaseNo")));
                systemDefined.setPenalty(res.getString(res.getColumnIndex("Penalty")));
                systemDefined.setSurchargePerLiter(res.getString(res.getColumnIndex("SurchargePerLiter")));

                list.add(systemDefined);
                res.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(mContext,"DBHelper:getSystemDefinedData  "
                    + e.getMessage(),Toast.LENGTH_LONG ).show();

        } finally {
            if (db != null)
                db.close();
        }
        return list;
    }

    public Long insertFradulentActivityData(FraudulentActivity fraudulentActivity) {
        Long idInsert = -1L;


        SQLiteDatabase db = this.getReadableDatabase();
        try {

            ContentValues contentValues = new ContentValues();
            contentValues.put("InvolvementIn",fraudulentActivity.getInvolvementIn());
            contentValues.put("Quantity", fraudulentActivity.getQuantity());
            contentValues.put("Remarks", fraudulentActivity.getRemarks());

            idInsert = db.insert("Fradulent_Activity_Table", null, contentValues);

        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(mContext,"DBHelper:insertFradulentActivityData "
                    + e.getMessage(),Toast.LENGTH_SHORT ).show();

        } finally {
            if (db != null)
                db.close();
        }

        return idInsert;
    }

    public List<FraudulentActivity> getFradulentActivityList(){

        Cursor res=null;
        List<FraudulentActivity> list=null;
        SQLiteDatabase db=null;

        try{
            list=new ArrayList<FraudulentActivity>();
            db=getReadableDatabase();

            res=db.rawQuery("select * from Fradulent_Activity_Table ",null);
            res.moveToFirst();
            while (res.isAfterLast()==false){
                FraudulentActivity fraudulentActivity=new FraudulentActivity();
                fraudulentActivity.setId(res.getInt(res.getColumnIndex("id")));
                fraudulentActivity.setInvolvementIn(res.getString(res.getColumnIndex("InvolvementIn")));
                fraudulentActivity.setQuantity(res.getString(res.getColumnIndex("Quantity")));
                fraudulentActivity.setRemarks(res.getString(res.getColumnIndex("Remarks")));

                list.add(fraudulentActivity);
                res.moveToNext();

            }


        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(mContext,"DBHelper:getFradulentActivity list "
                    + e.getMessage(),Toast.LENGTH_SHORT ).show();

        } finally {
            if (db != null)
                db.close();
        }
    return list;
}

    public void deleteRecordsDummy() {
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String deleteQuery = "DELETE FROM AccountPayableHeadOffice_Table";
            db.execSQL(deleteQuery);
            String deleteQuerySystem = "DELETE FROM SystemDefined_Table";
            db.execSQL(deleteQuerySystem);
            String deleteQueryLogistic = "DELETE FROM LogisticHeadOffice_Table";
            db.execSQL(deleteQueryLogistic);
            String deleteQueryFradulent = "DELETE FROM Fradulent_Activity_Table";
            db.execSQL(deleteQueryFradulent);


        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(mContext,"DBHelper:deleteRecords  "
                    + e.getMessage(),Toast.LENGTH_LONG ).show();

        } finally {
            if (db != null)
                db.close();
        }

    }


        }
