package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.TipoIdentificacion;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoIdentificacionService extends GenericService<TipoIdentificacion,Integer> {

    @Query("select ti from TipoIdentificacion ti where ti.estado = ?1 order by ti.nombre asc")
    public List<TipoIdentificacion> findAllByEstadoOrderByNombre(String estado);
    public List<TipoIdentificacion> findByCodigoAndEstado(String codigo, String estado);

}
