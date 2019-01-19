package com.farouk.bengarssallah.spring.angular.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Portfolio  { 
	
	@Id
	private String code;

	private String reference;
	

    private String owner;
	

    private Date created;
	
	@DBRef
    private List<Option> options = new ArrayList<>();
   

	public Portfolio() {}



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



	public String getOwner() {
		return owner;
	}



	public Portfolio(String reference, String owner, Date created) {
		this.reference = reference;
		this.owner = owner;
		this.created = created;
	}



	public void setOwner(String owner) {
		this.owner = owner;
	}



	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public List<Option> getOptions() {
		return options;
	}


	public void setOptions(List<Option> options) {
		this.options = options;
	}

   
	
 }