package com.nanoboost.nanopay;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "NanoPay.db";
    public static final String TABLE_NAME = "Product_Details";
    public static final String COL_1 = "Order_No";
    public static final String COL_2 = "Product_Name";
    public static final String COL_3 = "Date_of_Purchase";
    public static final String COL_4 = "Warranty_Period";
    public static final String COL_5 = "STATUS";
    public static final String COL_6 = "Price";
    public static final String COL_7 = "Deal_Name";
    public static final String COL_8 = "Image Name";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (Order_No INTEGER, Product_Name TEXT," +
                "Date_of_Purchase TEXT, Warranty_Period TEXT, STATUS INTEGER, Price LONG, DEAL_NAME TEXT, IMAGE_NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(int number, String name, String Date, String Warranty, int stat, double price, String seller) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,number);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,Date);
        contentValues.put(COL_4,Warranty);
        contentValues.put(COL_5, stat);
        contentValues.put(COL_6, price);
        contentValues.put(COL_7, seller);

        long result = db.insert(TABLE_NAME,null, contentValues);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
