package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Projeto;


public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{
    List<Projeto> findByDataInicioBetween(LocalDate startDate, LocalDate endDate);
    List<Projeto> findByFuncionariosId(Integer funcionarioId);
}
