package com.farouk.bengarssallah.spring.angular.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock { 
	
	 @Id
	private String code;
	
	 
	private String name;
	
	 
    private String symbol;
	
	 
    private long price;
	
	 
    private long change;
	
	 
    private String percentage;
	
	 
    private String beta;
	
    
	 public Stock() {}
	    
		public Stock(String symbol, long price) {
			this.symbol = symbol;
			this.price = price;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		public Long getPrice() {
			return price;
		}

		public void setPrice(long price) {
			this.price = price;
		}

		public long getChange() {
			return change;
		}

		public void setChange(long change) {
			this.change = change;
		}

		public String getPercentage() {
			return percentage;
		}

		public void setPercentage(String percentage) {
			this.percentage = percentage;
		}

		public String getBeta() {
			return beta;
		}

		public void setBeta(String beta) {
			this.beta = beta;
		}


	
}
