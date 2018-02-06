package com.worlditplanet.tourizm.services;

import com.worlditplanet.tourizm.domain.entity.Waypoint;

import java.util.List;

/**
 * Created by Admin on 02.02.2018.
 */
public interface WaypointsService {
    public void deleteByRouteId(Long id);
    public List<Waypoint> getWaypointsByRouteId(Long id);
}
