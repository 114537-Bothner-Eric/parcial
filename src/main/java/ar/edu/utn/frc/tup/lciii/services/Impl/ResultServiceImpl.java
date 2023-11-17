package ar.edu.utn.frc.tup.lciii.services.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.utn.frc.tup.lciii.dtos.common.BarrioResponse;
import ar.edu.utn.frc.tup.lciii.dtos.common.EquipoBarrio;
import ar.edu.utn.frc.tup.lciii.dtos.common.EquipoResponse;
import ar.edu.utn.frc.tup.lciii.models.Barrio;
import ar.edu.utn.frc.tup.lciii.models.Equipo;
import ar.edu.utn.frc.tup.lciii.models.Resultado;
import ar.edu.utn.frc.tup.lciii.rest.RestClient;
import ar.edu.utn.frc.tup.lciii.services.ResultService;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private RestClient restClient;

    @Override
    public List<EquipoResponse> getData() {
        List<Equipo> equipos = restClient.getTeams();
        List<Resultado> resultados = restClient.getResultados();
        Integer totalInchas = 0;

        Map<Long, EquipoResponse> map = new HashMap<>();

        for (Resultado resultado : resultados) {
            EquipoResponse equipoResponse = map.get(resultado.getEquipoId());

            if (equipoResponse == null) {
                equipoResponse = new EquipoResponse();
                equipoResponse.setNombre((equipos.get(resultado.getEquipoId().intValue() - 1).getNombre()));
                equipoResponse.setHinchas(0);
                equipoResponse.setPorcentajeHinchas(0.0);
                map.put(resultado.getEquipoId(), equipoResponse);
            }

            equipoResponse.setHinchas(equipoResponse.getHinchas() + resultado.getVotos());
            totalInchas += resultado.getVotos();
        }

        for (EquipoResponse eq : map.values()) {
            // fix this values to 2 decimals
            eq.setPorcentajeHinchas((eq.getHinchas().doubleValue() / totalInchas.doubleValue()) * 100);
            eq.setPorcentajeHinchas(Math.round(eq.getPorcentajeHinchas() * 100.0) / 100.0);
        }

        return map.values().stream().toList();
    }

    @Override
    public List<BarrioResponse> getDataBarrios() {
        List<Equipo> equipos = restClient.getTeams();
        List<Barrio> barrios = restClient.getBarrios();
        List<Resultado> resultados = restClient.getResultados();
        List<BarrioResponse> barriosResponse = new ArrayList<>();

        for (Barrio b : barrios) {
            Integer totalInchas = 0;

            BarrioResponse barrioResponse = new BarrioResponse();
            barrioResponse.setNombre(b.getNombre());

            Map<Long, EquipoBarrio> map = new HashMap<>();
            for (Resultado resultado : resultados) {

                EquipoBarrio equipoResponse = map.get(resultado.getEquipoId());

                if (equipoResponse == null) {
                    equipoResponse = new EquipoBarrio();
                    equipoResponse.setNombre((equipos.get(resultado.getEquipoId().intValue() - 1).getNombre()));
                    equipoResponse.setCantidadHinchas(0);
                    map.put(resultado.getEquipoId(), equipoResponse);
                }

                if (resultado.getBarrioId() != b.getId()) {
                    continue;
                }
                totalInchas += resultado.getVotos();
                equipoResponse.setCantidadHinchas(equipoResponse.getCantidadHinchas() + resultado.getVotos());
            }
            barrioResponse.setEquipos(map.values().stream().toList());
            barrioResponse.setCantidadHinchas(totalInchas);
            barriosResponse.add(barrioResponse);
        }

        for (BarrioResponse barrioResponse2 : barriosResponse) {
            for (EquipoBarrio eq : barrioResponse2.getEquipos()) {
                eq.setPorcentajeHinchas(
                        (eq.getCantidadHinchas().doubleValue() / barrioResponse2.getCantidadHinchas().doubleValue())
                                * 100);
            }
        }

        return barriosResponse;
    }

}
