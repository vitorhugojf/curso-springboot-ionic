package com.example.demo.services;

import com.example.demo.domain.Pedido;
import com.example.demo.extras.ObjectNotFoundException;
import com.example.demo.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscar(Integer id){
        return pedidoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não existe nenhum pedido com o Id " + id + " na base de dados."));
    }
}
