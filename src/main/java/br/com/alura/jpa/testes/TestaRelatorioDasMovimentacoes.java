package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TestaRelatorioDasMovimentacoes {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        /**
         * Trazer as movimentações junto na consulta da Conta, usando o left join fetch.
         * Se não, iria consultas as contas e depois as movimentações, tornando o projeto não escalável.
         * Lembrar, que na classe conta foi necessário adicionar FetchType
        */
        String jpql = "select c from Conta c left join fetch c.movimentacoes";
        TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);

        List<Conta> contas = query.getResultList();

        contas.forEach( conta -> {
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Agência: " + conta.getAgencia());
            System.out.println("Número: " + conta.getNumero());
            System.out.println("Movimentações: " + conta.getMovimentacoes());
        });
    }
}
