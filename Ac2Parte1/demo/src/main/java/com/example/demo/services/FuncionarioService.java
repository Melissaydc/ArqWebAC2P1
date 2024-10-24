package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.DadosProjetoDTO;
import com.example.demo.dtos.FuncionarioDTO;
import com.example.demo.models.Funcionario;
import com.example.demo.repositories.FuncionarioRepository;
import com.example.demo.repositories.ProjetoRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    public void adicionar(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDTO.getNome());
        funcionarioRepository.save(funcionario);
    }

    public List<DadosProjetoDTO> buscarProjetos(Integer idFuncionario) {
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElse(null);
        if (funcionario == null)
            return null;

        return projetoRepository.findByFuncionariosId(idFuncionario).stream().map(projeto -> {
            DadosProjetoDTO dadosProjetoDTO = new DadosProjetoDTO();
            dadosProjetoDTO.setId(projeto.getId());
            dadosProjetoDTO.setDescricao(projeto.getDescricao());
            dadosProjetoDTO.setDataInicio(projeto.getDataInicio());
            dadosProjetoDTO.setDataFim(projeto.getDataFim());
            dadosProjetoDTO.setFuncionariosNomes(
                    projeto.getFuncionarios().stream().map(Funcionario::getNome).collect(Collectors.toList()));
            return dadosProjetoDTO;
        }).collect(Collectors.toList());
    }
}

