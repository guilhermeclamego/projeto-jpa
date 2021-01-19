package br.com.alura.jpa.testes;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class TestaMediaDiariaDasMovimentacoes {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        String jpql = "select avg(m.valor), day(m.data), month(m.data) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

        Query query = em.createQuery(jpql);

        /**
         * Utilizado Array de Object, para tratar os dados do tipo mais genérico.
         * Pois, irá retornar o valor(double), dia(int) e mes(int).
         * Para obter o resultado no for, basta acessar a posição do array.
         */
        List<Object[]> mediaDasMovimentacoes = query.getResultList();
        mediaDasMovimentacoes.forEach(mov -> {
            System.out.println("A média das movimentações: " + mov[1] + "/" + mov[2] + " é: " + mov[0]);
        });

    }
}
