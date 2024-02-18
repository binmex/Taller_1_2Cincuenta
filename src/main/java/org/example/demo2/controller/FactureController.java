package org.example.demo2.controller;

import org.example.demo2.entities.Cliente;
import org.example.demo2.entities.Factura;
import org.example.demo2.responses.ResponseHandler;
import org.example.demo2.services.ClientServices;
import org.example.demo2.services.FactureServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/factura")
public class FactureController {
    @Autowired
    private FactureServices factureServices;
    @Autowired
    private ClientServices clientServices;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        try {
            List<Factura> result = factureServices.findAll();
            return ResponseHandler.generateResponse("Success",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Success",HttpStatus.OK,factureServices.findById(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PostMapping("/{idCliente}")
    public ResponseEntity<Object> saveFacture(@PathVariable Integer idCliente,@RequestBody Factura factura){
        try {
            Cliente cliente = clientServices.findById(idCliente);
            if (cliente != null){
                Factura result = factureServices.save(factura,cliente);
                return ResponseHandler.generateResponse("Success Author",HttpStatus.CREATED,factura);
            }
            return ResponseHandler.generateResponse("Success Author",HttpStatus.NOT_FOUND,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editFacture(@PathVariable Integer id, @RequestBody Factura factura){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,factureServices.updateFacture(id,factura));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFacture(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,factureServices.removeFacture(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @GetMapping("/allInformation/")
    public ResponseEntity<Object> findFactureAllInformation(){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,factureServices.factureAllInformation());
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }

}
