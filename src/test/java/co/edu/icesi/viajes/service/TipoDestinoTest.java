package co.edu.icesi.viajes.service;
import co.edu.icesi.viajes.domain.TipoDestino;
import co.edu.icesi.viajes.service.TipoDestinoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TipoDestinoTest {

    @Autowired
    private TipoDestinoService tipoDestinoService;

    @Test
    void debeRetornarListaTiposDestino(){

        String out="";
        String line;

        List<TipoDestino> lstTipoDestino = tipoDestinoService.findAll();

        for(TipoDestino tipoDestino: lstTipoDestino){
            line=tipoDestino.getCodigo() + "-" + tipoDestino.getNombre();
            out+=line;
        }

        assertEquals(out,"PLAYA-PLAYA Y MAR" +
                "BOSQU-NATURALEZA, BOSQUE Y AIRE" +
                "DESIE-DESIERTO Y SOL" +
                "NIEVE-BLANCA NIEVE" +
                "TREKK-TREKKING" +
                "CULTU-CULTURAL" +
                "LAGOS-LAGUNAS MAJESTUOSAS" +
                "SORPR-SORPRESA");
    }

    @Test
    void debeRetornarTipoDestinoConId(){

        Optional<TipoDestino> OptionaltipoDestinoId2 = tipoDestinoService.findByID(2);

        assertTrue(OptionaltipoDestinoId2.isPresent());

        TipoDestino tipoDestinoId2 = OptionaltipoDestinoId2.orElse(null);
        String out=tipoDestinoId2.getCodigo() + "-" + tipoDestinoId2.getNombre();

        assertEquals(out, "PLAYA-PLAYA Y MAR");
    }

    @Test
    void debeRetornarTipoDestinoGuardado() throws Exception {

        tipoDestinoService.deleteById(10);

        TipoDestino tipoDestino = new TipoDestino();
        tipoDestino.setIdPlan(10);
        tipoDestino.setCodigo("cTest");
        tipoDestino.setNombre("nombreTest");
        tipoDestino.setDescripcion("descripcionTest");
        tipoDestino.setFechaCreacion(new GregorianCalendar(2021, Calendar.FEBRUARY, 13).getTime());
        tipoDestino.setUsuCreador("CLOPEZ");
        tipoDestino.setEstado("A");

        Long preNumeroFilas = tipoDestinoService.count();

        TipoDestino savedTipoDestino = tipoDestinoService.save(tipoDestino);

        assertEquals(tipoDestino, savedTipoDestino);
        assertEquals(preNumeroFilas+1, tipoDestinoService.count());

        tipoDestinoService.deleteById(10);
    }

    @Test
    void debeRetornarTipoDestinoActualizado() throws Exception {

        TipoDestino tipoDestino = new TipoDestino();
        tipoDestino.setIdPlan(8);
        tipoDestino.setCodigo("SORPR");
        tipoDestino.setNombre("SORPRESA");
        tipoDestino.setDescripcion("descripcionTest");
        tipoDestino.setFechaCreacion(new GregorianCalendar(2021, Calendar.FEBRUARY, 13).getTime());
        tipoDestino.setUsuCreador("CLOPEZ");
        tipoDestino.setEstado("A");

        tipoDestinoService.save(tipoDestino);

        Optional<TipoDestino> OptionaltipoDestinoId8 = tipoDestinoService.findByID(8);
        TipoDestino tipoDestinoId8 = OptionaltipoDestinoId8.orElse(null);

        assertEquals(tipoDestinoId8.getDescripcion(), "descripcionTest");
    }

    @Test
    void debeEliminarElementoTipoDestino() throws Exception {

        TipoDestino tipoDestino = new TipoDestino();
        tipoDestino.setIdPlan(11);
        tipoDestino.setCodigo("eTest");
        tipoDestino.setNombre("nombreTestEliminacion");
        tipoDestino.setDescripcion("descripcionTest");
        tipoDestino.setFechaCreacion(new GregorianCalendar(2021, Calendar.FEBRUARY, 13).getTime());
        tipoDestino.setUsuCreador("CLOPEZ");
        tipoDestino.setEstado("A");

        tipoDestinoService.save(tipoDestino);
        Long preNumeroFilas = tipoDestinoService.count();

        Optional<TipoDestino> OptionaltipoDestinoId11 = tipoDestinoService.findByID(11);
        TipoDestino tipoDestinoId11 = OptionaltipoDestinoId11.orElse(null);

        tipoDestinoService.delete(tipoDestinoId11);

        assertEquals(preNumeroFilas-1, tipoDestinoService.count());
    }

    @Test
    void debeEliminarElementoTipoDestinoPorId() throws Exception {


        TipoDestino tipoDestino = new TipoDestino();
        tipoDestino.setIdPlan(11);
        tipoDestino.setCodigo("eTest");
        tipoDestino.setNombre("nombreTestEliminacion");
        tipoDestino.setDescripcion("descripcionTest");
        tipoDestino.setFechaCreacion(new GregorianCalendar(2021, Calendar.FEBRUARY, 13).getTime());
        tipoDestino.setUsuCreador("CLOPEZ");
        tipoDestino.setEstado("A");

        tipoDestinoService.save(tipoDestino);
        Long preNumeroFilas = tipoDestinoService.count();

        tipoDestinoService.deleteById(11);

        assertEquals(preNumeroFilas-1, tipoDestinoService.count());
    }

    @Test
    void debeRetornarNumeroFilas(){

        Long numeroFilasTipoDestino = tipoDestinoService.count();

        assertEquals(numeroFilasTipoDestino, 8);
    }

}
