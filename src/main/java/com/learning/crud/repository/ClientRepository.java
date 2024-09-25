package com.learning.crud.repository;


import com.learning.crud.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository< Client, Integer> {

}
