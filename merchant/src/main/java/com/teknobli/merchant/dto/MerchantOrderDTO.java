package com.teknobli.merchant.dto;


public class MerchantOrderDTO {

    private String merchantProductId;
    private String productId;
    private String merchantId;
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

    public void setMerchantId(String merchantId){
        this.merchantId = merchantId;
    }

    public String getMerchantId(){
        return merchantId;
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

    @Override
    public String toString(){
        return
                "MerchantProduct{" +
                        "merchantProductId = '" + merchantProductId + '\'' +
                        ",productId = '" + productId + '\'' +
                        ",merchantId = '" + merchantId + '\'' +
                        ",price = '" + price + '\'' +
                        ",stock = '" + stock + '\'' +
                        "}";
    }

}
