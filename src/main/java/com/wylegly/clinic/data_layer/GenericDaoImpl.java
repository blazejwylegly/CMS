package com.wylegly.clinic.data_layer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Marking class as abstract prevents Spring container from
 * creating instances of it.
 * If it was not declared abstract, 
 * getClass().getGenericSuperClass() would return Object. There would be 
 * exception because Object class does not have constructor with parameters.
 * */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<? extends T> daoType;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		
		/**
		 * @TODO!!!
		 * RE-WRITE USING AOP
		 * */
		Type t = getClass().getGenericSuperclass();
		System.out.println("Type: " + t);
		
		ParameterizedType pt = (ParameterizedType) t;
		System.out.println("Pt: " + pt);
		
		daoType = (Class<? extends T>) pt.getActualTypeArguments()[0];
		System.out.println("daoType: " + daoType);
		
	}
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void delete(T obj) {
		currentSession().remove(obj);
		
	}

	@Override
	public void deleteWithId(int id) {
		Session session = currentSession();
		session.delete(session.get(daoType, id));
		
//		One may intend to override this using query for efficency:
//		Query query = currentSession().createQuery("delete from Person where id:=theId");
//		query.setParameter("theId", id);
//		query.executeUpdate();
				
	}

	@Override
	public T get(int id) {
		return currentSession().get(daoType, id);
	}

	@Override
	public List<T> getAll() {
		Session session = currentSession();
		
		CriteriaQuery<? extends T> cq = session.getCriteriaBuilder().createQuery(daoType);
		cq.from(daoType);
		
		List<? extends T> list = session.createQuery(cq).getResultList();
		
		return (List<T>) list;
	}

	@Override
	public void saveOrUpdate(T obj) {
		currentSession().saveOrUpdate(obj);
	}
	
}
