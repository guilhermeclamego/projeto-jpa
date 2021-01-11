package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Márcia");
		conta.setNumero(1253);
		conta.setAgencia(11484);
		conta.setSaldo(100.00);

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println("ID da Conta da Márcia: " + conta.getId());
		conta.setSaldo(500.00);
		
		em2.getTransaction().begin();
		em2.merge(conta); //Merge irá pegar um detached (já foi commitado e dado close na transação) e a torna Managed novamente 
		em2.getTransaction().commit();
		
	}
}
