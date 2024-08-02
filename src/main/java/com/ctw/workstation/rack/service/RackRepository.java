package com.ctw.workstation.rack.service;

import com.ctw.workstation.rack.entity.Rack;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class RackRepository implements PanacheRepository<Rack> {

    public List<Rack> getAll() {
        return listAll();
    }

    public void add(Rack rack) {
        persist(rack);
    }
}
