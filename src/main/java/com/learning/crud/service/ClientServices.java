package com.learning.crud.service;


import com.learning.crud.model.Client;
import com.learning.crud.model.Phone;
import com.learning.crud.repository.ClientRepository;
import com.learning.crud.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    public Client findClientById( Integer id){
        return clientRepository.findById( id ).get();
    }

    public List< Phone >  findPhoneList (Client client){
        return phoneRepository.findPhoneList( client.getName(), client.getCpf());
    }

    public void saveClient( Client client){
       clientRepository.save( client );
    }

    public void deleteClient( Integer id){
        clientRepository.deleteById( id );
    }

    public List< Client > findAllClients(){
        return clientRepository.findAll();
    }

    public Client updateClient( Client client){
        Client clientUpdate = clientRepository.findById( client.getId() ).get();
        clientUpdate.setName( client.getName() );
        clientUpdate.setCpf( client.getCpf() );
        clientUpdate.setEmail( client.getEmail() );
        clientUpdate.setPhones( client.getPhones() );
        return clientRepository.save( client );
    }




}
