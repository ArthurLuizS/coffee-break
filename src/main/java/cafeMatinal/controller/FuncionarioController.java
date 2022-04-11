package cafeMatinal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cafeMatinal.Service.FuncionarioService;
import cafeMatinal.model.Funcionario;
import cafeMatinal.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin
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
	@PutMapping("funcionarios/atualizar/{IdFuncionario}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long IdFuncionario,
			@RequestBody Funcionario funcionario) {
		if(!funcionarioRepository.existsById(IdFuncionario)) {
			return ResponseEntity.notFound().build();
		}
		funcionario.setId(IdFuncionario);
		funcionarioService.cadastrar(funcionario);
		
		return ResponseEntity.ok(funcionario);
	}
	@DeleteMapping("funcionarios/{IdFuncionario}")
	public ResponseEntity<Funcionario> excluir(@PathVariable Long IdFuncionario){
		if(!funcionarioRepository.existsById(IdFuncionario)) {
			return ResponseEntity.notFound().build();
		}
		funcionarioRepository.deleteById(IdFuncionario);
		return ResponseEntity.noContent().build();
	}

}
