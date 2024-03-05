package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.TipoDestino;
import co.edu.icesi.viajes.dto.TipoDestinoDTO;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoDestinoRespository extends JpaRepository<TipoDestino, Integer> {

    public List<TipoDestino> findByCodigo(String codigo);
    public List<TipoDestino> findByCodigoAndEstado(String codigo, String estado);

    @Query("select tp from TipoDestino tp where tp.codigo = ?1 and tp.estado =?2 ")
    public List<TipoDestino> consultrarPorCodigoEstado(String codigo, String estdo);

    @Query(nativeQuery=true)
    public List<TipoDestinoDTO> consultartTipoDestinoPorEstado(@Param("pEstado") String estado);

    //Consultar los tipos de destino ordenados alfabéticamente.
    @Query("select tp from TipoDestino tp order by tp.nombre asc")
    public List<TipoDestino> findAllOrderByNombre();
}
