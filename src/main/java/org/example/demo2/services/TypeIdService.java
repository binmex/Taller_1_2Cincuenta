package org.example.demo2.services;

import org.example.demo2.entities.Cliente;
import org.example.demo2.entities.Producto;
import org.example.demo2.entities.TipoIdentificacion;
import org.example.demo2.repositories.TypeIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeIdService {
    @Autowired
    TypeIdRepository typeIdRepository;
    public List<TipoIdentificacion> findAll(){
        return typeIdRepository.findAll();
    }

    public TipoIdentificacion save(TipoIdentificacion identificacion,Cliente cliente){
        identificacion.setCliente(cliente);
        return typeIdRepository.save(identificacion);
    }

    public TipoIdentificacion findById(Integer id){
        Optional<TipoIdentificacion> optional = typeIdRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public boolean updateIdentificacion(Integer id,TipoIdentificacion identificacion){
        TipoIdentificacion findIdentificacion = findById(id);
        if (findIdentificacion != null){
            findIdentificacion.setNumIdentificacion(identificacion.getNumIdentificacion());
            findIdentificacion.setTipo(identificacion.getTipo());
            typeIdRepository.save(findIdentificacion);
            return true;
        }else {
            return false;
        }
    }

    public boolean removeIdentificacion(Integer id){
        typeIdRepository.delete(findById(id));
        return true;
    }
}
