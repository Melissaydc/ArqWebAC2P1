package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProjetoDTO {
    private Long id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Integer> funcionariosIds;
}
