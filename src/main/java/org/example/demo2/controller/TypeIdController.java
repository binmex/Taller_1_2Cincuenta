package org.example.demo2.controller;

import org.example.demo2.entities.Cliente;
import org.example.demo2.entities.Factura;
import org.example.demo2.entities.Producto;
import org.example.demo2.entities.TipoIdentificacion;
import org.example.demo2.responses.ResponseHandler;
import org.example.demo2.services.ClientServices;
import org.example.demo2.services.FactureServices;
import org.example.demo2.services.ProductoService;
import org.example.demo2.services.TypeIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/identificacion")
public class TypeIdController {
    @Autowired
    private TypeIdService typeIdService;
    @Autowired
    private ClientServices clientServices;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        try {
            List<TipoIdentificacion> result = typeIdService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Success",HttpStatus.OK,typeIdService.findById(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }

    @PostMapping("/{idCliente}")
    public ResponseEntity<Object> saveIdentification(@PathVariable Integer idCliente,@RequestBody TipoIdentificacion identificacion){
        try {
            Cliente cliente = clientServices.findById(idCliente);
            if (cliente != null){
                TipoIdentificacion result = typeIdService.save(identificacion,cliente);
                return ResponseHandler.generateResponse("Success Author",HttpStatus.CREATED,identificacion);
            }
            return ResponseHandler.generateResponse("No found Client",HttpStatus.NOT_FOUND,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editIdentification(@PathVariable Integer id, @RequestBody TipoIdentificacion identificacion){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,typeIdService.updateIdentificacion(id,identificacion));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteIdentification(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,typeIdService.removeIdentificacion(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }
}
