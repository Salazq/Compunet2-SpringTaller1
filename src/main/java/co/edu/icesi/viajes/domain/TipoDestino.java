package co.edu.icesi.viajes.domain;

import co.edu.icesi.viajes.dto.TipoDestinoDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@NamedNativeQueries({
        @NamedNativeQuery(name= "TipoDestino.consultartTipoDestinoPorEstado" , query="", resultSetMapping = "consultartTipoDestinoPorEstado")
})

@SqlResultSetMappings({
        @SqlResultSetMapping(name="consultartTipoDestinoPorEstado",
                classes= {@ConstructorResult(targetClass = TipoDestinoDTO.class,
                    columns = {
                            @ColumnResult(name= "idTide", type = Integer.class), //se usa el nombre de columna asignado en la query
                            @ColumnResult(name= "codigo", type = String.class),
                            @ColumnResult(name= "nombre", type = String.class),
                            @ColumnResult(name= "descripcion", type = String.class),

                    })
                }),
})


@Data
@Entity
@Table(name="tipo_destino")
public class TipoDestino {

    @Id
    @Column(name="id_tide")
    private Integer idPlan;

    @Column(name="codigo", nullable = false)
    private String codigo;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="fecha_creacion")
    private Date fechaCreacion;

    @Column(name="fecha_modificacion")
    private Date fechaModificacion;

    @Column(name="usu_creador")
    private String usuCreador;

    @Column(name="usu_modificador")
    private String usoModificador;

    @Column(name="estado")
    private String estado;


}
