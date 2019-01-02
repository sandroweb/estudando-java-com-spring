package br.art.sandrosantos.java.app2cursomc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.art.sandrosantos.java.app2cursomc.domain.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

	Optional<ItemPedido> findById(Integer id);
	

}
