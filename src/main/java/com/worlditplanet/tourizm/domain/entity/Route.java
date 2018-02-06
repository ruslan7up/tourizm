package com.worlditplanet.tourizm.domain.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Admin on 07.01.2018.
 */
@Entity
@Table(name = "app_route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @Column(name = "route_name")
    private String title;

    @Column(name = "route_text", columnDefinition = "text")
    private String text;

    @Column(name = "route_rating")
    private Integer rating;

    @Column(name = "route_ischecked")
    private boolean checked = true;

    @Column(name = "route_country")
    private String country;

    @Column(name = "route_city")
    private String city;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "route")
    private List<Waypoint> waypoints;


    public Route() {
    }

    public Route(User author, String title, String text, Integer rating, boolean checked, String country, String city, List<Waypoint> waypoints) {
        this.author = author;
        this.title = title;
        this.text = text;
        this.rating = rating;
        this.checked = checked;
        this.country = country;
        this.city = city;
        this.waypoints = waypoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (checked != route.checked) return false;
        if (id != null ? !id.equals(route.id) : route.id != null) return false;
        if (author != null ? !author.equals(route.author) : route.author != null) return false;
        if (title != null ? !title.equals(route.title) : route.title != null) return false;
        if (text != null ? !text.equals(route.text) : route.text != null) return false;
        if (rating != null ? !rating.equals(route.rating) : route.rating != null) return false;
        if (country != null ? !country.equals(route.country) : route.country != null) return false;
        if (city != null ? !city.equals(route.city) : route.city != null) return false;
        return waypoints != null ? waypoints.equals(route.waypoints) : route.waypoints == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (checked ? 1 : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (waypoints != null ? waypoints.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", rating=" + rating +
                ", checked=" + checked +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", waypoints=" + waypoints +
                '}';
    }
}
