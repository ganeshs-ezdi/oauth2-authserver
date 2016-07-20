package com.ezdi.beans;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by EZDI\ganesh.s on 15/7/16.
 */
@Entity
@Table(name="roles")
public class Role implements Serializable{
    @Id
    private String role;
    private String description;

    public Role() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
