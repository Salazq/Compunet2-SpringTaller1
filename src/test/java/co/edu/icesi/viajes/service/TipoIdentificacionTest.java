package co.edu.icesi.viajes.service;


import co.edu.icesi.viajes.domain.TipoDestino;
import co.edu.icesi.viajes.domain.TipoIdentificacion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TipoIdentificacionTest {

    @Autowired
    private TipoIdentificacionService tipoIdentificacionService;

    @Test
    void debeRetornarPorCodigo(){

        List<TipoIdentificacion> lstTipoIdentificacion = tipoIdentificacionService.findAllByEstadoOrderByNombre("A");
        System.out.println(Arrays.toString(lstTipoIdentificacion.toArray()));
    }

    @Test
    void debeRetornarPorCodigoYEstado(){

        List<TipoIdentificacion> lstTipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado("RC","A");
        System.out.println(Arrays.toString(lstTipoIdentificacion.toArray()));
    }
}
