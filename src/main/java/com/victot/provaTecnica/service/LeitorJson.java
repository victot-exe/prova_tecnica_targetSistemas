package com.victot.provaTecnica.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.victot.provaTecnica.model.DiaDoMes;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LeitorJson {

    public List<DiaDoMes> lerJson(String path){
        ObjectMapper mapper = new ObjectMapper();

        try{
            List<DiaDoMes> diasDoMes = mapper.readValue(new File(path), new TypeReference<List<DiaDoMes>>(){});
            return diasDoMes;
        }catch(IOException e){
            e.printStackTrace();
        }
        throw new RuntimeException("Erro na leitura do JSON");
    }
}
