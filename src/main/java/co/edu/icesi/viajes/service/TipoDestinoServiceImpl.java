package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.TipoDestino;
import co.edu.icesi.viajes.dto.TipoDestinoDTO;
import co.edu.icesi.viajes.repository.TipoDestinoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class TipoDestinoServiceImpl implements TipoDestinoService {

    @Autowired
    private TipoDestinoRespository tipoDestinoRespository;

    @Override
    public List<TipoDestino> findAll() {
        return tipoDestinoRespository.findAll();
    }

    @Override
    public Optional<TipoDestino> findByID(Integer id) {
        return tipoDestinoRespository.findById(id) ;
    }

    @Override
    public TipoDestino save(TipoDestino entity) throws Exception {
        return tipoDestinoRespository.save(entity);
    }

    @Override
    public TipoDestino update(TipoDestino entity) throws Exception {
        return tipoDestinoRespository.save(entity);
    }

    @Override
    public void delete(TipoDestino entity) throws Exception {
        tipoDestinoRespository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        tipoDestinoRespository.deleteById(id);
    }

    @Override
    public void validate(TipoDestino entity) throws Exception {

    }

    @Override
    public Long count() {
        return tipoDestinoRespository.count();
    }

    @Override
    public List<TipoDestino> findByCodigo(String codigo){
        return tipoDestinoRespository.findByCodigo(codigo);
    }

    @Override
    public List<TipoDestino> findByCodigoAndEstado(String codigo, String estado){
        return tipoDestinoRespository.findByCodigoAndEstado(codigo,estado);
    }

    @Override
    public List<TipoDestinoDTO> consultartTipoDestinoPorEstado(String estado) {
        return tipoDestinoRespository.consultartTipoDestinoPorEstado(estado);
    }

    @Override
    public List<TipoDestino> findAllOrderByNombre() {
        return tipoDestinoRespository.findAllOrderByNombre();
    }


}
