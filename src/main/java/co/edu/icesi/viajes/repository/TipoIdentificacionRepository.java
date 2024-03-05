package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.TipoDestino;
import co.edu.icesi.viajes.domain.TipoIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoIdentificacionRepository  extends JpaRepository<TipoIdentificacion, Integer> {

    //Consultar todos los tipo de identificación por estado ordenados alfabéticamente.
    @Query("select ti from TipoIdentificacion ti where ti.estado = ?1 order by ti.nombre asc")
    public List<TipoIdentificacion> findAllByEstadoOrderByNombre(String estado);

    // Cnsultar tipo de identificación por código y estado.
    public List<TipoIdentificacion> findByCodigoAndEstado(String codigo, String estado);
}
