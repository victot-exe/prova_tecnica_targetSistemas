package com.victot.provaTecnica.model;

public class EstadoDetalhado {

    private String estado;
    private Double valor;
    private Double representacao;

    public EstadoDetalhado(String estado, Double valor) {
        this.estado = estado;
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getRepresentacao() {
        return representacao;
    }
    public void setRepresentacao(Double representacao) {
        this.representacao = representacao;
    }

    @Override
    public String toString() {
        return "O estado " + estado + " teve o faturamento de R$ " + valor + "que representa " + representacao + " % do faturamento total.";
    }
}
