package com.crud.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRUDMessageTable")
public class CrudPojoClass {
	@Id
	int meassageId;
	String message;
	public CrudPojoClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CrudPojoClass(int meassageId, String message) {
		super();
		this.meassageId = meassageId;
		this.message = message;
	}
	public int getMeassageId() {
		return meassageId;
	}
	public void setMeassageId(int meassageId) {
		this.meassageId = meassageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
