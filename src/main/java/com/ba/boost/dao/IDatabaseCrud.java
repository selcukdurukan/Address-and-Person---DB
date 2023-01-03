package com.ba.boost.dao;

import java.util.List;

import com.ba.boost.util.HibernateUtil;

import org.hibernate.Session;

public interface IDatabaseCrud<T> {

	void create(T entity);

	List<T> retrive();

	T update(long id, T entity);

	T delete(long id);

	T find(long id);

	default Session databaseConnection() {
		return HibernateUtil.getSessionFactory().openSession();
	}

}
