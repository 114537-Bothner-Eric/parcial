package ar.edu.utn.frc.tup.lciii.dtos.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EquipoBarrio {

    private String nombre;

    @JsonProperty("cantidad_hinchas")
    private Integer cantidadHinchas;

    @JsonProperty("porcentaje_hinchas")
    private Double porcentajeHinchas;

}
