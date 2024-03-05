package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.domain.TipoDestino;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClienteTest {

    @Autowired
    private ClienteService clienteService;

    @Test
    void debeRetornarPorEstado(){
        Pageable pageable = PageRequest.of(0, 2);

        List<Cliente> lstCliente = clienteService.findAllByEstadoOrderById("A",pageable);
        System.out.println(Arrays.toString(lstCliente.toArray()));
    }

    @Test
    void debeRetornarPorCorrero(){

        List<Cliente> lstCliente = clienteService.findBycorreoIgnoreCase("c");
        System.out.println(Arrays.toString(lstCliente.toArray()));
    }

    @Test
    void debeRetornarPorNumeroId(){

        List<Cliente> lstCliente = clienteService.findByNumeroIdentificacionLike("999999999");
        System.out.println(Arrays.toString(lstCliente.toArray()));
    }

    @Test
    void debeRetornarPorNombre(){

        List<Cliente> lstCliente = clienteService.findByNombreIgnoreCaseLike("jorge");
        System.out.println(Arrays.toString(lstCliente.toArray()));
    }

    @Test
    void debeRetornarPorFechaNacimiento(){

        List<Cliente> lstCliente = clienteService.findByFechaNacimientoBetween(
                new GregorianCalendar(1985, Calendar.JANUARY, 1).getTime(),
                new GregorianCalendar(1995, Calendar.DECEMBER, 31).getTime());
        System.out.println(Arrays.toString(lstCliente.toArray()));
    }

    @Test
    void debeContarPorEstado(){

        Integer numCliente = clienteService.countByEstado("A");

        assertEquals(numCliente, 10);
    }

    @Test
    void debeRetornarPorTipoId(){

        Pageable pageable = PageRequest.of(0, 2);

        List<Cliente> lstCliente = clienteService.findByIdTiid(2,pageable);
        System.out.println(Arrays.toString(lstCliente.toArray()));
    }

    @Test
    void debeRetornarPorApellido(){

        List<Cliente> lstCliente = clienteService.findByPrimerApellidoOrSegundoApellido("Torres");
        System.out.println(Arrays.toString(lstCliente.toArray()));
    }

    @Test
    void debeRetornarPorFechaCreacion(){

        List<Cliente> lstCliente = clienteService.findByFechaCreacionBetween(
                new GregorianCalendar(2024, Calendar.JANUARY, 1).getTime(),
                new GregorianCalendar(2024, Calendar.DECEMBER, 31).getTime());
        System.out.println(Arrays.toString(lstCliente.toArray()));
    }



}
