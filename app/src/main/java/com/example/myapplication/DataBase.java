package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DataBase extends SQLiteOpenHelper {
    public String createTables = "CREATE table Users(" +
            "Id INTEGER NOT NULL primary key autoincrement," +
            "email Varchar(255)," +
            "password Varchar(255)" +
            ")";
    public String DropTable = "DROP table Users";
    public DataBase(@Nullable Context context) {
        super(context,"db", null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTables);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i != i1){
            sqLiteDatabase.execSQL(DropTable);
            onCreate(sqLiteDatabase);
        }
    }
    public void Add(String email, String password){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT into Users ('email', 'password') VALUES(?, ?)", new
                Object[]{email, password});
    }
}

