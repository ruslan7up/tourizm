package com.worlditplanet.tourizm.dao;

import com.worlditplanet.tourizm.domain.entity.Role;

/**
 * Created by Admin on 26.01.2018.
 */
public interface RolesRepository {
    public Role getRoleByDesc(String desc);
}
