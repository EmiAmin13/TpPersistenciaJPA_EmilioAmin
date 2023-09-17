package com.utn.TP1PersistenciaEmilioAmin.repositorios;

import com.utn.TP1PersistenciaEmilioAmin.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Long> {
}
