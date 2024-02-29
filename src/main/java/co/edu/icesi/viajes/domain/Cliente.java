package co.edu.icesi.viajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @Column(name="id_clie")
    private Integer idCliente;

    @Column(name="numero_identificacion")
    private String numeroIdentificacion;

    @Column(name="primer_apellido")
    private String primerApellido;

    @Column(name="segundo_apellido")
    private String segundoApellido;

    @Column(name="nombre")
    private String nombre;

    @Column(name="telefono1")
    private String telefono1;

    @Column(name="telefono2")
    private String telefono2;

    @Column(name="correo")
    private String correo;

    @Column(name="sexo")
    private String sexo;

    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name="fecha_creacion")
    private Date fechaCreacion;

    @Column(name="fecha_modificacion")
    private Date fechaModificacion;

    @Column(name="usu_creador")
    private String usuCreador;

    @Column(name="usu_modificador")
    private String usuModificador;

    @Column(name="estado")
    private String estado;

    @Column(name="id_tiid")
    private Integer idTiid;
}
