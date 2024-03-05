package co.edu.icesi.viajes.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Data public class TipoDestinoDTO implements Serializable {

    public TipoDestinoDTO(Integer idPlan, String codigo, String nombre, String descripcion) {
        this.idPlan = idPlan;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Serial
    private static final long serialVersionUID = 6334646226855431916L;

    private Integer idPlan;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuCreador;
    private String usoModificador;
    private String estado;
}
