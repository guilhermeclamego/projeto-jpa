package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {
		
		// Transient
		Conta conta = new Conta();
		conta.setTitular("Ragnar");
		conta.setAgencia(4343);
		conta.setNumero(12312);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		// Transient -> Manager (Sincronização automática com o banco
		em.persist(conta); //inserir
		
		// Managed -> remove
		em.remove(conta);  //deletar
		
		em.getTransaction().commit();
	}
}
