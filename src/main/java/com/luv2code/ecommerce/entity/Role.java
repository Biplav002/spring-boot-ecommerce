package com.luv2code.ecommerce.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private Roles roleName;

    public Set<RazorPayUser> getUsers() {
        return users;
    }

    // bi-directional many-to-many association to User
    @ManyToMany(mappedBy = "roles")
    private Set<RazorPayUser> users;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Roles getRoleName() {
        return roleName;
    }

    public String getName() {
        return roleName.name();
    }
    public void setRoleName(Roles roleName) {
        this.roleName = roleName;
    }
}