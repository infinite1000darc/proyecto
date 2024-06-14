package com.tuempresa.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public Compra recibirCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    public boolean cancelarCompra(Long id) {
        Optional<Compra> compra = compraRepository.findById(id);
        if (compra.isPresent()) {
            compraRepository.delete(compra.get());
            return true;
        } else {
            return false;
        }
    }

    public Optional<Compra> estadoCompra(Long id) {
        return compraRepository.findById(id);
    }
}

