package dev.jordanoliveira.msproduto.dto;

import dev.jordanoliveira.msproduto.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProdutoDto(
  Long id,
  @NotBlank String nome,
  @NotNull @Positive Integer quantidade,
  @NotBlank String descricao,
  @NotNull @Positive Float preco
) {
  public ProdutoDto(Produto p) {
    this(p.getId(), p.getNome(), p.getQuantidade(), p.getDescricao(), p.getPreco());
  }
}
