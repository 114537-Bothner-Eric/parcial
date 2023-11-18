package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.common.BarrioResponse;
import ar.edu.utn.frc.tup.lciii.dtos.common.EquipoResponse;
import ar.edu.utn.frc.tup.lciii.models.Barrio;
import ar.edu.utn.frc.tup.lciii.models.Equipo;
import ar.edu.utn.frc.tup.lciii.models.Resultado;
import ar.edu.utn.frc.tup.lciii.rest.RestClient;
import ar.edu.utn.frc.tup.lciii.services.Impl.ResultServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ResultServiceImplTest {

    @Mock
    private RestClient restClient;

    @InjectMocks
    private ResultServiceImpl resultService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetData() {
        // Mock data for restClient
        List<Equipo> mockEquipos = Arrays.asList(
                new Equipo(1L, "Team A"),
                new Equipo(2L, "Team B")
                // Add more teams as needed
        );

        List<Resultado> mockResultados = Arrays.asList(
                new Resultado(1L, 1L, 1L, 1L, 10), // 10 votes for Team A
                new Resultado(2L, 2L, 1L, 2L, 15) // 15 votes for Team B
                // Add more results as needed
        );

        // Set up mock behavior
        when(restClient.getTeams()).thenReturn(mockEquipos);
        when(restClient.getResultados()).thenReturn(mockResultados);

        // Test the getData method
        List<EquipoResponse> result = resultService.getData();

        // Verify the result
        assertEquals(1, result.size());
        // Add more assertions based on your expected data
    }

    @Test
    public void testGetDataBarrios() {
        // Mock data for restClient
        List<Equipo> mockEquipos = Arrays.asList(
                new Equipo(1L, "Team A"),
                new Equipo(2L, "Team B")
                // Add more teams as needed
        );

        List<Barrio> mockBarrios = Arrays.asList(
                new Barrio(1L, "Barrio A"),
                new Barrio(2L, "Barrio B")
                // Add more barrios as needed
        );

        List<Resultado> mockResultados = Arrays.asList(
                new Resultado(1L, 1L, 1L, 1L, 10), // 10 votes for Team A in Barrio A
                new Resultado(2L, 1L, 2L, 1L, 15) // 15 votes for Team B in Barrio A
                // Add more results as needed
        );

        // Set up mock behavior
        when(restClient.getTeams()).thenReturn(mockEquipos);
        when(restClient.getBarrios()).thenReturn(mockBarrios);
        when(restClient.getResultados()).thenReturn(mockResultados);

        // Test the getDataBarrios method
        List<BarrioResponse> result = resultService.getDataBarrios();

        // Verify the result
        assertEquals(2, result.size());
        // Add more assertions based on your expected data
    }
}