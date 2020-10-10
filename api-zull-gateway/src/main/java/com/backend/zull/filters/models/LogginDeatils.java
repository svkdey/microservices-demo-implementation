package com.backend.zull.filters.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class LogginDeatils {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String transactionID;
	private String APIname;
	private String method;
	private String payload;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getAPIname() {
		return APIname;
	}
	public void setAPIname(String aPIname) {
		APIname = aPIname;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	
	
}
