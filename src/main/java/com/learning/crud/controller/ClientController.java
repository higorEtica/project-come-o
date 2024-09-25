package com.learning.crud.controller;


import com.learning.crud.model.Client;
import com.learning.crud.service.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientServices clientServices;

    @GetMapping
    public ResponseEntity< List< Client > > findAllClients(){
        return ResponseEntity.ok().body( clientServices.findAllClients() );
    }

    @GetMapping("/{id}")
    public ResponseEntity< Client > findClientById (@PathVariable Integer id) {

        return ResponseEntity.ok().body( clientServices.findClientById( id ) );
    }

    @PostMapping
    public void saveClient(@RequestBody Client client){

        System.out.println("Salvo com sucesso!");
        clientServices.saveClient( client );
    }

    @PutMapping("/{id}")
    public ResponseEntity< Client > updateClient(@PathVariable Integer id, @RequestBody Client client){
        client.setId( id );
        return ResponseEntity.ok().body( clientServices.updateClient( client ) );
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id){
        clientServices.deleteClient( id );
    }

}
