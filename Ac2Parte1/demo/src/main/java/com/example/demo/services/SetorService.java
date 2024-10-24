package com.example.demo.services;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import com.example.demo.dtos.DadosSetorDTO;
import com.example.demo.dtos.SetorDTO;
import com.example.demo.models.Funcionario;
import com.example.demo.models.Setor;
import com.example.demo.repositories.SetorRepository;

@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    public void adicionar(SetorDTO setorDTO) {
        Setor setor = new Setor();
        setor.setNome(setorDTO.getNome());
        setorRepository.save(setor);
    }

    public DadosSetorDTO buscarSetorPorId(Integer idSetor) {
        Setor setor = setorRepository.findById(idSetor).orElse(null);
        if (setor == null)
            return null;

        DadosSetorDTO dadosSetorDTO = new DadosSetorDTO();
        dadosSetorDTO.setId(setor.getId());
        dadosSetorDTO.setNome(setor.getNome());
        dadosSetorDTO.setFuncionariosNomes(
                setor.getFuncionarios().stream().map(Funcionario::getNome).collect(Collectors.toList()));

        return dadosSetorDTO;
    }
}
