package com.dog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dog.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
