package com.worlditplanet.tourizm.dao;

import com.worlditplanet.tourizm.domain.entity.Route;

import java.util.List;

/**
 * Created by Admin on 07.01.2018.
 */
public interface RouteRepository {
    Route getRouteById(Long id);
    List<Route> getCheckedRoutesByPage(Long page);
    Long getCheckedNumberOfPages();
    List<Route> getUncheckedRoutesByPage(Long page);
    Long getUncheckedNumberOfPages();
    void addRoute(Route route);
    void updateRoute(Route route);
    void removeRouteById(Long id);
}
