package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.domain.TipoDestino;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DestinoTest {

    @Autowired
    private DestinoService destinoService;

    @Test
    void debeRetornarPorCodigo(){

        List<Destino> lstDestino = destinoService.findByCodigoAndEstadoActivo("PLAYA");
        System.out.println(Arrays.toString(lstDestino.toArray()));
    }

    @Test
    void debeDestinosActivos(){

        List<Destino> lstDestino = destinoService.findAllDestinosActivos();
        System.out.println(Arrays.toString(lstDestino.toArray()));
    }
}
