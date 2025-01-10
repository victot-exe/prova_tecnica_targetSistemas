package com.victot.provaTecnica.model;

public class DiaDoMes {
    int dia;
    Double valor;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "DiaDoMes{" +
                "dia=" + dia +
                ", valor=" + valor +
                '}';
    }
}
