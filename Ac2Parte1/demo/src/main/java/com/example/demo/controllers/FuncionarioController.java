package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dtos.DadosProjetoDTO;
import com.example.demo.dtos.FuncionarioDTO;
import com.example.demo.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/adicionar")
    public void adicionarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.adicionar(funcionarioDTO);
    }

    @GetMapping("/{id}/projetos")
    public List<DadosProjetoDTO> buscarProjetos(@PathVariable("id") Integer idFuncionario) {
        return funcionarioService.buscarProjetos(idFuncionario);
    }
}
