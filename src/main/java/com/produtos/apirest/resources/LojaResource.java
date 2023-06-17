package com.produtos.apirest.resources;

import com.produtos.apirest.models.Loja;
import com.produtos.apirest.repository.LojaRepository;
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
public class LojaResource {

    @Autowired
    LojaRepository lojaRepository;

    @ApiOperation(value = "Retorna uma lista de Lojas")
    @GetMapping("/lojas")
    public List<Loja> listaLojas() {
        return lojaRepository.findAll();
    }

    @ApiOperation(value = "Retorna uma loja unica")
    @GetMapping("/loja/{id}")
    public Loja listaLojaUnico(@PathVariable(value = "id") long id) {
        return lojaRepository.findById(id);
    }

    @ApiOperation(value = "Salva uma loja")
    @PostMapping("/loja")
    public Loja salvaLoja(@RequestBody @Valid Loja loja) {
        return lojaRepository.save(loja);
    }

    @ApiOperation(value = "Deleta uma loja")
    @DeleteMapping("/loja")
    public void deletaLoja(@RequestBody @Valid Loja loja) {
        lojaRepository.delete(loja);
    }

    @ApiOperation(value = "Atualiza uma loja")
    @PutMapping("/loja")
    public Loja atualizaLoja(@RequestBody @Valid Loja loja) {
        return lojaRepository.save(loja);
    }
}


