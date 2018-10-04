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
		
		Pessoa p1 = new Pessoa(null, "Sandro Santos", "sandro@sandrosantos.art.br");
		Pessoa p2 = new Pessoa(null, "Mariana Pantoja", "mary@gmail.com");
		Pessoa p3 = new Pessoa(null, "Maria Helena", "mudramail@gmail.com");
		
		/* grava dados */
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		em.close();
		emf.close();

		System.out.println("Pronto!");
	}

}
