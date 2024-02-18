package org.example.demo2.services;

import org.example.demo2.entities.Cliente;
import org.example.demo2.entities.Factura;
import org.example.demo2.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureServices {
    @Autowired
    FactureRepository factureRepository;

    public List<Factura> findAll(){
        return factureRepository.findAll();
    }

    public Factura save(Factura facture, Cliente cliente){
        facture.setClient(cliente);
        return factureRepository.save(facture);
    }

    public Factura findById(Integer id){
        Optional<Factura> optional = factureRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public boolean updateFacture(Integer id,Factura facture){
        Factura findFactura = findById(id);
        if (findFactura != null){
            findFactura.setDate_of_issuance(facture.getDate_of_issuance());
            findFactura.setState(facture.getState());
            factureRepository.save(findFactura);
            return true;
        }else {
            return false;
        }
    }

    public boolean removeFacture(Integer id){
        factureRepository.delete(findById(id));
        return true;
    }

    public Object factureAllInformation(){
        return factureRepository.findFactuteAllInformation();
    }

}
