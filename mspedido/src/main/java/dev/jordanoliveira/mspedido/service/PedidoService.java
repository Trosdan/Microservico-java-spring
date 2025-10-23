package dev.jordanoliveira.mspedido.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.jordanoliveira.mspedido.dto.PedidoDto;

public interface PedidoService {
    Page<PedidoDto> findAll(Pageable pagination);
    PedidoDto findById(Long id);
    PedidoDto save(PedidoDto pedidoDto);
    PedidoDto update(Long id, PedidoDto pedidoDto);
    void delete(Long id);
}