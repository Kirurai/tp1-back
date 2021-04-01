package com.example.restservice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.entity.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

}
