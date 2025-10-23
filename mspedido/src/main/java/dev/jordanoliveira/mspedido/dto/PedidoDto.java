package dev.jordanoliveira.mspedido.dto;

import dev.jordanoliveira.mspedido.model.Pedido;
import dev.jordanoliveira.mspedido.model.StatusPedido;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoDto(
    Long id,
    LocalDateTime dataPedido,
    @NotEmpty List<Long> idProdutos,
    @NotNull StatusPedido statusPedido
) {
    public PedidoDto(Pedido p) {
        this(p.getId(), p.getDataPedido(), p.getIdProdutos(), p.getStatusPedido());
    }
}