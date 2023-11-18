package ar.edu.utn.frc.tup.lciii.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import ar.edu.utn.frc.tup.lciii.models.Barrio;
import ar.edu.utn.frc.tup.lciii.models.Equipo;
import ar.edu.utn.frc.tup.lciii.models.Resultado;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RestClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RestClient restClient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTeams() {
        // Mock data for the test
        Equipo[] mockTeams = {new Equipo(1L, "Team A"), new Equipo(2L, "Team B")};
        when(restTemplate.getForObject("http://servidor-fut:8081/equipos", Equipo[].class))
                .thenReturn(mockTeams);

        // Test the getTeams method
        List<Equipo> result = restClient.getTeams();

        // Verify the result
        assertEquals(Arrays.asList(mockTeams), result);
    }

    @Test
    public void testGetBarrios() {
        // Mock data for the test
        Barrio[] mockBarrios = {new Barrio(1L, "Barrio A"), new Barrio(2L, "Barrio B")};
        when(restTemplate.getForObject("http://servidor-fut:8081/barrios", Barrio[].class))
                .thenReturn(mockBarrios);

        // Test the getBarrios method
        List<Barrio> result = restClient.getBarrios();

        // Verify the result
        assertEquals(Arrays.asList(mockBarrios), result);
    }

    @Test
    public void testGetResultados() {
        // Mock data for the test
        Resultado[] mockResultados = {new Resultado(1L, 1L, 1L, 1L, 10), new Resultado(2L, 1L, 2L, 1L, 15)};
        when(restTemplate.getForObject("http://servidor-fut:8081/resultados", Resultado[].class))
                .thenReturn(mockResultados);

        // Test the getResultados method
        List<Resultado> result = restClient.getResultados();

        // Verify the result
        assertEquals(Arrays.asList(mockResultados), result);
    }
}