package com.example.restservice.repository;

import com.example.restservice.entity.Noticia;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends CrudRepository<Noticia , Long> {

    /*Esta es la forma mas flexible. Pero dicen los foros que menos eficiente al usar expresiones regulares (RLIKE).
      probablemente tambien mas insegura al usar una sentencia/query en forma de texto
    */
    @Modifying
    @Query(nativeQuery = true, value="SELECT noticia.* FROM noticia WHERE noticia.titulo RLIKE :texto OR noticia.resumen RLIKE :texto")
    Iterable<Noticia> findByTexto(@Param("texto") String texto);

    //CrudRepository style...no anda bien solo encuentra si el titulo conincide exactamente
    //Iterable<Noticia> findByTituloIsLikeOrResumenIsLike(String texto,String texto2);
    //@Query("SELECT room FROM Room room WHERE room.id IN (:roomIDList)")
    //List<Room> recoverDeletedRoom( @Param("roomIDList") List<String> roomIDList);
    //Iterable<Noticia> findByTituloIsLikeOrResumenIsLike(String texto);
    //@Query("SELECT n FROM Noticia n WHERE n.titulo = :texto OR n.resumen = :texto") //@Query trabaja con JPQL...
    //https://www.baeldung.com/spring-data-jpa-modifying-annotation para ver como seria con SQL
    //@Query(value = "alter table USERS.USERS add column deleted int(1) not null default 0", nativeQuery = true)
    //void addDeletedColumn();
    //@Query("SELECT n FROM Noticia n WHERE n.titulo LIKE :texto OR n.resumen LIKE :texto")
    //@Query("SELECT n FROM Noticia n WHERE n.titulo LIKE CONCAT('%',UPPER(:texto),'%') OR n.resumen LIKE CONCAT('%',UPPER(:texto),'%') ORDER BY n.fechaPublicacion DESC") //case-insensitive
    //@Query("SELECT n FROM Noticia n WHERE (n.titulo LIKE (:texto)) OR (n.resumen LIKE (:texto)) ORDER BY n.fechaPublicacion DESC") //case-insensitive

}


