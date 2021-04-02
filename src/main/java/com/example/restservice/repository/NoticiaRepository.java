package com.example.restservice.repository;

import com.example.restservice.entity.Noticia;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends CrudRepository<Noticia , Long> {

    //Iterable<Noticia> findByTituloIsLikeOrResumenIsLike(String texto);
    //@Query("SELECT n FROM Noticia n WHERE n.titulo = :texto OR n.resumen = :texto") //@Query trabaja con JPQL...
    //https://www.baeldung.com/spring-data-jpa-modifying-annotation para ver como seria con SQL
    //@Query(value = "alter table USERS.USERS add column deleted int(1) not null default 0", nativeQuery = true)
    //void addDeletedColumn();
    //@Query("SELECT n FROM Noticia n WHERE n.titulo LIKE :texto OR n.resumen LIKE :texto")

    //Custom style
    @Modifying
    @Query("SELECT n FROM Noticia n WHERE n.titulo LIKE CONCAT('%',UPPER(:texto),'%') OR n.resumen LIKE CONCAT('%',UPPER(:texto),'%')") //case-insensitive
    Iterable<Noticia> findByTexto(@Param("texto") String texto);

    //CrudRepository style...no anda bien solo encuentra si el titulo conincide exactamente
    //Iterable<Noticia> findByTituloIsLikeOrResumenIsLike(String texto,String texto2);

}


