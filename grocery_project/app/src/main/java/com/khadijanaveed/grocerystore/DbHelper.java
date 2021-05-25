package com.khadijanaveed.grocerystore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.icu.lang.UScript;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper
{
    public static final String TBL_USERS = "users_tbl";
    public static final String USER_ID = "userId";
    public static final String USER_EMAIL = "email";
    public static final String USER_NAME= "userName";
    public static final String USER_PASWD = "password";
    public static final String USER_MobileNo = "mobileNo";
    public static final String USER_Type = "userType";

    public static final String TBL_PRODUCTS = "products_tbl";

    public static final String Prod_ID = "Id";
    public static final String Prod_Name = "Name";
    public static final String Prod_Category = "Category";
    public static final String Prod_Qty = "Quantity";
    public static final String Prod_Price = "Price";
    public static final String Prod_Img = "Image";


    private static final String dbname="groceryStoreDBNew.db";
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imageinbytes;
    //private static final int DATABASE_VERSION = 2;


    public DbHelper(Context context) {
        super(context, dbname, null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query_tbl1 ="CREATE TABLE " + TBL_USERS+ "(" + USER_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + USER_EMAIL + " Text," + USER_NAME+ " Text,"+ USER_PASWD+ " Text," + USER_MobileNo+ " Long,"+ USER_Type+" Text) ";
        db.execSQL(query_tbl1);

        String query_tbl2 ="CREATE TABLE " + TBL_PRODUCTS+ "(" + Prod_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + Prod_Name + " Text,"+ Prod_Category + " Text," + Prod_Qty+ " Real,"+ Prod_Price+ " Real," + Prod_Img+" BLOB) ";
        db.execSQL(query_tbl2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + TBL_USERS);
            db.execSQL("DROP TABLE IF EXISTS " + TBL_PRODUCTS);
            onCreate(db);
        }
    }

   //ADD new User to database SIGNUP
    public String addUser(UserModel user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(USER_EMAIL, user.getEmailID());
        cv.put(USER_NAME,user.getUserName());
        cv.put(USER_PASWD,user.getPaswd());
        cv.put(USER_MobileNo,user.getMobileNo());
        cv.put(USER_Type,user.getUserType());

        long result = db.insert(TBL_USERS,null,cv);
        db.close();
        if(result==-1)
            return "Signup Failed";
        else
            return "Signup Scuccesfull";
    }

    //Get COMPLETE record of a USER
    public UserModel getUser(String userName, String passwd)
    {
        UserModel user = null;
        String query = "SELECT * FROM " + TBL_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =db.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            do{
                String usrname= cursor.getString(2);
                String usrpaswd= cursor.getString(3);
                if(usrname.equals(userName) && usrpaswd.equals(passwd))
                {
                    int usrId =cursor.getInt(0);
                    String usremail= cursor.getString(1);
                    Long usrmobNo= cursor.getLong(4);
                    String usrType= cursor.getString(5);

                    user =new UserModel(usrId,usremail,usrname,usrpaswd,usrmobNo,usrType);

                    cursor.close();
                    db.close();
                    return user;
                }
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return user;
    }

    //Get username,email,mobile no of all users
    public ArrayList<UserModel> getAllRecords()
    {
        ArrayList<UserModel> myList= new ArrayList<UserModel>();

        String query = "SELECT "+USER_EMAIL+","+USER_NAME+","+USER_MobileNo+","+USER_Type+" FROM "+TBL_USERS;
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor = DB.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                String usrMail= cursor.getString(0);
                String userName= cursor.getString(1);
                int usrPhone= cursor.getInt(2);
                String userType= cursor.getString(3);

                if(userType.equals("Customer"))
                {
                    UserModel user = new UserModel(userName,usrMail,usrPhone);
                    myList.add(user);
                }
            }while(cursor.moveToNext());
        }

        cursor.close();
        DB.close();
        return myList;
    }
    // Add new product to database Admin's function
    public String addProduct(ProductModel productModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Bitmap image=productModel.getProduct_Image();
        byteArrayOutputStream = new ByteArrayOutputStream();
        image.compress( Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        imageinbytes = byteArrayOutputStream.toByteArray();

        ContentValues cv =new ContentValues();
        cv.put(Prod_Name,productModel.getProduct_Name());
        cv.put(Prod_Category,productModel.getProduct_Category());
        cv.put(Prod_Qty,productModel.getProduct_Qty());
        cv.put(Prod_Price,productModel.getProduct_Price());
        cv.put(Prod_Img,imageinbytes);

        long result = db.insert(TBL_PRODUCTS,null,cv);
        db.close();

        if(result==-1) { return "Product not added"; }
        else { return "product added"; }
    }

    //Delete Product by its name Admins Function
    public String deleteProduct(String prod_Name) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result=db.delete(TBL_PRODUCTS,"Name = ?",new String[] {prod_Name});
        db.close();
        if(result==0) { return "Product not Deleted"; }
        else { return "Product Deleted"; }
    }
}
