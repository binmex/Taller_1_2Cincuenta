package org.example.demo2.repositories;

import org.example.demo2.entities.Cliente;
import org.example.demo2.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    @Query("SELECT a FROM Producto a WHERE a.nombre LIKE CONCAT('%',:name,'%')")
    public List<Producto> findByName(String name);
}
