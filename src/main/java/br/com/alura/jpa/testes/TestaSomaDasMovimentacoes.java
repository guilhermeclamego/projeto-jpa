package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

public class TestaSomaDasMovimentacoes {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        //Soma dos valores
        String jpqlSum = "select sum(m.valor) from Movimentacao m";
        TypedQuery<BigDecimal> querySum = em.createQuery(jpqlSum, BigDecimal.class);
        BigDecimal somaDosValores = querySum.getSingleResult();
        System.out.println("Soma dos valores: " + somaDosValores);
        System.out.println("------------------------------------");

        //média dos valores
        String jpqlAvg = "select avg(m.valor) from Movimentacao m";
        TypedQuery<Double> queryAvg = em.createQuery(jpqlAvg, Double.class);
        Double mediaDosValores = queryAvg.getSingleResult();
        System.out.println("Média dos valores: " + mediaDosValores);
        System.out.println("------------------------------------");


    }






}
