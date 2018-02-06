package com.worlditplanet.tourizm.services.impl;

import com.worlditplanet.tourizm.dao.RouteRepository;
import com.worlditplanet.tourizm.dao.WaypointsRepository;
import com.worlditplanet.tourizm.domain.entity.Route;
import com.worlditplanet.tourizm.services.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoutesServiceImpl implements RoutesService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private WaypointsRepository waypointsRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public Route getRouteById(Long id) {
        return routeRepository.getRouteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<Route> getRoutesByPage(Long page) {
        return routeRepository.getCheckedRoutesByPage(page);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public Long getCheckedNumberOfPages() {
        return routeRepository.getCheckedNumberOfPages();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<Route> getUncheckedRoutesByPage(Long page) {
        return routeRepository.getUncheckedRoutesByPage(page);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public Long getUncheckedNumberOfPages() {
        return routeRepository.getCheckedNumberOfPages();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void addRoute(Route route) {
        routeRepository.addRoute(route);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void updateRoute(Route route) {
        waypointsRepository.deleteByRouteId(route.getId());
        routeRepository.updateRoute(route);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void removeRouteById(Long id) {
        routeRepository.removeRouteById(id);
    }
}
