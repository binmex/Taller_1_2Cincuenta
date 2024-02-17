package org.example.demo2.entities;

import jakarta.persistence.*;
import org.example.demo2.controller.TipoIdentificacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idClient")
    private Integer id;
    @Column(name = "name",nullable = false,length = 20)
    private String name;
    @Column(name = "last-name",nullable = false,length = 20)
    private String lastName;
    @Column(name = "age",nullable = false)
    private int age;
    @Column(name = "email",nullable = true,length = 20)
    private String email;
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
    private List<Factura> factures;
    @OneToOne
    private TipoIdentificacion tipoIdentificacion;

    public Cliente() {
        factures= new ArrayList<>();
    }

    public Cliente(Integer id, String name, String lastName, int age, String gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Factura> getFactures() {
        return factures;
    }

    public void setFactures(List<Factura> factures) {
        this.factures = factures;
    }
}
