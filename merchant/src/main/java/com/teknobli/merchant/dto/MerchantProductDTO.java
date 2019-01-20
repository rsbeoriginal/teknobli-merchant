package com.teknobli.merchant.dto;

import com.teknobli.merchant.entity.Merchant;

public class MerchantProductDTO {
    private String merchantProductId;
    private String productId;
    private Merchant merchant;
    private int price;
    private int stock;

    public void setMerchantProductId(String merchantProductId){
        this.merchantProductId = merchantProductId;
    }

    public String getMerchantProductId(){
        return merchantProductId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public String getProductId(){
        return productId;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
