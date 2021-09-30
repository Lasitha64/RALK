package com.example.ralk.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "RALK.db";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE "+Products.product.TABLE_NAME+
                " ("+Products.product._ID+" INTEGER PRIMARY KEY,"+
                Products.product.COLUMN_NAME_PRODUCTNAME+" TEXT,"+
                Products.product.COLUMN_NAME_DESCRIPTION+" TEXT,"+
                Products.product.COLUMN_NAME_QUANTITY+" INTEGER,"+
                Products.product.COLUMN_NAME_PRICE+" REAL,"+
                Products.product.COLUMN_NAME_IMAGE+" BLOB)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public Long addProductShop(String name, String desc, int qty, double price, byte[] img ){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values  = new ContentValues();
        values.put(Products.product.COLUMN_NAME_PRODUCTNAME,name);
        values.put(Products.product.COLUMN_NAME_DESCRIPTION,desc);
        values.put(Products.product.COLUMN_NAME_QUANTITY,qty);
        values.put(Products.product.COLUMN_NAME_PRICE,price);
        values.put(Products.product.COLUMN_NAME_IMAGE,img);

        return db.insert(Products.product.TABLE_NAME,null, values);
    }


    //di
    public List readProduct(int id){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Products.product._ID,
                Products.product.COLUMN_NAME_PRODUCTNAME,
                Products.product.COLUMN_NAME_DESCRIPTION,
                Products.product.COLUMN_NAME_QUANTITY,
                Products.product.COLUMN_NAME_PRICE,
                Products.product.COLUMN_NAME_IMAGE,
        };
        String selection = Products.product._ID+" LIKE ?";
        String[] selectionArgs = {String.valueOf(id)};

        //query
        Cursor cursor = db.query(
                Products.product.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        List products = new ArrayList<>();

//        while(cursor.moveToNext()){
//            String product = cursor.getString(cursor.getColumnIndexOrThrow(Products.product.COLUMN_NAME_PRODUCTNAME));
//            products.add(product);
//        }
//

        //problem
        if (cursor.moveToFirst()) {
            do {
                products.add(cursor.getString(0));

            } while (cursor.moveToNext());
        }

        cursor.close();

        return products;

    }



    //update part
    public void updateProduct(int id, String name, String desc, int qty, double price){

        SQLiteDatabase db = getReadableDatabase();
        ContentValues cv = new ContentValues();

        //values passing to the table
        cv.put(Products.product.COLUMN_NAME_PRODUCTNAME,name);
        cv.put(Products.product.COLUMN_NAME_DESCRIPTION,desc);
        cv.put(Products.product.COLUMN_NAME_QUANTITY,qty);
        cv.put(Products.product.COLUMN_NAME_PRICE,price);

        String selection = Products.product._ID+" LIKE ?";
        String[] selectionArgs = {String.valueOf(id)};
        int count = db.update(
                Products.product.TABLE_NAME, cv, selection, selectionArgs);
    }


    //ddelete part
    public void deleteProduct(int id){

        SQLiteDatabase db = getReadableDatabase();
        String selection = Products.product._ID+" LIKE ?";
        String[] selectionArgs = {String.valueOf(id)};
        db.delete(Products.product.TABLE_NAME,selection,selectionArgs);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

