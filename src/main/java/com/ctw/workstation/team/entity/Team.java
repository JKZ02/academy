package com.ctw.workstation.team.entity;

import com.ctw.workstation.Location;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "T_TEAM")
public class Team extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(insertable = false)
    private UUID id;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "product", length = 20, nullable = false)
    private String product;
    @Enumerated(EnumType.STRING)
    @Column(name = "default_location", nullable = false)
    private Location defaultLocation;
    @Transient
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Transient
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    public Team( String name, String product, Location defaultLocation) {
        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public Team() {
    }

    public Location getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(Location defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) { this.id = id; }

}
