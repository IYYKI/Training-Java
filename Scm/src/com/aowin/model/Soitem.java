package com.aowin.model;

public class Soitem {
    int soid;
    String productCode;
    float unitPrice;
    int num;
    String unitName;
    float itemPrice;

    public Soitem() {

    }

    public Soitem(int soid, String productCode, float unitPrice, int num,
                  String unitName, float itemPrice) {
        this.soid = soid;
        this.productCode = productCode;
        this.unitPrice = unitPrice;
        this.num = num;
        this.unitName = unitName;
        this.itemPrice = itemPrice;
    }

    public int getSoid() {
        return soid;
    }

    public void setSoid(int soid) {
        this.soid = soid;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

}
