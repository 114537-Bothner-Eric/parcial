package ar.edu.utn.frc.tup.lciii.controllers;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ar.edu.utn.frc.tup.lciii.dtos.common.BarrioResponse;
import ar.edu.utn.frc.tup.lciii.dtos.common.EquipoBarrio;
import ar.edu.utn.frc.tup.lciii.dtos.common.EquipoResponse;
import ar.edu.utn.frc.tup.lciii.services.ResultService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;;

@WebMvcTest(ResultController.class)
public class ResultControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResultService resultService; // Suponiendo que tienes un servicio llamado MyService

    @Test
    public void testGetData() throws Exception {
        EquipoResponse equipoResponse = new EquipoResponse("EquipoTest", 200, 50.0);
        when(resultService.getData()).thenReturn(Arrays.asList(equipoResponse));

        mockMvc.perform(get("/test"))
               .andExpect(status().isOk())
               .andExpect(content().json("[{\"nombre\":\"EquipoTest\",\"hinchas\":200,\"porcentaje_hinchas\":50}]"));

    }


    @Test
    public void testGetDataBarrios() throws Exception {
        List<EquipoBarrio> equipos = new ArrayList<>();
        EquipoBarrio equipoBarrio = new EquipoBarrio("EquipoTest", 200, 50.0);
        EquipoBarrio equipoBarrio2 = new EquipoBarrio("EquipoTest", 200, 50.0);
        equipos.add(equipoBarrio2);
        equipos.add(equipoBarrio);
        BarrioResponse barrioResponse = new BarrioResponse("BarrioTest", 200, equipos);
        when(resultService.getDataBarrios()).thenReturn(Arrays.asList(barrioResponse));
        mockMvc.perform(get("/test2"))
        .andExpect(status().isOk())
        .andExpect(content().json("[{ \"nombre\": \"BarrioTest\", \"equipos\": [{ \"nombre\": \"EquipoTest\", \"cantidad_hinchas\": 200, \"porcentaje_hinchas\": 50.0 }, { \"nombre\": \"EquipoTest\", \"cantidad_hinchas\": 200, \"porcentaje_hinchas\": 50.0 }], \"cantidad_hinchas\": 200 }]"));

    }
}