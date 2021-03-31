package com.example.restservice.controllers;

import com.example.restservice.entity.Empresa;
import com.example.restservice.exception.ResourceNotFoundException;
import com.example.restservice.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    public List<Empresa> getAllEmpresas(){
        return this.empresaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Empresa getEmpresaById(@PathVariable ("id") long empresaID){
        return this.empresaRepository.findById(empresaID)
                .orElseThrow( () -> new ResourceNotFoundException("Empresa not found: " + empresaID));
    }

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return this.empresaRepository.save(empresa);
    }

    @PutMapping("/{id}")
    public Empresa updateEmpresa(@RequestBody Empresa empresa, @PathVariable ("id") long empresaID){
        Empresa existingEmpresa = this.empresaRepository.findById(empresaID)
                .orElseThrow( () -> new ResourceNotFoundException("Empresa not found: " + empresaID));
        existingEmpresa.setDenominacion(empresa.getDenominacion());
        existingEmpresa.setDomicilio(empresa.getDomicilio());
        existingEmpresa.setEmail(empresa.getEmail());
        existingEmpresa.setLatitud(empresa.getLatitud());
        existingEmpresa.setLongitud(empresa.getLongitud());
        existingEmpresa.setNoticias(empresa.getNoticias());
        existingEmpresa.setHorarioDeAtencion(empresa.getHorarioDeAtencion());
        existingEmpresa.setTelefono(empresa.getTelefono());
        return this.empresaRepository.save(existingEmpresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> deleteEmpresa(@PathVariable ("id") long empresaID){
        Empresa existingEmpresa = this.empresaRepository.findById(empresaID)
                .orElseThrow( () -> new ResourceNotFoundException("Empresa not found: " + empresaID));
        this.empresaRepository.delete(existingEmpresa);
        return ResponseEntity.ok().build();
    }
}