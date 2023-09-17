package com.utn.TP1PersistenciaEmilioAmin.entidades;

import com.utn.TP1PersistenciaEmilioAmin.enumeraciones.Tipo;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto extends BaseEntidad{

    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVta;
    private double precioCompra;
    private int stockActual;
    private int stockMin;
    private String unidadMedida;
    private String receta;
    private Tipo tipo;

    @ManyToMany(mappedBy = "productos")
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();
}
