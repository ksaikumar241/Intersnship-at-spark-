package com.example.bank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String CID_COLUMN = "cid";
    public static final String TO_COLUMN = "to1";
    public static final String CUSTOMER_TABLE_NAME = "customer";
    public static final String NAME_COLUMN = "name";
    public static final String ACOOUNTNO_COLUMN = "accountno";
    public static final String BALANCE_COLUMN = "balance";
    public static final String  CID_SEX = "SEX";
    public static final String TID_COLUMN = "tid";
    public static final String FROM_COLUMN = "from1";
    public static final String DT_COLUMN = "dt";
    public static final String AMOUNT_COLUMN = "amount";
    public static final String TRANSFER_TABLE_NAME = "transfer";
    public static SQLiteDatabase dba;

    public DataBaseHelper(@Nullable Context context) {
        super(context, CUSTOMER_TABLE_NAME + "customer.db",null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String createTableStatement=
                    "CREATE TABLE IF NOT EXISTS " + CUSTOMER_TABLE_NAME + "(" + CID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME_COLUMN + " TEXT UNIQUE," + CID_SEX + " TEXT," + ACOOUNTNO_COLUMN + " TEXT UNIQUE," + BALANCE_COLUMN + " DOUBLE)";
            sqLiteDatabase.execSQL(createTableStatement);
            String transferTableStatement=
                    "CREATE TABLE IF NOT EXISTS " + TRANSFER_TABLE_NAME + "(" + FROM_COLUMN + " TEXT," + TO_COLUMN + " TEXT," + AMOUNT_COLUMN + " DOUBLE," + DT_COLUMN + " datetime default current_timestamp)";
            sqLiteDatabase.execSQL(transferTableStatement);
     //   String q="insert into transfer values(ACE18881229,ACE18881215,1000)";
      //  sqLiteDatabase.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addOne(Customer cus){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME_COLUMN,cus.getmCustomerName());
        cv.put(CID_SEX,cus.getmSex());
        cv.put(ACOOUNTNO_COLUMN,cus.getmAccountNumber());
        cv.put(BALANCE_COLUMN,cus.getmBalance());
        long insert=db.insert(CUSTOMER_TABLE_NAME,null,cv);
        if(insert==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public List<Customer> selectAll(){
        ArrayList<Customer> arr=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM "+CUSTOMER_TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int cid=cursor.getInt(0);
                String name=cursor.getString(1);
                String sex=cursor.getString(2);
                String accno=cursor.getString(3);
                double balance=cursor.getDouble(4);
                Customer cust=new Customer(cid,name,sex,accno,balance);
                arr.add(cust);
            }while(cursor.moveToNext());
        }
        return arr;
    }

    public String TransferMoney(String from2,String to2,double amo){
            Log.i("inside Transfer Money","inside.........");
       // Log.i("dba object",dba.toString());
       SQLiteDatabase db=this.getWritableDatabase();
        String q="insert into transfer values(ACE18881229,ACE18881215,1000)";

        //SQLiteDatabase db= dba;
          String quer="SELECT * FROM "+CUSTOMER_TABLE_NAME+" WHERE "+ACOOUNTNO_COLUMN+" = '"+from2+"' and "+BALANCE_COLUMN+" >= "+amo;

          Cursor cursor=db.rawQuery(quer,null);
          ContentValues cv;
            cv=new ContentValues();
          if(cursor!=null && cursor.getCount()==0){
              long insert=db.insert(TRANSFER_TABLE_NAME,null,cv);
              return "Balance insuffient";
          }
          else{
              quer="SELECT * FROM "+CUSTOMER_TABLE_NAME+" WHERE "+ACOOUNTNO_COLUMN+"= '"+to2+"'";
              cursor=db.rawQuery(quer,null);

              if(cursor.getCount()>0){
                  db.execSQL("UPDATE "+CUSTOMER_TABLE_NAME+" SET "+BALANCE_COLUMN+"="+BALANCE_COLUMN+"+"+amo+" WHERE "+ACOOUNTNO_COLUMN+"='"+to2+"'");
                  db.execSQL("UPDATE "+CUSTOMER_TABLE_NAME+" SET "+BALANCE_COLUMN+"="+BALANCE_COLUMN+"-"+amo+" WHERE "+ACOOUNTNO_COLUMN+"='"+from2+"'");

                  cv.put(FROM_COLUMN,from2);
                  cv.put(TO_COLUMN,to2);
                  cv.put(AMOUNT_COLUMN,amo);
                  long insert=db.insert(TRANSFER_TABLE_NAME,null,cv);
                  if(insert>0){
                      return "success Transaction";
                  }
                  else{
                      return "Fail";
                  }
              }
              else{
                  long insert=db.insert(TRANSFER_TABLE_NAME,null,cv);
                  return "Enter Proper TO A/C no";
              }
          }
//          return "NON";
    }

    public List<Transaction> transelectAll(){
        ArrayList<Transaction> arr=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM "+TRANSFER_TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{

                String from=cursor.getString(0);
                String to=cursor.getString(1);
                double rupee=cursor.getDouble(2);
                Transaction tran=new Transaction(from,to,rupee);
                arr.add(tran);
            }while(cursor.moveToNext());
        }
        return arr;
    }





}
