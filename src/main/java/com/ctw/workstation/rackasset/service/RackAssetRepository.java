package com.ctw.workstation.rackasset.service;

import com.ctw.workstation.rackasset.entity.RackAsset;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class RackAssetRepository implements PanacheRepository<RackAsset> {

    public List<RackAsset> getAll() {
        return listAll();
    }
}
