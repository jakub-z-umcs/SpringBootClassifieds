package com.projekt.springboot.umcs.user;

import com.projekt.springboot.umcs.ad.Ad;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String username;
    private String password;
    private boolean active;
    private String roles;

    @ManyToMany(mappedBy = "likedBy", fetch = FetchType.EAGER)
    private Set<Ad> favourites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Set<Ad> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<Ad> favourites) {
        this.favourites = favourites;
    }
}
