package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.domain.TipoIdentificacion;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer> {

    //Consultar a todos los clientes por estado. Esta consulta debe ser paginada y ordenada de forma ascendente por número de identificación
    @Query("select cli from Cliente cli where cli.estado = ?1 order by cli.idCliente asc")
    public List<Cliente> findAllByEstadoOrderById(String estado, Pageable pageable);

    //Consultar a un cliente por correo electrónico. Esta consulta debe ignorar las mayúsculas y minúsculas.
    public List<Cliente> findBycorreoIgnoreCase(String correo);

    //Consultar cliente por número de identificación, usando LIKE

    public List<Cliente> findByNumeroIdentificacionLike(String numIdentificacion);

    //Consultar al cliente por nombre, ignorando Mayúsculas y minúsculas, usando LIKE.
    public List<Cliente> findByNombreIgnoreCaseLike(String name);

    //Consultar clientes por rango de fecha (Se debe pasar dos fechas y traer los clientes cuya fecha de nacimiento se encuentre entre el rango ingresado).
    public List<Cliente> findByFechaNacimientoBetween(Date firstDate, Date secondDate);

    // Consultar el total de clientes por estado.
    public Integer countByEstado(String estado);

    //Consultar clientes por tipo de identificación. Debe de ser paginado

    @Query("select cli from Cliente cli where cli.idTiid = ?1")
    public List<Cliente> findByIdTiid(Integer tipoId, Pageable pageable);


    //Consultar clientes por apellido (tener en cuenta los campos primer y segundo apellido)

    @Query("select cli from Cliente cli where cli.primerApellido like %?1% or cli.segundoApellido LIKE %?1%")
    public List<Cliente> findByPrimerApellidoOrSegundoApellido(String apellido);

    //Consultar cliente por rango de fecha de creacion
    public List<Cliente> findByFechaCreacionBetween(Date firstDate, Date secondDate);

    //Consultar todos los clientes con los siguientes filtros: Estado, número identificación, tipo de identificación, nombre
    //(con Like) en orden ascendente. (debe de ser una sola consulta y los filtros pueden ser opcionales).

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
