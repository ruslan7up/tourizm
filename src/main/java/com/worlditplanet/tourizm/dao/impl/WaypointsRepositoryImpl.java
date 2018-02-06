package com.worlditplanet.tourizm.dao.impl;

import com.worlditplanet.tourizm.dao.WaypointsRepository;
import com.worlditplanet.tourizm.domain.entity.Waypoint;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Admin on 31.01.2018.
 */
@Repository
public class WaypointsRepositoryImpl implements WaypointsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deleteByRouteId(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Waypoint WHERE route_id = :route_id");
        query.setParameter("route_id", id);
        query.executeUpdate();
    }

    @Override
    public List<Waypoint> getWaypointsByRouteId(Long id) {
        Query query = entityManager.createQuery("FROM Waypoint WHERE route_id = :route_id");
        query.setParameter("route_id", id);
        return query.getResultList();
    }
}
