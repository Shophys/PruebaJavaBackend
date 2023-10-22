package com.bolsadeideas.springboot.pruebapractica.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.pruebapractica.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
