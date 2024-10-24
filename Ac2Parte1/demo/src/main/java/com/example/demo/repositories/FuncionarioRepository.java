package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
}
