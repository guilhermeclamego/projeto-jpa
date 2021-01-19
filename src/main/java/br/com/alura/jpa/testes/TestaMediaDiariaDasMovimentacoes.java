package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.MediaComData;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class TestaMediaDiariaDasMovimentacoes {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        String jpql = "select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

        TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);

        /**
         * Utilizado Array de Object, para tratar os dados do tipo mais genérico.
         * Pois, irá retornar o valor(double), dia(int) e mes(int).
         * Para obter o resultado no for, basta acessar a posição do array.
         */
        /*List<Object[]> mediaDasMovimentacoes = query.getResultList();
        mediaDasMovimentacoes.forEach(mov -> {
            System.out.println("A média das movimentações: " + mov[1] + "/" + mov[2] + " é: " + mov[0]);
        });*/

        /**
         * Agora da maneira mais correta, criando uma classe com a MediaComData e declarando new no jpql e usando TypedQuery
         */
        List<MediaComData> mediaDasMovimentacoes = query.getResultList();
        mediaDasMovimentacoes.forEach(mov -> {
            System.out.println("A média das movimentações: " + mov.getDia() + "/" + mov.getMes() + " é: " + mov.getValor());
        });
    }
}
