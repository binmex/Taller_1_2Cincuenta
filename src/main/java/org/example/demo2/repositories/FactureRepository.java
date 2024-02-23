package org.example.demo2.repositories;

import org.example.demo2.entities.Cliente;
import org.example.demo2.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Factura,Integer> {


}
