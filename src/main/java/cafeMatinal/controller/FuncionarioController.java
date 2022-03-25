package cafeMatinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cafeMatinal.Service.FuncionarioService;
import cafeMatinal.model.Funcionario;
import cafeMatinal.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class FuncionarioController {

	private FuncionarioRepository funcionarioRepository ;
	private FuncionarioService funcionarioService;

	
	@GetMapping("/funcionarios")
	public List<Funcionario> listar(){
		return funcionarioRepository.findAll();
	}
	@PostMapping("/funcionarios/cadastrar")
	public Funcionario cadastrar(@RequestBody Funcionario funcionario) {
		Funcionario funcionarioNovo = funcionarioService.cadastrar(funcionario);
		return funcionarioNovo;
	}
}
