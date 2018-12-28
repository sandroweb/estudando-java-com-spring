package br.art.sandrosantos.java.app2cursomc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.art.sandrosantos.java.app2cursomc.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

	Optional<Pagamento> findById(Integer id);
	

}
