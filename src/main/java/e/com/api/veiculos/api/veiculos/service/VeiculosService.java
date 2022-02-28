package e.com.api.veiculos.api.veiculos.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import e.com.api.veiculos.api.veiculos.domain.VeiculoDomain;
import e.com.api.veiculos.api.veiculos.exceptions.DomainNotaFoundException;
import e.com.api.veiculos.api.veiculos.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Registro da Service na injeção de dependência
public class VeiculosService {
    @Autowired // Injeção de dependência
    private VeiculosRepository repository;

    public List<VeiculoDomain> findAll() {
        return repository.findAll();
    }

    public VeiculoDomain findById(Long id) {
        Optional<VeiculoDomain> obj = repository.findById(id);
        return obj.orElseThrow(() -> new DomainNotaFoundException(id));
    }

    @Transactional // Garante a transação com o Banco de Dados
    public List<VeiculoDomain> findAllUnsold() {
        return repository.findByUnsold();
    }

    @Transactional
    public List<VeiculoDomain> findAllSold() {
        return repository.findBySold();
    }

    @Transactional
    public List<VeiculoDomain> findByBrand(String brand) {
        return repository.findByBrand(brand);
    }

    public VeiculoDomain insert(VeiculoDomain obj) {
        return repository.save(obj);
    }

    public void deleteById(Long id) {
        try {
            repository.deleteById(id);

        } catch (DomainNotaFoundException e) {
            throw new DomainNotaFoundException(id);
        }
    }

    public VeiculoDomain update(Long id, VeiculoDomain obj) {
        try {
            VeiculoDomain entity = repository.getById(id);
            updateData(entity, obj);
            return repository.save(entity);

        } catch (EntityNotFoundException e) {
            throw new DomainNotaFoundException(id);
        }
    }

    private void updateData(VeiculoDomain entity, VeiculoDomain obj) {
        entity.setVehicle(obj.getVehicle());
        entity.setBrand(obj.getBrand());
        entity.setYear(obj.getYear());
        entity.setDescription(obj.getDescription());
        entity.setUpdate(obj.getUpdate());
    }

}
