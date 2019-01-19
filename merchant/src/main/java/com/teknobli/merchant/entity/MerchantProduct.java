package com.teknobli.merchant.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = MerchantProduct.TABLE_NAME)
public class MerchantProduct{

	public static final String TABLE_NAME="MERCHANT_PRODUCT";

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid",strategy = "uuid2")
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
