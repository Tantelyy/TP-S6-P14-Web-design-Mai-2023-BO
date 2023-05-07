package com.project.iacontent.dao;

import com.project.iacontent.model.Administrator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;

//Hibernate 3.0
public class HibernateDao {

    private SessionFactory sessionFactory;

    public Administrator findByMailPwd(String mail, String pwd) {
        Session session = null;
        Administrator administrator = null;
        try {
            session = sessionFactory.openSession();
            administrator = (Administrator) session.createCriteria(Administrator.class)
                    .add(Restrictions.and(
                            Restrictions.sqlRestriction("mail='"+mail+"'"),
                            Restrictions.sqlRestriction("pwd='"+pwd+"'")
                    )).uniqueResult();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
        return administrator;
    }

    public <T> T create(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
        return entity;
    }

    public <T> T findById(Class<T> clazz,Serializable id){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            T entity = (T) session.get(clazz, id);

            return entity;
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    public <T> List<T> findAll(Class<T> tClass){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<T> results = session.createCriteria(tClass).list();

            return results;
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }

    }

    public <T> List<T> findWhere(T entity){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            List<T> results = session.createCriteria(entity.getClass()).add(example).list();

            return results;
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }

    }

    public <T> List<T> paginateWhere (T entity, int offset, int size){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            List<T> results = session.createCriteria(entity.getClass())
                    .add(example)
                    .setFirstResult(offset)
                    .setMaxResults(size).list();

            return results;
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }

    }

    public <T> List<T> paginate(Class<T> clazz, int offset, int size){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<T> results = session.createCriteria(clazz)
                    .setFirstResult(offset)
                    .setMaxResults(size).list();

            return results;
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    public <T> List<T> paginate(Class<T> clazz, int offset, int size, String orderBy, boolean orderAsc){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Order order = (orderAsc) ? Order.asc(orderBy) : Order.desc(orderBy);
            List<T> results = session.createCriteria(clazz)
                    .addOrder(order)
                    .setFirstResult(offset)
                    .setMaxResults(size).list();

            return results;
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }

    }

    public void deleteById(Class tClass, Serializable id){
        delete(findById(tClass, id));
    }

    public void delete(Object entity){
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    public <T> T update(T entity){
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
        return entity;
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}