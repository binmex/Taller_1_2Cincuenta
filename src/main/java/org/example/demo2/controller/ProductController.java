package org.example.demo2.controller;

import org.example.demo2.entities.Producto;
import org.example.demo2.responses.ResponseHandler;
import org.example.demo2.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/producto")
public class ProductController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        try {
            List<Producto> result = productoService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Success",HttpStatus.OK,productoService.findById(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> saveProduct(@RequestBody Producto producto){
        try {
                if (producto.getPrecio() > 0){
                    Producto result = productoService.save(producto);
                    return ResponseHandler.generateResponse("Success",HttpStatus.CREATED,result);
                }else {
                    return ResponseHandler.generateResponse("Success",HttpStatus.CREATED,"El precio debe ser mayor a 0");
                }

        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editProducto(@PathVariable Integer id, @RequestBody Producto producto){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,productoService.updateProducto(id,producto));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductp(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,productoService.removeFacture(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @GetMapping("/name/{nameProduct}")
    public ResponseEntity<Object> findByNameProduct(@PathVariable String nameProduct){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,productoService.findByName(nameProduct));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }
}
