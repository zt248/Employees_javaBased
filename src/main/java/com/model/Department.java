package com.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organization")
    private String organization;

    @Column(name = "position")
    private String position;

    @ManyToMany(mappedBy = "departments")
    private Set<Employee> employees;

    public Department() {

    }

    public Department(String organization, String position) {
        this.organization = organization;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", organization='" + organization + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
