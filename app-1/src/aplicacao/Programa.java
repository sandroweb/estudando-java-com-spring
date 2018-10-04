package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		/* instancia o entity manager, responsavel pela conexão com o banco de dados */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		// Objeto buscado
		Pessoa p = em.find(Pessoa.class, 2);
		
		// Removendo do banco o objeto que eu acabei de buscar
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();

		System.out.println(p);
		
		em.close();
		emf.close();
	}

}
