package com.wylegly.clinic.service_layer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wylegly.clinic.data_layer.GenericDao;
import com.wylegly.clinic.domain.Patient;

@Service
public abstract class GenericServiceImpl<T> implements GenericService<T> {

	/**
	 * IMPORTANT!
	 * genericDao must be initialized by sub-classes, so 
	 * they can choose between various implementations of daos
	 * by using @Qualifier
	 * 
	 * genericDao provides implementation of 
	 * */
	private GenericDao<T> genericDao;

	public GenericServiceImpl() {
		
	}
	
	@Autowired
    public GenericServiceImpl(GenericDao<T> genericDao){
    	this.genericDao = genericDao;
    }
  
	@Transactional
	@Override
	public void saveOrUpdate(T entity) {
		genericDao.saveOrUpdate(entity);		
	}

	@Transactional
	@Override
	public List<T> getAll() {
		return genericDao.getAll();
	}

	@Transactional
	@Override
	public T get(int id) {
		return genericDao.get(id);
	}


	@Transactional
	@Override
	public void remove(T entity) {
		genericDao.delete(entity);
		
	}

	@Transactional
	@Override
	public void remove(int id) {
		genericDao.deleteWithId(id);
		
	}
	
}
