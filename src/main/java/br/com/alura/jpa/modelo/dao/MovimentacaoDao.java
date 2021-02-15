package br.com.alura.jpa.modelo.dao;

import br.com.alura.jpa.modelo.MediaComData;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class MovimentacaoDao {
    private final EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }


    public List<MediaComData> getMediaDiariaDasMovimentacoes(){
        String jpql = "select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

        TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
        return query.getResultList();
    }

    public BigDecimal getSomaDasMovimentacoes(){
        //Soma dos valores
        String jpqlSum = "select sum(m.valor) from Movimentacao m";
        TypedQuery<BigDecimal> querySum = em.createQuery(jpqlSum, BigDecimal.class);
        return querySum.getSingleResult();


        //média dos valores
        //String jpqlAvg = "select avg(m.valor) from Movimentacao m";
        //TypedQuery<Double> queryAvg = em.createQuery(jpqlAvg, Double.class);
        //Double mediaDosValores = queryAvg.getSingleResult();
    }

}
