package com.khadijanaveed.grocerystore;

import android.graphics.Bitmap;

public class ProductModel {
    private int Product_ID;
    private String Product_Name;
    private String Product_Category;
    private Double Product_Qty;
    private Double Product_Price;
    private Bitmap Product_Image;


    public ProductModel(int product_ID, String product_Name, String product_Category, Double product_Qty, Double product_Price, Bitmap product_Image) {
        Product_ID = product_ID;
        Product_Name = product_Name;
        Product_Category = product_Category;
        Product_Qty = product_Qty;
        Product_Price = product_Price;
        Product_Image = product_Image;
    }
    public ProductModel(String product_Name, String product_Category, Double product_Qty, Double product_Price, Bitmap product_Image) {
        Product_Name = product_Name;
        Product_Category = product_Category;
        Product_Qty = product_Qty;
        Product_Price = product_Price;
        Product_Image = product_Image;
    }

    public ProductModel(int product_ID,String product_Name, Double product_Price, Bitmap product_Image) {
        Product_ID = product_ID;
        Product_Name = product_Name;
        Product_Price = product_Price;
        Product_Image = product_Image;
    }

    public String getProduct_Category() {
        return Product_Category;
    }

    public void setProduct_Category(String product_Category) {
        Product_Category = product_Category;
    }

    public int getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(int product_ID) {
        Product_ID = product_ID;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public Double getProduct_Qty() {
        return Product_Qty;
    }

    public void setProduct_Qty(Double product_Qty) {
        Product_Qty = product_Qty;
    }

    public Double getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Price(Double product_Price) {
        Product_Price = product_Price;
    }

    public Bitmap getProduct_Image() {
        return Product_Image;
    }

    public void setProduct_Image(Bitmap product_Image) {
        Product_Image = product_Image;
    }
}
