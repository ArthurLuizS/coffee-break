package cafeMatinal.Service;

import org.springframework.stereotype.Service;

import cafeMatinal.model.Funcionario;
import cafeMatinal.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {
	
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario cadastrar(Funcionario funcionario) {
		Funcionario novoFuncionario = new Funcionario();
		Long y = jaTem(funcionario);
		if(y == 0L) {
		novoFuncionario	= funcionarioRepository.save(funcionario);
		}
		
		return novoFuncionario;
		}

	private Long jaTem(Funcionario funcionario) {
		Long x = 1L;
		Long y = 0L;
		while( x <= funcionarioRepository.count()) {
			if(funcionario.getAlimento().contentEquals(funcionarioRepository.getById(x).getAlimento())  ) {
				y = x;
				x = funcionarioRepository.count() + 1L;
			}else {
				x++;
				
			}
		}
		
		return y;
	}
	
	
	}