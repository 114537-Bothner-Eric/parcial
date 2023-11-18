package ar.edu.utn.frc.tup.lciii.dtos.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.utn.frc.tup.lciii.models.Equipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipoResponse {
    private String nombre;

    private Integer hinchas;

    @JsonProperty("porcentaje_hinchas")
    private Double porcentajeHinchas;
}
