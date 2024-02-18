package org.example.demo2.repositories;

import org.example.demo2.entities.TipoIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeIdRepository extends JpaRepository<TipoIdentificacion,Integer> {

}
