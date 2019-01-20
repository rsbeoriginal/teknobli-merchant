package com.teknobli.merchant.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Merchant.TABLE_NAME)
public class Merchant{

	public static final String TABLE_NAME="MERCHANT";

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid",strategy = "uuid2")
	private String merchantId;
	private String merchantName;
	private Double rating = 5d;

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

	public static String getTableName() {
		return TABLE_NAME;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
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
