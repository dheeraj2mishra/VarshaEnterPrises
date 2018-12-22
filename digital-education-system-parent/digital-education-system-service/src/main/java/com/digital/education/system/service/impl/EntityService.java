package com.digital.education.system.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.digital.education.system.data.dao.ITestEntityDAO;
import com.digital.education.system.data.dao.model.TestEntity;
import com.digital.education.system.service.IEntityService;


/**
 * 
 * Entity Service
 * 
 * @author Miquel Millan
 * @version 1.0.0
 *
 */
@Named
@Transactional(readOnly = true)
public class EntityService implements IEntityService {

	@Inject
	ITestEntityDAO entityDAO;

	@Transactional(readOnly = false)
	public void addEntity(TestEntity entity) {
		getEntityDAO().addEntity(entity);
	}

	@Transactional(readOnly = false)
	public void deleteEntity(TestEntity entity) {
		getEntityDAO().deleteEntity(entity);
	}

	@Transactional(readOnly = false)
	public void updateEntity(TestEntity entity) {
		getEntityDAO().updateEntity(entity);
	}

	public TestEntity getEntityById(int id) {
		return getEntityDAO().getEntity(id);
	}

	public List<TestEntity> getEntitys() {	
		return getEntityDAO().getEntities();
	}

	public ITestEntityDAO getEntityDAO() {
		return entityDAO;
	}

	public void setEntityDAO(ITestEntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}
}
