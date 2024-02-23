package org.example.demo2.controller;

import org.example.demo2.entities.Cliente;
import org.example.demo2.entities.Factura;
import org.example.demo2.responses.ResponseHandler;
import org.example.demo2.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClientController {
    @Autowired
    private ClientServices clientServices;

    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        try {
            List<Cliente> result = clientServices.findAll();
            System.out.println(result);
            return ResponseHandler.generateResponse("Success",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK,clientServices.findById(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveClient(@RequestBody Cliente cliente){
        try {
            boolean email = clientServices.validateEmail(cliente.getEmail());
            if (email && cliente.getAge() > 0){
                return ResponseHandler.generateResponse("Succes",HttpStatus.OK,clientServices.saveClient(cliente));
            }else {
                return ResponseHandler.generateResponse("Error",HttpStatus.NOT_ACCEPTABLE,"Ingrese un correo valido (el correo no puede tener ñ) y verifique que la edad sea mayor a cero");
            }

        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> editClient(@PathVariable Integer id, @RequestBody Cliente cliente){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,clientServices.updateClient(id,cliente));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Integer id){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,clientServices.removeClient(id));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<Object> findByAge(@PathVariable int age){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,clientServices.findByAge(age));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> findByName(@PathVariable String name){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,clientServices.findByName(name));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Object> findByEmail(@PathVariable String email){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,clientServices.findByEmail(email));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }
}
