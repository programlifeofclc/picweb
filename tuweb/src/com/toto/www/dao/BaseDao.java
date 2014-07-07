package com.toto.www.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import utils.Utils;

@Repository("baseDao")
public class BaseDao{
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public Object save(Object o){
		hibernateTemplate.save(o);
        return o;
	}
	public Object get(Class<?> clazz,Serializable id) {
		return hibernateTemplate.get(clazz, id);
	}
	public Object update(Object o) {
		hibernateTemplate.update(o);
		return o;
	}
	public Object saveOrUpdate(Object o) {
		hibernateTemplate.saveOrUpdate(o);
		return o;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> findHqlList(final String hql,final List<Object> values,final int start,final int length){
		return hibernateTemplate.execute(new HibernateCallback() {
			public List<Object> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				if(Utils.checkNNList(values)){
					for(int i = 0,n = values.size(); i < n; i++){
						query.setParameter(i, values.get(i));
					}
				}
				query.setFirstResult(0);
				query.setMaxResults(11);
				List list = query.list();
				return list;
			}
		});
	}
	public Object findHqlObject(String hql,List<Object> values){
		List<Object> list = this.findHqlList(hql, values, 1, 1);
		if(list == null || list.size() == 0)
			return null;
		return list.get(0);
	}
	public List<?> findSqlArr(String sql){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		return session.createQuery(sql).list();
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
