package com.example.e_commerce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public static  final String DBNAME="login.db";
    public DBhelper( Context context) {
        super(context,"login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //code for create table users
        db.execSQL("create table users(username TEXT primary key,password TEXT,Gmail id)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }

    public boolean insertData(String username,String password,String gmail)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("username",username);
        values.put("password",password);
        values.put("gmail",gmail);
        long result=db.insert("users",null,values);
        if(result ==-1)
        {
            return false;
        }else
        {
            return  true;
        }
    }

    //check username function
    public boolean checkusername(String username)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from users where username=?",new String[]{username});

        if(cursor.getCount() >0)
        {
            return true;
        }
        else
        {
            return  false;
        }
    }
    //check username password function
    public boolean checkusernamegmail(String username,String gmail)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from users where username=? and gmail=?",new String[]{username,gmail});

        if(cursor.getCount() >0)
        {
            return true;
        }
        else
        {
            return  false;
        }
    }
    //check user email
    public boolean checkusernamegmailpassword(String username,String gmail,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from users where username=? and password=? and gmail=?",new String[]{username,password,gmail});

        if(cursor.getCount() >0)
        {
            return true;
        }
        else
        {
            return  false;
        }
    }

}
