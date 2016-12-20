/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import com.blinfosoft.feedback.mysql.MysqlException;
import com.blinfosoft.feedback.entity.DomainEntity;
/**
 *
 * @author js
 * @param <T>
 * @param <ID>
 */
public abstract class GenericDao<T extends DomainEntity<ID>, ID extends Serializable> {

    private final EntityManagerFactory emf;
    private final Class<T> persistentClass;

    public GenericDao(Class c, EntityManagerFactory entityManagerFactory) {
        this.persistentClass = c;
        this.emf = entityManagerFactory;
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Optional<T> findByPrimaryKey(ID id) {
        return execute((em) -> {
            return (T) em.find(persistentClass, id);
        });
    }

    public <R> Optional<R> execute(Function<EntityManager, R> queryFunction) {
        EntityManager em = getEntityManager();
        try {
            return Optional.ofNullable(queryFunction.apply(em));
        } catch (NoResultException ex) {
            return Optional.empty();
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, e.getLocalizedMessage(), e);
            throw new MysqlException("Cannot execute query", e);
        } finally {
            em.close();
        }
    }

    public void executeInTransaction(Consumer<EntityManager> consumer) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            consumer.accept(em);
            tx.commit();
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, e.getLocalizedMessage(), e);
            try {
                tx.rollback();
            } catch (RuntimeException e1) {
                Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, "Unable to rollback", e1);
            }

            throw new MysqlException("Cannot execute transaction", e);
        } finally {
            em.close();
        }
    }

    public List<T> findAll() {
        return findAll(true, -1, -1);
    }

    public List<T> findAll(int maxResults, int firstResult) {
        return findAll(false, maxResults, firstResult);
    }

    private List<T> findAll(boolean all, int maxResults, int firstResult) {
        return execute((em) -> {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(persistentClass));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();

        }).orElse(Collections.emptyList());
    }

    public void destroy(T entity) {
        executeInTransaction((em) -> em.remove(em.contains(entity) ? entity : em.merge(entity)));
    }
}
