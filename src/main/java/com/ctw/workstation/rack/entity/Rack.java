package com.ctw.workstation.rack.entity;

import com.ctw.workstation.Location;
import com.ctw.workstation.Status;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "T_RACK")
public class Rack extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(insertable = false)
    private UUID id;
    @Column(name = "serial_number", length = 15, nullable = false)
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
    @Column(name = "team_id", nullable = false)
    private UUID teamId;
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

    public Rack(String serialNumber, Status status, UUID teamId, Location defaultLocation) {
        this.serialNumber = serialNumber;
        this.status = status;
        this.teamId = teamId;
        this.defaultLocation = defaultLocation;
    }

    public Rack() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public Location getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(Location defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
