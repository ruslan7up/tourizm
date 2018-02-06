package com.worlditplanet.tourizm.services;

import com.worlditplanet.tourizm.domain.entity.Route;

import java.util.List;

public interface RoutesService {
    Route getRouteById(Long id);

    List<Route> getRoutesByPage(Long page);
    Long getCheckedNumberOfPages();
    List<Route> getUncheckedRoutesByPage(Long page);
    Long getUncheckedNumberOfPages();
    void addRoute(Route route);
    void updateRoute(Route route);
    void removeRouteById(Long id);
}
