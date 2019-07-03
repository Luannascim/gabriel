package mefood.cliente;

import mefood.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cliente")
    public Cliente save(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @GetMapping("/cliente/{id}")
    public Optional<Cliente> findByid(@PathVariable Long id){
        return repository.findById(id);
    }

    @GetMapping("/cliente/nome/{nome}")
    public List <Cliente> findByNome(@PathVariable String nome){
        return repository.findByNome(nome);
    }

    @GetMapping("/cliente/datadenascimento/{dataNascimento}")
    public List<Cliente> findByDataNascimento(@PathVariable Date dataNascimento){
        return repository.findByDataNascimento(dataNascimento);
    }

     @GetMapping("/clientes")
        public List<Cliente> findAll() {
        return repository.findAll();
    }

    @PutMapping("/cliente/put/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente)
            throws ResourceNotFoundException {
    // "UPDATE costumer SET ... WHERE ..."
        return repository.findById(id).map(updatedCliente -> {
            updatedCliente.setNome(cliente.getNome());
            updatedCliente.setEndereco(cliente.getEndereco());
            updatedCliente.setDataNascimento(cliente.getDataNascimento());
            return repository.save(updatedCliente);
        }).orElseThrow(() ->
                new ResourceNotFoundException("There is no costumer with the id: " + id));
    }

    @DeleteMapping("/cliente/delete/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id); // Delete
    }
}
