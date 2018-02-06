package com.worlditplanet.tourizm.services.impl;

import com.worlditplanet.tourizm.dao.WaypointsRepository;
import com.worlditplanet.tourizm.domain.entity.Waypoint;
import com.worlditplanet.tourizm.services.WaypointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 02.02.2018.
 */
@Service
public class WaypointsServiceImpl implements WaypointsService {

    @Autowired
    private WaypointsRepository waypointsRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void deleteByRouteId(Long id) {
        waypointsRepository.deleteByRouteId(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE, readOnly = true)
    public List<Waypoint> getWaypointsByRouteId(Long id) {
        return waypointsRepository.getWaypointsByRouteId(id);
    }
}
