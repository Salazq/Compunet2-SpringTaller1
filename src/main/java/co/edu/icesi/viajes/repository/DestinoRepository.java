package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.domain.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface DestinoRepository  extends JpaRepository<Destino, Integer> {

    //Consultar un destino por código y estado activo.
    @Query("select des from Destino des where des.codigo = ?1 and des.estado= 'A'")
    public List<Destino> findByCodigoAndEstadoActivo(String codigo);

    //Consultar los destinos por tipo de destino
    public List<Destino> findByIdTide(Integer idTipoDestino);

    //Consultar todos los destinos activos, mostrando que tipo de destino es.
    @Query("select des, td from Destino des inner join TipoDestino td on des.idTide=td.idPlan where des.estado = 'A'")
    public List<Destino> findAllDestinosActivos();
}
