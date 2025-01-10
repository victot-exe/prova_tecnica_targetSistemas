package com.victot.provaTecnica;


import com.victot.provaTecnica.model.DiaDoMes;
import com.victot.provaTecnica.model.EstadoDetalhado;
import com.victot.provaTecnica.service.LeitorJson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProvaTecnicaTest {
    ProvaTecnica provaTecnica = new ProvaTecnica();

    private static List<DiaDoMes> diasDoMes;

    @BeforeAll
    static void setUp(){
        LeitorJson leitorJson = new LeitorJson();
        diasDoMes = new ArrayList<>();
        diasDoMes = leitorJson.lerJson("src/main/resources/dados.json");
    }

    @Test
    public void teste_da_questaoUm(){
        int result = provaTecnica.questaoUm(13, 0);
        assertEquals(91, result);
    }

    @Test
    @DisplayName("Questao dois: deve retornar verdadeiro / falso / verdadeiro")
    public void teste_da_questaoDois(){
        assertTrue(provaTecnica.questaoDois(34));
        assertFalse(provaTecnica.questaoDois(105));
        assertTrue(provaTecnica.questaoDois(233));
    }

    @Test
    @DisplayName("Retorna o menor valor do mês")
    public void teste_questaoTresRetornaOMenorFaturamento(){
        assertEquals(373.7838, provaTecnica.questaoTresRetornaOMenorFaturamento(diasDoMes));
    }

    @Test
    @DisplayName("Retorna o maior valor do mês")
    public void teste_questaoTresRetornaOMaiorFaturamento(){
        assertEquals(48924.2448, provaTecnica.questaoTresRetornaOMaiorFaturamento(diasDoMes));
    }

    @Test
    @DisplayName("Retorna o numero de dias que o valor foi maior que a media")
    public void teste_questaoTresRetornaQuantosDiasAMediaFoiUltrapassada(){
        assertEquals(10L, provaTecnica.questaoTresRetornaQuantosDiasAMediaFoiUltrapassada(diasDoMes));
    }

    @Test
    public void teste_questaoQuatro(){
        List<EstadoDetalhado> estadoDetalhados = new ArrayList<>();
        estadoDetalhados.add(new EstadoDetalhado("SP", 67836.43));
        estadoDetalhados.add(new EstadoDetalhado("RJ", 36678.66));
        estadoDetalhados.add(new EstadoDetalhado("MG", 29229.88));
        estadoDetalhados.add(new EstadoDetalhado("ES", 27165.48));
        estadoDetalhados.add(new EstadoDetalhado("Outros", 19849.53));
        provaTecnica.questaoQuatro(estadoDetalhados);
    }

    @Test
    @DisplayName("Deve inverter as strings |String| |Victor| |Ola|")
    public void teste_questaoCinco(){
        StringBuffer sb = new StringBuffer("String");
        assertEquals(sb.reverse().toString(), provaTecnica.questaoCinco("String"));
        sb = new StringBuffer("Victor");
        assertEquals(sb.reverse().toString(), provaTecnica.questaoCinco("Victor"));
        sb = new StringBuffer("Ola");
        assertEquals(sb.reverse().toString(), provaTecnica.questaoCinco("Ola"));
    }
}
