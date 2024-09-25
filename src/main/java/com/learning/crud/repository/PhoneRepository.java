package com.learning.crud.repository;


import com.learning.crud.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PhoneRepository  extends JpaRepository< Phone, Integer>{

    @Query("SELECT p FROM Phone p WHERE p.client.name = ?1 OR p.client.cpf = ?2")
    public List< Phone > findPhoneList (String nameClient, String cpfClient);

}