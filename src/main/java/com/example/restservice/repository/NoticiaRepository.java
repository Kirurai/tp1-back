package com.example.restservice.repository;

import com.example.restservice.entity.Noticia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends CrudRepository<Noticia , Long> {

}
