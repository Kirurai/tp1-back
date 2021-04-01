package com.example.restservice.entity;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(name = "empresa")
@Getter @Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominacion", length = 128)
    private String denominacion;

    @Column(name = "telefono", length = 50)
    private String telefono;

    @Column(name = "horario_de_atencion", length = 256)
    private String horarioDeAtencion;

    @Column(name = "quienes_somos", length = 1024)
    private String quienesSomos;

    @Column(name = "latitud")
    private double latitud;

    @Column(name = "longitud")
    private double longitud;

    @Column(name = "domicilio", length = 256)
    private String domicilio;

    @Column(name = "email", length = 75)
    private String email;

    //@OneToMany(mappedBy = "empresa")
    //private List<Noticia> noticias = new ArrayList<>();

    public Empresa() {
    }

    public Empresa(String denominacion, String telefono, String horarioDeAtencion, String quienesSomos, double latitud, double longitud, String domicilio, String email) {
        this.denominacion = denominacion;
        this.telefono = telefono;
        this.horarioDeAtencion = horarioDeAtencion;
        this.quienesSomos = quienesSomos;
        this.latitud = latitud;
        this.longitud = longitud;
        this.domicilio = domicilio;
        this.email = email;
    }
}
