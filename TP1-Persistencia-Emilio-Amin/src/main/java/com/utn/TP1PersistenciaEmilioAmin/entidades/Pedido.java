package com.utn.TP1PersistenciaEmilioAmin.entidades;

import com.utn.TP1PersistenciaEmilioAmin.enumeraciones.Estado;
import com.utn.TP1PersistenciaEmilioAmin.enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad {

    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double total;
    private TipoEnvio tipoEnvio;
    private Estado estado;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "factura-id")
    private Factura factura;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "DetallePedido",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id"))
    @EqualsAndHashCode.Exclude
    @Builder.Default

    private Set<Producto> productos = new HashSet<>();


}
