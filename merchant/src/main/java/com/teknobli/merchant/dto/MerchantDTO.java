package com.teknobli.merchant.dto;

public class MerchantDTO {
    private String merchantId;
    private String merchantName;

    public void setMerchantId(String merchantId){
        this.merchantId = merchantId;
    }

    public String getMerchantId(){
        return merchantId;
    }

    public void setMerchantName(String merchantName){
        this.merchantName = merchantName;
    }

    public String getMerchantName(){
        return merchantName;
    }

    @Override
    public String toString(){
        return
                "Merchant{" +
                        "merchantId = '" + merchantId + '\'' +
                        ",merchantName = '" + merchantName + '\'' +
                        "}";
    }
}
