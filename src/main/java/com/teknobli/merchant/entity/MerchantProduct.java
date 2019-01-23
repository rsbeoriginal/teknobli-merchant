package com.teknobli.merchant.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = MerchantProduct.TABLE_NAME)
public class MerchantProduct {

    public static final String TABLE_NAME = "MERCHANT_PRODUCT";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String merchantProductId;
    private String productId;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;
    private Double price;
    private int stock;

    public void setMerchantProductId(String merchantProductId) {
        this.merchantProductId = merchantProductId;
    }

    public String getMerchantProductId() {
        return merchantProductId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
