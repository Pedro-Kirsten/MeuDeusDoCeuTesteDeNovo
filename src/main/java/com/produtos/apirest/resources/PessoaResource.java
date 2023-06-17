package com.produtos.apirest.resources;

import com.produtos.apirest.models.Pessoa;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.PessoaRepository;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
public class PessoaResource {

    @Autowired
    PessoaRepository pessoaRepository;

    @ApiOperation(value = "Retorna uma lista de Pessoas")
    @GetMapping("/pessoas")
    public List<Pessoa> listaPessoas() {
        return pessoaRepository.findAll();
    }

    @ApiOperation(value = "Retorna uma pessoa unica")
    @GetMapping("/pessoa/{id}")
    public Pessoa listaPessoaUnico(@PathVariable(value = "id") long id) {
        return pessoaRepository.findById(id);
    }

    @ApiOperation(value = "Salva uma pessoa")
    @PostMapping("/pessoa")
    public Pessoa salvaPessoa(@RequestBody @Valid Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @ApiOperation(value = "Deleta uma pessoa")
    @DeleteMapping("/pessoa")
    public void deletaPessoa(@RequestBody @Valid Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }

    @ApiOperation(value = "Atualiza uma pessoa")
    @PutMapping("/pessoa")
    public Pessoa atualizaPessoa(@RequestBody @Valid Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
