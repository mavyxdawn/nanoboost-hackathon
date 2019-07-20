package com.nanoboost.nanopay;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "NanoPay.db";
    public static final String TABLE_NAME = "Product_Details";
    public static final String COL_1 = "Product_Name";
    public static final String COL_2 = "Order_No.";
    public static final String COL_3 = "Date_of_Purchase";
    public static final String COL_4 = "Warranty_Period";
    public static final String COL_5 = "Confirmed?";
    public static final String COL_6 = "For Return?";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (Order_No INTEGER, Product_Name TEXT," +
                "Date_of_Purchase DATE, Warranty_Period TEXT, STATUS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
}
