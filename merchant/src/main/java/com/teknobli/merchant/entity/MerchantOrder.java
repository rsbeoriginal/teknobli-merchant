package com.teknobli.merchant.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = MerchantOrder.TABLE_NAME)
public class MerchantOrder{

	public static final String TABLE_NAME="MERCHANT_ORDER";

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid",strategy = "uuid2")
	private String merchantOrderId;
	private String productId;
	private String merchantId;
	private String orderId;

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

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public String getOrderId(){
		return orderId;
	}

	public void setMerchantOrderId(String merchantOrderId){
		this.merchantOrderId = merchantOrderId;
	}

	public String getMerchantOrderId(){
		return merchantOrderId;
	}

	@Override
 	public String toString(){
		return 
			"MerchantOrderRepository{" +
			"productId = '" + productId + '\'' + 
			",merchantId = '" + merchantId + '\'' + 
			",orderId = '" + orderId + '\'' + 
			",merchantOrderId = '" + merchantOrderId + '\'' + 
			"}";
		}
}
