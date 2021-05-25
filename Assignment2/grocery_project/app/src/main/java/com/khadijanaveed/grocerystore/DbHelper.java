package com.khadijanaveed.grocerystore;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.lang.UScript;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper
{
    public static final String TBL_USERS = "tbl_users";
    public static final String USER_ID = "userId";
    public static final String USER_EMAIL = "email";
    public static final String USER_NAME= "userName";
    public static final String USER_PASWD = "password";
    public static final String USER_MobileNo = "mobileNo";
    private static final String dbname="groceryStoreDesc.db";
    //private static final int DATABASE_VERSION = 2;


    public DbHelper(Context context) {
        super(context, dbname, null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String query_tbl1 ="create table tbl_users (userId integer primary key autoincrement, email text,userName text, password text,mobileNo Long)";
        String query_tbl1 ="CREATE TABLE " + TBL_USERS+ "(" + USER_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + USER_EMAIL + " Text," + USER_NAME+ " Text,"+ USER_PASWD+ " Text," + USER_MobileNo+ " Long) ";
        //String query_tbl2 ="create table tbl_items (productId integer primary key autoincrement,productName text, productQty integer)";
        db.execSQL(query_tbl1);
        //db.execSQL(query_tbl2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS tbl_users");
        //onCreate(db);
    }
    public String addUser(UserModel user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USER_EMAIL, user.getEmailID());
        cv.put(USER_NAME,user.getUserName());
        cv.put(USER_PASWD,user.getPaswd());
        cv.put(USER_MobileNo,user.getMobileNo());

        long result = db.insert(TBL_USERS,null,cv);
        if(result==-1)
            return "Failed";
        else
            return "Scuccesfully inserted";
    }
}
