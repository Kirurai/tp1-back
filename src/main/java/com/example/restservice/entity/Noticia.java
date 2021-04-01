package com.example.restservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "noticia")
@Getter @Setter
public class Noticia{
//public class Noticia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo", length = 128)
    private String titulo;

    @Column(name = "resumen", length = 1024)
    private String resumen;

    @Column(name = "imagen", length = 128)
    private String imagen;

    @Column(name = "contenido_HTML", length = 20480)
    private String contenidoHTML;

    @Column(name = "publicada")
    private char publicada;

    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;

    @ManyToOne(cascade = CascadeType.PERSIST) //si se borra la noticia, no se borra la empresa
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Noticia(){

    }
    public Noticia(String titulo, String resumen, String imagen, String contenidoHTML, char publicada, Date fechaPublicacion, Empresa empresa) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.imagen = imagen;
        this.contenidoHTML = contenidoHTML;
        this.publicada = publicada;
        this.fechaPublicacion = fechaPublicacion;
        this.empresa = empresa;
    }

}
