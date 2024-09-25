package com.learning.crud;

import com.learning.crud.model.Client;
import com.learning.crud.model.Phone;
import com.learning.crud.repository.ClientRepository;
import com.learning.crud.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;


@SpringBootApplication
public class CrudApplication {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private PhoneRepository phoneRepository;


	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner( ApplicationContext ctx) {

		return args -> {

			// Inserindo alguns clientes e telefones
			Client client1 = new Client();
			client1.setName("João Silva");
			client1.setCpf("12345678901");
			client1.setDateOfAge(new Date());
			client1.setEmail("joao.silva@example.com");

			Phone phone1 = new Phone();
			phone1.setNumber("11987654321");
			phone1.setType("Celular");
			phone1.setClient(client1);

			Phone phone2 = new Phone();
			phone2.setNumber("1134567890");
			phone2.setType("Residencial");
			phone2.setClient(client1);

			client1.setPhones( Arrays.asList(phone1, phone2));

			clientRepository.save(client1);

			// Inserindo outro cliente
			Client client2 = new Client();
			client2.setName("Maria Oliveira");
			client2.setCpf("10987654321");
			client2.setDateOfAge(new Date());
			client2.setEmail("maria.oliveira@example.com");

			Phone phone3 = new Phone();
			phone3.setNumber("21987654321");
			phone3.setType("Celular");
			phone3.setClient(client2);

			client2.setPhones(Arrays.asList(phone3));

			clientRepository.save(client2);

			System.out.println("Dados iniciais inseridos com sucesso!");

		};
	}

}
