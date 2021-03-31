package com.example.restservice.controllers;

import com.example.restservice.repository.EmpresaRepository;
import com.example.restservice.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="main")
public class MainController {
    @Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String denominacion, @RequestParam String email){
        Empresa emp = new Empresa();
        emp.setDenominacion(denominacion);
        empresaRepository.save(emp);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Empresa> getAllUsers(){
        return empresaRepository.findAll();
    }
}
