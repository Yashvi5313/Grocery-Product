package com.example.edekaproduct;

public class ShoppingItem {
    private String product_name = "";
    private int product_img;
    private String product_type = "";
    private float product_price;
    private boolean product_like;
    private boolean product_add;
    private int NumberOfProduct;

    public ShoppingItem(String product_name, int product_img, String product_type, float product_price, Boolean product_like, Boolean product_add, int NumberOfProduct, int numberofPrice) {

        this.product_name = product_name;
        this.product_img = product_img;
        this.product_type = product_type;
        this.product_price = product_price;
        this.product_like = product_like;
        this.product_add = product_add;
        this.NumberOfProduct = NumberOfProduct;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_img() {
        return product_img;
    }

    public String getProduct_type() {
        return product_type;
    }

    public float getProduct_price() {
        return product_price;
    }

    public boolean getProduct_like() {
        return product_like;
    }

    public void setProduct_like(boolean product_like) {
        this.product_like = product_like;
    }

    public boolean getProduct_add() {
        return product_add;
    }

    public void setProduct_add(boolean product_add) {
        this.product_add = product_add;
    }

    public int getNumberOfProduct() {
        return NumberOfProduct;
    }

    public void addToNumber() {
        this.NumberOfProduct += 1;
    }

    public void removeFromNumber() {
        if (this.NumberOfProduct >= 1) {
            this.NumberOfProduct -= 1;
        }
    }
}
