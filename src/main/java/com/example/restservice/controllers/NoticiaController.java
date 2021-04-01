package com.example.restservice.controllers;

import com.example.restservice.entity.Noticia;
import com.example.restservice.exception.ResourceNotFoundException;
import com.example.restservice.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import servicios.ImagenesServicio;

import java.io.IOException;


@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @GetMapping
    public Iterable<Noticia> getAllNoticias(){
        return this.noticiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Noticia getNoticiaById(@PathVariable("id") long noticiaID){
        return this.noticiaRepository.findById(noticiaID)
                .orElseThrow( () -> new ResourceNotFoundException("Noticia not found: " + noticiaID));
    }

    @PostMapping
    public Noticia createNoticia(@RequestBody Noticia Noticia){
        return this.noticiaRepository.save(Noticia);
    }

    @PutMapping("/{id}")
    public Noticia updateNoticia(@RequestBody Noticia Noticia, @PathVariable ("id") long NoticiaID){
        Noticia existingNoticia = this.noticiaRepository.findById(NoticiaID)
                .orElseThrow( () -> new ResourceNotFoundException("Noticia not found: " + NoticiaID));
        existingNoticia.setTitulo(Noticia.getTitulo());
        existingNoticia.setResumen(Noticia.getResumen());
        existingNoticia.setImagen(Noticia.getImagen());
        existingNoticia.setContenidoHTML(Noticia.getContenidoHTML());
        existingNoticia.setPublicada(Noticia.getPublicada());
        existingNoticia.setFechaPublicacion(Noticia.getFechaPublicacion());
        existingNoticia.setEmpresa(Noticia.getEmpresa());
        return this.noticiaRepository.save(existingNoticia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Noticia> deleteNoticia(@PathVariable ("id") long NoticiaID){
        Noticia existingNoticia = this.noticiaRepository.findById(NoticiaID)
                .orElseThrow( () -> new ResourceNotFoundException("Noticia not found: " + NoticiaID));
        this.noticiaRepository.delete(existingNoticia);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) { //imageFile viene de un <input type="file" name="imageFile"/> de un </form>
        String returnValue = "index"; //acá iria la página a donde retornaría una vez subida la imagen
        ImagenesServicio imagenesServicio = new ImagenesServicio();

        try {
            imagenesServicio.saveImage(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
            returnValue = "error";
        }

        return returnValue;
    }

}

