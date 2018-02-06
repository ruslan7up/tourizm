package com.worlditplanet.tourizm.dao.impl;

import com.worlditplanet.tourizm.dao.RolesRepository;
import com.worlditplanet.tourizm.domain.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Admin on 26.01.2018.
 */
@Repository
public class RolesRepositoryImpl implements RolesRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Role getRoleByDesc(String desc) {
        Query query = entityManager.createQuery("FROM Role WHERE description = :description");
        query.setParameter("description", desc);
        return (Role) query.getSingleResult();
    }
}
