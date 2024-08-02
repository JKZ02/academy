package com.ctw.workstation.rackasset.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "T_RACK_ASSET")
public class RackAsset extends PanacheEntityBase {
    @Id
    @Column(insertable = false)
    private UUID id;
    @Column(name = "asset_tag", length = 10, nullable = false)
    private String assetTag;

}
