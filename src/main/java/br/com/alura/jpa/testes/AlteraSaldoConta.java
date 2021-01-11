package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		//buscando a conta com ID 1 para alterar
		Conta conta = em.find(Conta.class, 2L);
		
		System.out.println("Conta do ID: " + conta.getId() + " titular: " + conta.getTitular());
		
		em.getTransaction().begin();
		conta.setSaldo(2080.00);
		em.getTransaction().commit();
	}
}
