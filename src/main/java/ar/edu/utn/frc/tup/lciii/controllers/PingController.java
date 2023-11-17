package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.common.BarrioResponse;
import ar.edu.utn.frc.tup.lciii.dtos.common.EquipoResponse;
import ar.edu.utn.frc.tup.lciii.dtos.common.ErrorApi;
import ar.edu.utn.frc.tup.lciii.services.ResultService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

        @Autowired
        private ResultService resultService;

        @Operation(summary = "Check healthy of the app", description = "If the app it's alive response pong")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = String.class))),
                        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorApi.class)))
        })
        @GetMapping("/ping")
        public ResponseEntity<List<EquipoResponse>> pong() {
                List<EquipoResponse> resultados = resultService.getData();

                return ResponseEntity.ok(resultados);
        }

        @GetMapping("/pang")
        public ResponseEntity<List<BarrioResponse>> pang() {
                List<BarrioResponse> resultados = resultService.getDataBarrios();

                return ResponseEntity.ok(resultados);
        }
}
