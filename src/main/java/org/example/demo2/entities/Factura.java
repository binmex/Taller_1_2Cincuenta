package org.example.demo2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "facture")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idFactura")
    private Integer idFactura;
    @Column(name = "dateOfIssuance",nullable = false,length = 20)
    private LocalDate date_of_issuance;
    @Column(name = "state",nullable = false,length = 20)
    private String state;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,foreignKey = @ForeignKey(name = "fk_facture_to_client"))
    @JsonIgnore
    private Cliente client;
    @ManyToMany
    @JoinTable(
            name = "factura_producto",
            joinColumns = @JoinColumn(name = "idFactura"),
            inverseJoinColumns = @JoinColumn(name = "idProducto")
    )
    //@JsonIgnore
    private List<Producto> productos;

    public Factura() {
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getDate_of_issuance() {
        return date_of_issuance;
    }

    public void setDate_of_issuance(LocalDate date_of_issuance) {
        this.date_of_issuance = date_of_issuance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
