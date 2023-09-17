package com.utn.TP1PersistenciaEmilioAmin;

import com.utn.TP1PersistenciaEmilioAmin.entidades.*;
import com.utn.TP1PersistenciaEmilioAmin.enumeraciones.Estado;
import com.utn.TP1PersistenciaEmilioAmin.enumeraciones.FormaPago;
import com.utn.TP1PersistenciaEmilioAmin.enumeraciones.Tipo;
import com.utn.TP1PersistenciaEmilioAmin.enumeraciones.TipoEnvio;
import com.utn.TP1PersistenciaEmilioAmin.repositorios.ClienteRepository;
import com.utn.TP1PersistenciaEmilioAmin.repositorios.RubroRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Tp1PersistenciaEmilioAminApplication {

    @Autowired
    RubroRepository rubroRepository;
    @Autowired
    ClienteRepository clienteRepository;

    public static void main(String [] args) {
        SpringApplication.run(Tp1PersistenciaEmilioAminApplication.class, args);
        System.out.println("Funciona Correctamente");
    }
    @Bean
    CommandLineRunner init(RubroRepository rubroRepository1, ClienteRepository clienteRepository1){
        return args -> {
            System.out.println("-------------Estoy Funcionando--------------");
            Rubro rubro1 = Rubro.builder()
                    .denominacion("Hamburguesas")
                    .build();
            //crear instancias de productos
            Producto producto1 = Producto.builder()
                    .tiempoEstimadoCocina(40)
                    .denominacion("Hamburguesa Doble")
                    .precioVta(2500)
                    .precioCompra(1000)
                    .stockActual(45)
                    .stockMin(10)
                    .unidadMedida("uni1")
                    .receta("receta1")
                    .tipo(Tipo.Insumo)
                    .build();
            Producto producto2 = Producto.builder()
                    .tiempoEstimadoCocina(40)
                    .denominacion("Hamburguesa con Baccon")
                    .precioVta(2000)
                    .precioCompra(1300)
                    .stockActual(25)
                    .stockMin(5)
                    .unidadMedida("uni2")
                    .receta("receta2")
                    .tipo(Tipo.Insumo)
                    .build();
            //agregar productos al rubro
            rubro1.agregarProducto(producto1);
            rubro1.agregarProducto(producto2);
            //guardar rubro
            rubroRepository.save(rubro1);
            //Crear instancia Cliente
            Cliente cliente1 = Cliente.builder()
                    .nombre("Emilio")
                    .apellido("Amin")
                    .mail("@gmail")
                    .telefono("2619998888")
                    .build();
            //Crear instancia domicilio
            Domicilio domicilio1 = Domicilio.builder()
                    .calle("Barcala")
                    .numero(943)
                    .localidad("Ciudad")
                    .build();
            Domicilio domicilio2 = Domicilio.builder()
                    .calle("Av.España")
                    .numero(934)
                    .localidad("Ciudad")
                    .build();
            //agregar domicilios a cliente
            cliente1.agregarDomicilio(domicilio1);
            cliente1.agregarDomicilio(domicilio2);

            //configuracion fecha
            SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
            String fechaString = "2023-09-16";
            // Parsear la cadena en un objeto Date
            Date fecha = formatoFecha.parse(fechaString);
            //Crear Instancia Pedido
            Pedido pedido1 = Pedido.builder()
                    .fecha(fecha)
                    .total(7000)
                    .estado(Estado.Entregado)
                    .tipoEnvio(TipoEnvio.Delivery)
                    .build();
            Pedido pedido2 = Pedido.builder()
                    .fecha(fecha)
                    .total(6300)
                    .estado(Estado.Entregado)
                    .tipoEnvio(TipoEnvio.Delivery)
                    .build();
            //Crear instancias de factura
            Factura factura1 = Factura.builder()
                    .fecha(fecha)
                    .total(6600)
                    .numero(1)
                    .dto(400)
                    .formaPago(FormaPago.Efectivo)
                    .build();
            Factura factura2 = Factura.builder()
                    .fecha(fecha)
                    .total(6000)
                    .numero(2)
                    .dto(300)
                    .formaPago(FormaPago.Efectivo)
                    .build();

            //agregar pedidos al cliente
            cliente1.agregarPedido(pedido1);
            cliente1.agregarPedido(pedido2);

            //vincular factura con pedido
            pedido1.setFactura(factura1);
            pedido2.setFactura(factura2);
            //guardar cliente
            clienteRepository.save(cliente1);

            //recuperar objeto rubro desde la base de datos
            Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
            if (rubroRecuperado != null){
                System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
                rubroRecuperado.mostrarProductos();
            }
            //recuperar Cliente desde la base de Datos
            Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
            if (clienteRecuperado != null){
                System.out.println("Nombre: " + clienteRecuperado.getNombre());
                System.out.println("Apellido: " + clienteRecuperado.getApellido());
                System.out.println("Mail: " + clienteRecuperado.getMail());
                System.out.println("Telefono: " + clienteRecuperado.getTelefono());
                System.out.println("----------------------------------------");
                clienteRecuperado.mostrarDomicilios();
                clienteRecuperado.mostrarPedidos();

            }

        };
    }
}