package com.example.demo.models;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
@Getter
@Setter
@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    @ManyToMany
    private List<Funcionario> funcionarios;

}

