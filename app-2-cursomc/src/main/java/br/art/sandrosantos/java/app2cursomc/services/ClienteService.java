package br.art.sandrosantos.java.app2cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.art.sandrosantos.java.app2cursomc.domain.Cliente;
import br.art.sandrosantos.java.app2cursomc.repositories.ClienteRepository;
import br.art.sandrosantos.java.app2cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));		
	}

}
