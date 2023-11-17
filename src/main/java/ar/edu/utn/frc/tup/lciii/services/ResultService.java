package ar.edu.utn.frc.tup.lciii.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.utn.frc.tup.lciii.dtos.common.BarrioResponse;
import ar.edu.utn.frc.tup.lciii.dtos.common.EquipoResponse;

@Service
public interface ResultService {

    List<EquipoResponse> getData();

    List<BarrioResponse> getDataBarrios();

}
