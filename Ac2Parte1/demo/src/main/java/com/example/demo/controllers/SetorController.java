package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dtos.DadosSetorDTO;
import com.example.demo.dtos.SetorDTO;
import com.example.demo.services.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {
    @Autowired
    private SetorService setorService;

    @PostMapping("/adicionar")
    public void adicionarSetor(@RequestBody SetorDTO setorDTO) {
        setorService.adicionar(setorDTO);
    }

    @GetMapping("/{id}")
    public DadosSetorDTO buscarSetorPorId(@PathVariable("id") Integer idSetor) {
        return setorService.buscarSetorPorId(idSetor);
    }
}
