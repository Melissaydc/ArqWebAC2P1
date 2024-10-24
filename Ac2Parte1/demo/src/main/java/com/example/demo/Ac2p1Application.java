package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.models.Funcionario;
import com.example.demo.models.Projeto;
import com.example.demo.models.Setor;
import com.example.demo.repositories.FuncionarioRepository;
import com.example.demo.repositories.ProjetoRepository;
import com.example.demo.repositories.SetorRepository;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Ac2p1Application {
	public static void main(String[] args) {
		SpringApplication.run(Ac2p1Application.class, args);
	}

	@Bean
	CommandLineRunner initData(FuncionarioRepository funcionarioRepository, ProjetoRepository projetoRepository,
			SetorRepository setorRepository) {
		return args -> {

			Setor setor1 = Setor.builder().nome("Pesquisa e Desenvolvimento").build();
			Setor setor2 = Setor.builder().nome("Financeiro").build();
			Setor setor3 = Setor.builder().nome("Marketing").build();
			setorRepository.saveAll(List.of(setor1, setor2, setor3));

			Funcionario func1 = Funcionario.builder().nome("Melissa").setor(setor1).build();
			Funcionario func2 = Funcionario.builder().nome("Nathan").setor(setor2).build();
			Funcionario func3 = Funcionario.builder().nome("Cauê").setor(setor3).build();
			funcionarioRepository.saveAll(List.of(func1, func2, func3));

			Projeto projeto1 = Projeto.builder()
					.descricao("Projeto 1")
					.dataInicio(LocalDate.now())
					.dataFim(LocalDate.now().plusMonths(6))
					.funcionarios(List.of(func1, func2))
					.build();

			Projeto projeto2 = Projeto.builder()
					.descricao("Projeto 2")
					.dataInicio(LocalDate.now())
					.dataFim(LocalDate.now().plusMonths(12))
					.funcionarios(List.of(func2, func3))
					.build();

			Projeto projeto3 = Projeto.builder()
					.descricao("Projeto 3")
					.dataInicio(LocalDate.now())
					.dataFim(LocalDate.now().plusMonths(3))
					.funcionarios(List.of(func1, func3))
					.build();

			projetoRepository.saveAll(List.of(projeto1, projeto2, projeto3));
		};
	}
}
