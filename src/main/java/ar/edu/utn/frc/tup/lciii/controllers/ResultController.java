package ar.edu.utn.frc.tup.lciii.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frc.tup.lciii.dtos.common.BarrioResponse;
import ar.edu.utn.frc.tup.lciii.dtos.common.EquipoResponse;
import ar.edu.utn.frc.tup.lciii.services.ResultService;

@RestController
public class ResultController {

        @Autowired
        private ResultService resultService;

        @GetMapping("/test")
        public ResponseEntity<List<EquipoResponse>> pong() {
                List<EquipoResponse> resultados = resultService.getData();

                return ResponseEntity.ok(resultados);
        }

        @GetMapping("/test2")
        public ResponseEntity<List<BarrioResponse>> pang() {
                List<BarrioResponse> resultados = resultService.getDataBarrios();

                return ResponseEntity.ok(resultados);
        }
}
