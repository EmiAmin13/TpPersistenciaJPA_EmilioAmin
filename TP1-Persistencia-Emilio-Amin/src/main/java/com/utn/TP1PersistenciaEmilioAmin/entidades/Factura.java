package com.utn.TP1PersistenciaEmilioAmin.entidades;

import com.utn.TP1PersistenciaEmilioAmin.enumeraciones.FormaPago;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad{

    private int numero;
    private Date fecha;
    private double dto;
    private int total;
    private FormaPago formaPago;
}
