package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ClienteService extends GenericService<Cliente,Integer> {

    @Query("select cli from Cliente cli where cli.estado = ?1 order by cli.idCliente asc")
    public List<Cliente> findAllByEstadoOrderById(String estado, Pageable pageable);

    public List<Cliente> findBycorreoIgnoreCase(String correo);

    public List<Cliente> findByNumeroIdentificacionLike(String numIdentificacion);

    public List<Cliente> findByNombreIgnoreCaseLike(String name);

    public List<Cliente> findByFechaNacimientoBetween(Date firstDate, Date secondDate);

    public Integer countByEstado(String estado);


    @Query("select cli from Cliente cli where cli.idTiid = ?1")
    public List<Cliente> findByIdTiid(Integer tipoId, Pageable pageable);

    @Query("select cli from Cliente cli where cli.primerApellido like %?1% or cli.segundoApellido LIKE %?1%")
    public List<Cliente> findByPrimerApellidoOrSegundoApellido(String apellido);

    public List<Cliente> findByFechaCreacionBetween(Date firstDate, Date secondDate);

    @Query(value="select cli " +
            "from Cliente cli " +
            "where (:estado is null or  cli.estado = :estado) " +
            "and (:numeroIdentificacion is null or cli.numeroIdentificacion = :numeroIdentificacion)" +
            "and (:tipoIdentificacion is null or cli.idTiid = :tipoIdentificacion)" +
            "and (:nombre is null or upper(cli.nombre) like upper('%'+ :nombre +  '%'))" +
            "order by  cli.nombre asc", nativeQuery = true)
    public List<Cliente> findByOptionalFilters(@Param("estado") String estado, @Param ("numeroIdentificacion") String numeroIdentificacion,
                                               @Param ("tipoIdentificacion") Integer tipoIdentificacion, @Param ("nombre") String nombre);
}
