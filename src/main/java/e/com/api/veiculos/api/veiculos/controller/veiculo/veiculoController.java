package e.com.api.veiculos.api.veiculos.controller.veiculo;

import java.net.URI;
import java.util.List;
import e.com.api.veiculos.api.veiculos.domain.VeiculoDomain;
import e.com.api.veiculos.api.veiculos.repository.VeiculosRepository;
import e.com.api.veiculos.api.veiculos.service.VeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController // Controlador Rest
@RequestMapping(value = "/veiculos") // URI

public class veiculoController {

    @Autowired // Injeção de dependência
    private VeiculosService veiculosService;

    @Autowired
    private VeiculosRepository veiculosRepository;


    @GetMapping// Busca por todos os registros no banco de dados
    public ResponseEntity<List<VeiculoDomain>> findAll() {
        List<VeiculoDomain> list = veiculosService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Pesquisa por Id
    public ResponseEntity<VeiculoDomain> findById(@PathVariable Long id) {
        VeiculoDomain obj = veiculosService.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @GetMapping(value = "/unsold") // Busca veículos não vendidos
    public ResponseEntity<List<VeiculoDomain>> findAllUnsold() {
        List<VeiculoDomain> obj = veiculosService.findAllUnsold();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/sold")// Busca veículos vendidos
    public ResponseEntity<List<VeiculoDomain>> findAllSold() {
        List<VeiculoDomain> obj = veiculosService.findAllSold();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/brand/{id}") // Busca veículos por fabricante
    public ResponseEntity<List<VeiculoDomain>> findByBrand(@PathVariable String id) {
        List<VeiculoDomain> obj = veiculosService.findByBrand(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping // Insere um novo registro de veículo
    public ResponseEntity<VeiculoDomain> insert(@RequestBody VeiculoDomain obj) {
        obj = veiculosService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}") // Deleta por Id
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!veiculosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        veiculosService.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna o código 204
    }

    @PutMapping(value = "/{id}") // Atualiza por Id
    public ResponseEntity<VeiculoDomain> update(@PathVariable Long id, @RequestBody VeiculoDomain obj) {
        obj = veiculosService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
