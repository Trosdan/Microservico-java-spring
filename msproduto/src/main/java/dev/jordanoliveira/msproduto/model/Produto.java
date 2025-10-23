package dev.jordanoliveira.msproduto.model;

import dev.jordanoliveira.msproduto.dto.ProdutoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length=150)
  private String nome;
  private Integer quantidade;
  private String descricao;
  private Float preco;

  public static Produto fromDto(ProdutoDto produtoDto) {
    return new Produto(
      produtoDto.id(),
      produtoDto.nome(),
      produtoDto.quantidade(),
      produtoDto.descricao(),
      produtoDto.preco());
  }
}
