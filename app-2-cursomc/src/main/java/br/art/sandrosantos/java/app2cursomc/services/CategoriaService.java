package br.art.sandrosantos.java.app2cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.art.sandrosantos.java.app2cursomc.domain.Categoria;
import br.art.sandrosantos.java.app2cursomc.repositories.CategoriaRepository;
import br.art.sandrosantos.java.app2cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));		
	}

}
