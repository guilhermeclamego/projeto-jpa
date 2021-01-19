package br.com.alura.jpa.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private Integer agencia;
    private Integer numero;
    private String titular;
    private Double saldo;
    //fetch.EAGER, executar primeiro o sql de movimentações, depois as contas, porém isso não é escalável
    @OneToMany(mappedBy = "conta", fetch = FetchType.EAGER)
    private List<Movimentacao> movimentacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Movimentacao> getMovimentacoes(){
        return movimentacoes;
    }
}
