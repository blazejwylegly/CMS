package com.wylegly.clinic.dao;

import java.util.List;

public interface GenericDao<T> {


	/**
     * Method that adds passed object to DB
     * @param t object do be added or updated
     */
	public void saveOrUpdate(T obj);
	
	/**
     * Method deletes passed object
     * @param t object do be deleted
     */
	public void delete(T obj);
	
	/**
     * Method deletes object with specified id
     * @param id of object to be deleted
     */
	public void deleteWithId(int id);
	
	/**
     * Method that retrieves object from DB
     * @param id of object to be retrieved
     * @return t retrieved object/null
     */
	public T get(int id);
	
	/**
     * Method retrieves every entity
     * @return collection of entities
     */
	public List<T> getAll();

}

