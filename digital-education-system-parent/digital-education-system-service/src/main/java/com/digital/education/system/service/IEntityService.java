package com.digital.education.system.service;

import java.util.List;

import com.digital.education.system.data.dao.model.TestEntity;


/**
 * 
 * Entity Service Interface
 * 
 * @author Miquel Millan
 * @version 1.0.0
 *
 */

public interface IEntityService {
	
	public void addEntity(TestEntity entity);
	
	public void updateEntity(TestEntity entity);

	public void deleteEntity(TestEntity entity);
	
	public TestEntity getEntityById(int id);
	
	public List<TestEntity> getEntitys();
}
