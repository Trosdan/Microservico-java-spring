package dev.jordanoliveira.msproduto.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jordanoliveira.msproduto.dto.ProdutoDto;
import dev.jordanoliveira.msproduto.service.ProdutoServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  private final ProdutoServiceImpl produtoService;

  @GetMapping
  public ResponseEntity<Page<ProdutoDto>> findAll(@PageableDefault(size = 5) Pageable pagination) {
    return ResponseEntity.ok(produtoService.findAll(pagination));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProdutoDto> findById(@PathVariable("id") Long id) {
    try {
      return ResponseEntity.ok(produtoService.findById(id));
    } catch (EntityNotFoundException ex) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<ProdutoDto> save(@Valid @RequestBody ProdutoDto produtoDto) {
    var produtoDtoSaved = produtoService.save(produtoDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(produtoDtoSaved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProdutoDto> update(@PathVariable("id") Long id, @Valid @RequestBody ProdutoDto produtoDto) {
    var produtoDtoUpdated = produtoService.update(id, produtoDto);
    return ResponseEntity.ok(produtoDtoUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    produtoService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
