package com.skyfashion.backend.repository;


import com.skyfashion.backend.entity.Role;

public interface RoleRepo {
    public Role findByName(String name);
}
