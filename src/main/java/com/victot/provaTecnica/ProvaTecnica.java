package com.victot.provaTecnica;

import com.victot.provaTecnica.model.DiaDoMes;
import com.victot.provaTecnica.model.EstadoDetalhado;
import com.victot.provaTecnica.service.LeitorJson;

import java.util.ArrayList;
import java.util.List;

public class ProvaTecnica {

    List<DiaDoMes> diasDoMes;

    public ProvaTecnica() {
        LeitorJson leitorJson = new LeitorJson();
        diasDoMes = new ArrayList<>();
        diasDoMes = leitorJson.lerJson("src/main/resources/dados.json");
    }

    public int questaoUm(int indice, int k){
        int soma = 0;

        while(k < indice){
            k++;
            soma += k;
        }
        System.out.printf("o valor da soma é: %d\n", soma);
        return soma;
    }

    public boolean questaoDois(int numero){

        ArrayList<Integer> fibonacci = geraFibonacci(numero);

        if(fibonacci.isEmpty()) {
            System.out.printf("O numero: %d não está na sequência\n", numero);
            return false;
        }

        if(fibonacci.contains(numero)) {
            System.out.printf("O numero: %d está na sequencia\n", numero);
            return true;
        }else {
            System.out.printf("O numero: %d não está na sequência\n", numero);
            return false;
        }
    }

    private ArrayList<Integer> geraFibonacci(int numero){
        ArrayList<Integer> fibonacci = new ArrayList<>();

        if (numero < 0) {
            return fibonacci;
        }

        int primeiro = 0, segundo = 1;

        fibonacci.add(primeiro);
        if (numero > 0) {
            fibonacci.add(segundo);
        }

        while (segundo <= numero) {
            int proximo = primeiro + segundo;
            fibonacci.add(proximo);
            primeiro = segundo;
            segundo = proximo;
        }

        return fibonacci;
    }

    public Double questaoTresRetornaOMenorFaturamento(List<DiaDoMes> diasDoMes){

        List<Double> valores = new ArrayList<>();
        valores = diasDoMes.stream().map(DiaDoMes::getValor).toList();

        double menorValor = valores.stream().filter(valor -> valor != 0).min(Double::compareTo).get();
        System.out.printf("O menor valor foi: %f\n", menorValor);

        return menorValor;
    }

    public Double questaoTresRetornaOMaiorFaturamento(List<DiaDoMes> diasDoMes){
        List<Double> valores = new ArrayList<>();
        valores = diasDoMes.stream().map(DiaDoMes::getValor).toList();
        double maiorValor=  valores.stream().max(Double::compareTo).get();

        System.out.printf("O maior valor foi: %f", maiorValor);

        return maiorValor;
    }

    public long questaoTresRetornaQuantosDiasAMediaFoiUltrapassada(List<DiaDoMes> diasDoMes){
        List<Double> valores = new ArrayList<>();
        valores = diasDoMes.stream().map(DiaDoMes::getValor).toList();

        if(valores.isEmpty())
            return 0;

        double media = valores.stream().mapToDouble(Double::doubleValue).filter(n -> n != 0)
                .average().orElse(0);

        long numeroDeDias = valores.stream().filter(valor -> valor > media).count();

        System.out.printf("O valor passou a media %d dias", numeroDeDias);

        return numeroDeDias;
    }


    public void questaoQuatro(List<EstadoDetalhado> estados){

        Double fatoramentoTotal = estados.stream().mapToDouble(EstadoDetalhado::getValor).sum();

        estados.forEach(estadoDetalhado ->
                estadoDetalhado.setRepresentacao((estadoDetalhado.getValor() / fatoramentoTotal) * 100));

        estados.forEach(System.out::println);
    }

    public String questaoCinco(String string){

        String stringInvertida = "";

        for(int i = string.length() - 1; i >= 0; i--){
            stringInvertida += string.charAt(i);
        }

        System.out.println(string + " -> " + stringInvertida);

        return stringInvertida;
    }
}
