package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.TipoDestino;
import co.edu.icesi.viajes.dto.TipoDestinoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoDestinoService extends GenericService<TipoDestino,Integer> {

    public List<TipoDestino> findByCodigo(String codigo);
    public List<TipoDestino> findByCodigoAndEstado(String codigo, String estado);

    @Query(nativeQuery=true)
    public List<TipoDestinoDTO> consultartTipoDestinoPorEstado(@Param("pEstado") String estado);

    @Query("select tp from TipoDestino tp order by tp.nombre asc")
    public List<TipoDestino> findAllOrderByNombre();


}
