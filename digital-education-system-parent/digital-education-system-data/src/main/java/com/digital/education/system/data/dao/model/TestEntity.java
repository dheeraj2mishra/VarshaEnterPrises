package com.digital.education.system.data.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class TestEntity {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="attribute")
	private String attribute;
	
	public TestEntity(){}
	
	public TestEntity(int id, String attribute) {
		super();
		this.id = id;
		this.attribute = attribute;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

}
