package com.worlditplanet.tourizm.dao.impl;

import com.worlditplanet.tourizm.dao.RouteRepository;
import com.worlditplanet.tourizm.domain.entity.Route;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RouteRepositoryImpl implements RouteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Route getRouteById(Long id) {
        return entityManager.find(Route.class, id);
    }

    @Override
    public List<Route> getCheckedRoutesByPage(Long page) {
        Query query = entityManager.createQuery("FROM Route WHERE checked=true ORDER BY id DESC").setFirstResult((int)(page-1)*10).setMaxResults(10);
        List<Route> routes = query.getResultList();
        return routes;
    }

    @Override
    public Long getCheckedNumberOfPages() {
        Long count = (Long) entityManager.createQuery("SELECT count(*) from Route").getSingleResult();
        return (long) Math.ceil((double) count.intValue()/10);
    }

    @Override
    public List<Route> getUncheckedRoutesByPage(Long page) {
        Query query = entityManager.createQuery("FROM Route WHERE checked=false ORDER BY id DESC").setFirstResult((int)(page-1)*10).setMaxResults(10);
        List<Route> routes = query.getResultList();
        return routes;
    }

    @Override
    public Long getUncheckedNumberOfPages() {
        Long count = (Long) entityManager.createQuery("SELECT count(*) from Route WHERE checked=false").getSingleResult();
        return (long) Math.ceil((double) count.intValue()/10);
    }

    @Override
    public void addRoute(Route route) {
        entityManager.persist(route);
    }

    @Override
    public void updateRoute(Route route) {
        entityManager.merge(route);
    }

    @Override
    public void removeRouteById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Route WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
