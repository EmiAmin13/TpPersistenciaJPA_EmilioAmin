package com.utn.TP1PersistenciaEmilioAmin.repositorios;


import com.utn.TP1PersistenciaEmilioAmin.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository <Domicilio,Long>{
}
