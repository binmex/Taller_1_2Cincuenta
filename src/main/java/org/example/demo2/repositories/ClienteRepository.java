package org.example.demo2.repositories;

import org.example.demo2.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    /*@Query(value = "UPDATE Cliente u SET last-name = :cliente.lastName, u.apellido = ?2 WHERE u.id = ?3",nativeQuery = true)
    Cliente updateClient(Cliente cliente,Integer id);*/
    @Query("SELECT a FROM Cliente a WHERE a.name LIKE CONCAT('%',:name,'%')")
    public List<Cliente> findByName(String name);

    @Query(value = "select * from clients where email like concat('%',:email,'%')",nativeQuery = true)
    public List<Cliente> findByEmail(String email);

    public List<Cliente> findByAge(int age);

}
