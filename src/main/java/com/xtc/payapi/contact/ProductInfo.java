package com.xtc.payapi.contact;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class ProductInfo {
    private int number;
    private BigDecimal price;
    private String productId;
    private String productName;

    public int getNumber() {
        return this.number;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setNumber(int i2) {
        this.number = i2;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public String toString() {
        return "ProductInfo{productId='" + this.productId + "', productName='" + this.productName + "', price='" + this.price + "', number=" + this.number + '}';
    }
}
