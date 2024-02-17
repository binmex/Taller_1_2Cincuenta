package org.example.demo2.controller;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "productos")
public class Productos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private float precio;
}
