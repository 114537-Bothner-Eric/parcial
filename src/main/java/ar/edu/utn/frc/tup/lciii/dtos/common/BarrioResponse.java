package ar.edu.utn.frc.tup.lciii.dtos.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarrioResponse {
    private String nombre;
    @JsonProperty("cantidad_hinchas")
    private Integer cantidadHinchas;
    private List<EquipoBarrio> equipos;

}
