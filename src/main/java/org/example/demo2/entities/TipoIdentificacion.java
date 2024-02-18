package org.example.demo2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "tipo_identificacion")
public class TipoIdentificacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a GenerationType.IDENTITY para generar automáticamente el ID
    @Column(name = "id_type")
    private Integer id;

    @Column(name = "num_identificacion")
    private Integer numIdentificacion;

    @Column(name = "tipo")
    private String tipo;

    @OneToOne
    @JsonIgnore
    private Cliente cliente;

    public TipoIdentificacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(Integer numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
