package dev.jordanoliveira.msproduto.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.jordanoliveira.msproduto.dto.ProdutoDto;
import dev.jordanoliveira.msproduto.model.Produto;
import dev.jordanoliveira.msproduto.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProdutoServiceImpl implements ProdutoService {

  private final ProdutoRepository produtoRepository;

  @Override
  public Page<ProdutoDto> findAll(Pageable pagination) {
    return produtoRepository.findAll(pagination).map(ProdutoDto::new);
  }

  @Override
  public ProdutoDto findById(Long id) {
    return produtoRepository.findById(id).map(ProdutoDto::new).orElseThrow(EntityNotFoundException::new);
  }

  @Override
  @Transactional
  public ProdutoDto save(ProdutoDto produtoDto) {
    var produto = Produto.fromDto(produtoDto);
    return new ProdutoDto(produtoRepository.save(produto));
  }

  @Override
  public ProdutoDto update(Long id, ProdutoDto produtoDto) {
    var produto = produtoRepository
      .findById(id).orElseThrow(()->new EntityNotFoundException("Produto não Encontrado"));

    produto.setNome(produtoDto.nome());
    produto.setQuantidade(produtoDto.quantidade());
    produto.setDescricao(produtoDto.descricao());
    produto.setPreco(produtoDto.preco());

    return new ProdutoDto(produtoRepository.save(produto));
  }

  @Override
  public void delete(Long id) {
    produtoRepository
      .findById(id).orElseThrow(()->new EntityNotFoundException("Produto não Encontrado"));
    produtoRepository.deleteById(id);
  }

}
