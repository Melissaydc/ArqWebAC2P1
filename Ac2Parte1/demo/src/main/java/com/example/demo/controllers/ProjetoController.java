package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dtos.DadosProjetoDTO;
import com.example.demo.dtos.ProjetoDTO;
import com.example.demo.services.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/adicionar")
    public void adicionarProjeto(@RequestBody ProjetoDTO projetoDTO) {
        projetoService.adicionar(projetoDTO);
    }

    @GetMapping("/{id}")
    public DadosProjetoDTO buscarProjetoPorId(@PathVariable Integer id) {
        return projetoService.buscarProjetoPorId(id);
    }

    @PostMapping("/{idProjeto}/vincular/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
    }
}
