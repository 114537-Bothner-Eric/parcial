package ar.edu.utn.frc.tup.lciii.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.edu.utn.frc.tup.lciii.models.Barrio;
import ar.edu.utn.frc.tup.lciii.models.Equipo;
import ar.edu.utn.frc.tup.lciii.models.Resultado;

@Service
public class RestClient {
    
    @Autowired
    private RestTemplate restTemplate;


    public List<Equipo> getTeams() {
        Equipo[] teams = restTemplate.getForObject("http://servidor-fut:8081/equipos", Equipo[].class);
        return Arrays.asList(teams);
    }

    public List<Barrio> getBarrios(){
        Barrio[] barrios = restTemplate.getForObject("http://servidor-fut:8081/barrios", Barrio[].class);
        return Arrays.asList(barrios);
    }
    
    public List<Resultado> getResultados(){
        Resultado[] resultados = restTemplate.getForObject("http://servidor-fut:8081/resultados", Resultado[].class);
        return Arrays.asList(resultados);
    }
}
