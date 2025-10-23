package dev.jordanoliveira.mspedido.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.jordanoliveira.mspedido.dto.PedidoDto;
import dev.jordanoliveira.mspedido.model.Pedido;
import dev.jordanoliveira.mspedido.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public Page<PedidoDto> findAll(Pageable pagination) {
        return pedidoRepository.findAll(pagination).map(PedidoDto::new);
    }

    @Override
    public PedidoDto findById(Long id) {
        return pedidoRepository.findById(id).map(PedidoDto::new).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional
    public PedidoDto save(PedidoDto pedidoDto) {
        var pedido = Pedido.fromDto(pedidoDto);
        // Define a data do pedido como agora se não foi informada
        if (pedido.getDataPedido() == null) {
            pedido.setDataPedido(LocalDateTime.now());
        }
        return new PedidoDto(pedidoRepository.save(pedido));
    }

    @Override
    @Transactional
    public PedidoDto update(Long id, PedidoDto pedidoDto) {
        var pedido = pedidoRepository
            .findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        pedido.setDataPedido(pedidoDto.dataPedido());
        pedido.setIdProdutos(pedidoDto.idProdutos());
        pedido.setStatusPedido(pedidoDto.statusPedido());

        return new PedidoDto(pedidoRepository.save(pedido));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pedidoRepository
            .findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
        pedidoRepository.deleteById(id);
    }
}