package com.skyfashion.backend.service;


import com.skyfashion.backend.entity.Role;
import com.skyfashion.backend.repository.RoleRepo;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RoleService implements RoleRepo {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Role findByName(String name) {
        // above Role type is changed
        Session currSession = entityManager.unwrap(Session.class);
        Query query = currSession.createQuery("from Role r where r.name=:name");
        query.setParameter("name", name);
        List<Role> list = query.getResultList();
        return (!list.isEmpty()) ? list.get(0) : null;
    }
}
