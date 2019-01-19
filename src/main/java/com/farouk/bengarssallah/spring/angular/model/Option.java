package com.farouk.bengarssallah.spring.angular.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Option  { 
	
	 @Id
	 private String code;
	
 	private String reference;
	  
	
	 private double strikePrice;
	 
	 
	 private String type;
	 
	 
	 private double sharePrice;
	 
	 
	 private Date expiration;
	 
	 
	 private String buyer;
	
	 @Transient 
	 private double intrinsicValue;
	 
	 @Transient 
	 private double speculativePremium;
	 
	 @Transient 
	 private boolean inMoney;
	
	 @DBRef
     private Stock stock;
    
	 public Option() {}
	    
		public Option(String reference, double strikePrice, String type, double sharePrice, Date expiration, String buyer, Stock stock) {
			this.reference = reference;
			this.strikePrice = strikePrice;
			this.type = type;
			this.sharePrice = sharePrice;
			this.expiration = expiration;
			this.buyer = buyer;
			this.stock = stock;
		}

		 public String getCode() {
				return code;
			}

			public void setCode(String code) {
				this.code = code;
			}
			
		public String getReference() {
			return reference;
		}

		public void setReference(String reference) {
			this.reference = reference;
		}

		public double getStrikePrice() {
			return strikePrice;
		}

		public void setStrikePrice(double strikePrice) {
			this.strikePrice = strikePrice;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public double getSharePrice() {
			return sharePrice;
		}

		public void setSharePrice(double sharePrice) {
			this.sharePrice = sharePrice;
		}

		public Date getExpiration() {
			return expiration;
		}

		public void setExpiration(Date expiration) {
			this.expiration = expiration;
		}

		public double getIntrinsicValue() {
			             if(this.getType().equals("CALL")) {
			            	         double diff = getStock().getPrice() - getStrikePrice();
			            	         if(diff < 0) return new Long(0); else return diff;
			                }
			             else {
			            	         double diff = getStrikePrice() - getStock().getPrice();
			            	         if(diff < 0) new Long(0); else return diff;
	                         }    
			            return new Long(0);
		}

		public void setIntrinsicValue(double intrinsicValue) {
			this.intrinsicValue = intrinsicValue;
		}

		public double getSpeculativePremium() {
			return new BigDecimal((getSharePrice() * 100) - getIntrinsicValue()).setScale(3, RoundingMode.HALF_UP).doubleValue();
		}

		public void setSpeculativePremium(double speculativePremium) {
			this.speculativePremium = speculativePremium;
		}

		public boolean isInMoney() {
			return (getIntrinsicValue() > 0);
		}

		public void setInMoney(boolean inMoney) {
			this.inMoney = inMoney;
		}

		public Stock getStock() {
			return stock;
		}

		public void setStock(Stock stock) {
			this.stock = stock;
		}

		public String getBuyer() {
			return buyer;
		}

		public void setBuyer(String buyer) {
			this.buyer = buyer;
		}
	    



}
