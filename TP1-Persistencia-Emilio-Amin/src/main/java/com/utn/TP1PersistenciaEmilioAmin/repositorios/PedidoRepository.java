package com.utn.TP1PersistenciaEmilioAmin.repositorios;

import com.utn.TP1PersistenciaEmilioAmin.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long> {
}
