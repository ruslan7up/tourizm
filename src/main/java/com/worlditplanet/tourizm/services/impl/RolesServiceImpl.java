package com.worlditplanet.tourizm.services.impl;

import com.worlditplanet.tourizm.dao.RolesRepository;
import com.worlditplanet.tourizm.domain.entity.Role;
import com.worlditplanet.tourizm.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Admin on 26.01.2018.
 */
@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public Role getRoleByDesc(String desc) {
        return rolesRepository.getRoleByDesc(desc);
    }
}
