package com.worlditplanet.tourizm.dao;

import com.worlditplanet.tourizm.domain.entity.Waypoint;

import java.util.List;

/**
 * Created by Admin on 31.01.2018.
 */
public interface WaypointsRepository {
    public void deleteByRouteId(Long id);
    public List<Waypoint> getWaypointsByRouteId(Long id);
}
