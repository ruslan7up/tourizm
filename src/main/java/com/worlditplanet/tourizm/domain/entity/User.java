package com.worlditplanet.tourizm.domain.entity;

import com.worlditplanet.tourizm.domain.entity.Role;
import com.worlditplanet.tourizm.domain.entity.Route;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Admin on 07.01.2018.
 */
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    @Size(min = 4, max = 10, message = "Длина логина должна быть в пределах от 4 до 10 символов")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Логин должен содержать только латинские буквы и цифры")
    private String login;

    @Column(name = "password", nullable = false)
    @Size(min = 5, max = 50, message = "Длина пароля должна быть в пределах от 5 до 30 символов")
    @Pattern(regexp = "^[a-zA-Z0-9\\.\\+\\?\\-]+$", message = "Логин должен содержать только латинские буквы и цифры")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns
            = @JoinColumn(name = "user_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id"), uniqueConstraints = @UniqueConstraint(columnNames = {"role_id","user_id"}))
    private List<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "author")
    private List<Route> routes;

    public User() {
    }

    public User(String login, String password, String fullName, String country, String city, List<Role> roles, List<Route> routes) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.country = country;
        this.city = city;
        this.roles = roles;
        this.routes = routes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (fullName != null ? !fullName.equals(user.fullName) : user.fullName != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;
        return routes != null ? routes.equals(user.routes) : user.routes == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (routes != null ? routes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", roles=" + roles +
                ", routes=" + routes +
                '}';
    }
}
