package com.worlditplanet.tourizm.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Admin on 24.01.2018.
 */
@Entity
@Table(name = "app_waypoint")
public class Waypoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "waypoint_latitude")
    private double latitude;

    @Column(name = "waypoint_longitude")
    private double longitude;

    @Column(name = "waypoint_description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    @JsonIgnore
    private Route route;

    public Waypoint() {
    }

    public Waypoint(double latitude, double longitude, String description, Route route) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.route = route;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Waypoint waypoint = (Waypoint) o;

        if (Double.compare(waypoint.latitude, latitude) != 0) return false;
        if (Double.compare(waypoint.longitude, longitude) != 0) return false;
        if (id != null ? !id.equals(waypoint.id) : waypoint.id != null) return false;
        if (description != null ? !description.equals(waypoint.description) : waypoint.description != null)
            return false;
        return route != null ? route.equals(waypoint.route) : waypoint.route == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (route != null ? route.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", description='" + description + '\'' +
                ", route=" + route +
                '}';
    }
}
