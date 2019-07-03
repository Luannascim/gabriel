package mefood.produto;

import mefood.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/produtos")
    public Produto save(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @GetMapping("/produtos/{id}")
    public Optional<Produto> findById(@PathVariable Long id){
        return repository.findById(id);
    }

    @GetMapping("/produtos")
    public List<Produto> findAll() {
        return repository.findAll();
    }

    @PutMapping("/produtos/put/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto)
            throws ResourceNotFoundException {
        // "UPDATE costumer SET ... WHERE ..."
        return repository.findById(id).map(updatedProduto -> {
            updatedProduto.setNome(produto.getNome());
            updatedProduto.setDescricao(produto.getDescricao());
            return repository.save(updatedProduto);
        }).orElseThrow(() ->
                new ResourceNotFoundException("There is no costumer with the id: " + id));
    }

    @DeleteMapping("/produtos/delete/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id); // Delete
    }
}

