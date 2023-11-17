package ar.edu.utn.frc.tup.lciii.dtos.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarrioResponse {
    private String nombre;
    private Integer cantidadHinchas;
    private List<EquipoBarrio> equipos;

}
