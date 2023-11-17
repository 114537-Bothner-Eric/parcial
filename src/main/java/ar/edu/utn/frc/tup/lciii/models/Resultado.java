package ar.edu.utn.frc.tup.lciii.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {
    private Long id;
    private Long encuestadorId;
    private Long equipoId;
    private Long barrioId;
    private Integer votos;
}
