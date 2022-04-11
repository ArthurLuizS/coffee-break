package cafeMatinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cafeMatinal.model.Funcionario;
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	boolean existsFuncionarioByAlimento(String alimento);
	Optional<Funcionario>findByAlimento(String alimento);
}
