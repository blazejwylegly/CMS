package com.wylegly.clinic.service_layer;

import java.util.List;

public interface GenericService<T> {

	public void saveOrUpdate(T entity);
	public List<T> getAll();
	public T get(int id);
	public void remove(T entity);
	public void remove(int id);
}
