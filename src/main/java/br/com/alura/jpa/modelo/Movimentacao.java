package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao; // enum
    private LocalDateTime data;
    private String descricao;
    private BigDecimal valor;

    @ManyToMany
    private List<Categoria> categorias;

    @ManyToOne
    private Conta conta;

    public Integer getId() {
    	return id;
    }

    public void setId(Integer id) {
    	this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
    	this.valor = valor;
    }

    public TipoMovimentacao getTipoMovimentacao() {
    	return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
    	this.tipoMovimentacao = tipoMovimentacao;
    }

    public LocalDateTime getData() {
    	return data;
    }

    public void setData(LocalDateTime data) {
    	this.data = data;
    }

    public String getDescricao() {
    	return descricao;
    }

    public void setDescricao(String descricao) {
    	this.descricao = descricao;
    }

    public Conta getConta() {
    	return conta;
    }

    public void setConta(Conta conta) {
    	this.conta = conta;
    }

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
