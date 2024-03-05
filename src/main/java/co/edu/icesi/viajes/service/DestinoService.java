package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Destino;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DestinoService extends GenericService<Destino,Integer> {

    @Query("select des from Destino des where des.codigo = ?1 and des.estado= 'A'")
    public List<Destino> findByCodigoAndEstadoActivo(String codigo);

    public List<Destino> findByIdTide(Integer idTipoDestino);

    @Query("select des, td from Destino des inner join TipoDestino td on des.idTide=td.idPlan where des.estado = 'A'")
    public List<Destino> findAllDestinosActivos();
}
