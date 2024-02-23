package org.example.demo2.services;

import org.example.demo2.entities.Cliente;
import org.example.demo2.entities.Factura;
import org.example.demo2.entities.Producto;
import org.example.demo2.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public Producto save(Producto producto){
        //producto.setFacturas(factura);
        return productoRepository.save(producto);
    }

    public Producto findById(Integer id){
        Optional<Producto> optional = productoRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public boolean updateProducto(Integer id,Producto producto){
        Producto findProducto = findById(id);
        if (findProducto != null){
            findProducto.setNombre(producto.getNombre());
            findProducto.setPrecio(producto.getPrecio());
            productoRepository.save(findProducto);
            return true;
        }else {
            return false;
        }
    }

    public boolean removeFacture(Integer id){
        productoRepository.delete(findById(id));
        return true;
    }

    public List<Producto> findByName(String name){
        return productoRepository.findByName(name);
    }
}
