package com.produtos.apirest.repository;

import com.produtos.apirest.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    	Pessoa findById(long id);
}
