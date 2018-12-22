package com.digital.education.system.data.dao;

import java.util.List;

import com.digital.education.system.data.dao.model.TestEntity;

public interface ITestEntityDAO {

	public void addEntity(TestEntity entity);

	public void updateEntity(TestEntity entity);
	
	public void deleteEntity(TestEntity entity);
	
	public TestEntity getEntity(int id);

	public List<TestEntity> getEntities();
}
