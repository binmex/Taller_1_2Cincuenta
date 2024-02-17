package org.example.demo2.controller;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "tipo_identificacion")
public class TipoIdentificacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTipoIdentificacion")
    private Integer idTipoIdentificacion;
    @Column(name = "tipo")
    private String tipo;
}
