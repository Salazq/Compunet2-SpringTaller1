package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.repository.ClienteRepository;
import co.edu.icesi.viajes.repository.TipoDestinoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findByID(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente entity) throws Exception {
        return clienteRepository.save(entity);
    }

    @Override
    public Cliente update(Cliente entity) throws Exception {
        return clienteRepository.save(entity);
    }

    @Override
    public void delete(Cliente entity) throws Exception {
        clienteRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        clienteRepository.deleteById(id);
    }

    @Override
    public void validate(Cliente entity) throws Exception {
    }

    @Override
    public Long count() {
        return clienteRepository.count();
    }


    public List<Cliente> findAllByEstadoOrderById(String estado, Pageable pageable) {
        return clienteRepository.findAllByEstadoOrderById(estado,pageable);
    }

    @Override
    public List<Cliente> findBycorreoIgnoreCase(String correo) {
        return clienteRepository.findBycorreoIgnoreCase(correo);
    }

    @Override
    public List<Cliente> findByNumeroIdentificacionLike(String numIdentificacion){
        return clienteRepository.findByNumeroIdentificacionLike(numIdentificacion);
    }

    @Override
    public List<Cliente> findByNombreIgnoreCaseLike(String name) {
        return clienteRepository.findByNombreIgnoreCaseLike(name);
    }

    @Override
    public List<Cliente> findByFechaNacimientoBetween(Date firstDate, Date secondDate) {
        return clienteRepository.findByFechaNacimientoBetween(firstDate,secondDate);
    }

    @Override
    public Integer countByEstado(String estado) {
        return clienteRepository.countByEstado(estado);
    }

    @Override
    public List<Cliente> findByIdTiid(Integer tipoId, Pageable pageable) {
        return clienteRepository.findByIdTiid(tipoId, pageable);
    }

    @Override
    public List<Cliente> findByPrimerApellidoOrSegundoApellido(String apellido) {
        return clienteRepository.findByPrimerApellidoOrSegundoApellido(apellido);
    }

    @Override
    public List<Cliente> findByFechaCreacionBetween(Date firstDate, Date secondDate) {
        return clienteRepository.findByFechaCreacionBetween(firstDate,secondDate);
    }

    @Override
    public List<Cliente> findByOptionalFilters(String estado, String numeroIdentificacion, Integer tipoIdentificacion, String nombre) {
        return null;
    }
}
