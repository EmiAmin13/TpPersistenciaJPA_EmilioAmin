package com.utn.TP1PersistenciaEmilioAmin.repositorios;

import com.utn.TP1PersistenciaEmilioAmin.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto, Long> {
}
