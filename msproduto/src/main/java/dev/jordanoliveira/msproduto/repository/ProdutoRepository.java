package dev.jordanoliveira.msproduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jordanoliveira.msproduto.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
