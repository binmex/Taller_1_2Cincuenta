package org.example.demo2.services;

import org.example.demo2.entities.Cliente;
import org.example.demo2.entities.Factura;
import org.example.demo2.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientServices {
    @Autowired
    ClienteRepository clientRepository;
    public List<Cliente> findAll(){
        return clientRepository.findAll();
    }

    public Cliente findById(Integer id){
        Optional<Cliente> optional = clientRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }
    public Cliente saveClient(Cliente newClient){
        clientRepository.save(newClient);
        return newClient;
    }

    public boolean removeClient(Integer id){
        clientRepository.delete(findById(id));
        return true;
    }
    public boolean updateClient(Integer id,Cliente client){
        Cliente findClient = findById(id);
        if (findClient != null){
            findClient.setAge(client.getAge());
            findClient.setName(client.getName());
            findClient.setLastName(client.getLastName());
            findClient.setEmail(client.getEmail());
            clientRepository.save(findClient);
            return true;
        }else {
            return false;
        }
    }
    public List<Cliente> findByAge(int age){
        return clientRepository.findByAge(age);
    }

    public List<Cliente> findByName(String name){
        return clientRepository.findByName(name);
    }

    public  List<Cliente> findByEmail(String email){
        return clientRepository.findByEmail(email);
    }

    public List<Factura> getFacture(Cliente cliente){
        return cliente.getFactures();
    }

    public boolean validateEmail(String correo) {
        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}

