package dev.jordanoliveira.mspedido.model;

import java.time.LocalDateTime;
import java.util.List;

import dev.jordanoliveira.mspedido.dto.PedidoDto;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;
    
    @ElementCollection
    @CollectionTable(name = "tb_pedido_produtos", joinColumns = @JoinColumn(name = "pedido_id"))
    @Column(name = "produto_id")
    private List<Long> idProdutos;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status_pedido")
    private StatusPedido statusPedido;

    public static Pedido fromDto(PedidoDto pedidoDto) {
        return new Pedido(
            pedidoDto.id(),
            pedidoDto.dataPedido(),
            pedidoDto.idProdutos(),
            pedidoDto.statusPedido()
        );
    }
}