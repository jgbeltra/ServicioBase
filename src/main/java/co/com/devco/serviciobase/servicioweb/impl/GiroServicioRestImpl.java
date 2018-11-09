package co.com.devco.serviciobase.servicioweb.impl;

import static javax.ws.rs.core.Response.Status.CREATED;

import javax.ws.rs.core.Response;
import java.util.function.Function;

import co.com.devco.serviciobase.modelo.Transaccion;
import co.com.devco.serviciobase.servicio.GiroServicio;
import co.com.devco.serviciobase.servicioweb.GiroServicioRest;
import co.com.devco.serviciobase.servicioweb.mapeador.GiroServicioRestMapeador;
import co.com.devco.serviciobase.servicioweb.recurso.TransaccionRecurso;
import org.springframework.stereotype.Service;

@Service
public class GiroServicioRestImpl implements GiroServicioRest {

    private Function<Transaccion, TransaccionRecurso> convertirARecurso = GiroServicioRestMapeador::convertirARecurso;

    private GiroServicio giroServicio;

    public GiroServicioRestImpl(GiroServicio giroServicio) {
        this.giroServicio = giroServicio;
    }

    @Override
    public Response consultarGiro(String idTransaccion, String fechaInicio, String fechaFin) throws Exception {

        Transaccion transaccion = giroServicio.consultarGiro(idTransaccion, fechaInicio, fechaFin);

        System.out.print("Esto representa un primer cambio");


        if (transaccion != null) {
            TransaccionRecurso transaccionRecurso = convertirARecurso.apply(transaccion);
            return Response.status(CREATED).entity(transaccionRecurso).build();
        } else {
            throw new Exception("No fue posible obtener el recurso");
        }
    }
}
