package co.com.devco.serviciobase.dao.mapeador;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import co.com.devco.serviciobase.dao.modelo.TransaccionExterna;
import co.com.devco.serviciobase.modelo.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class GiroDAOMapeadorMockTest {

    @Mock
    private Grupo mockGrupoOrigen;

    @Mock
    private Grupo mockGrupoDestino;

    @Mock
    private Oficina mockOficinaOrigen;

    @Mock
    private Oficina mockOficinaDestino;

    @Mock
    private TipoDocumento mockTipoDocumentoCompaniaOrigen;

    @Mock
    private TipoDocumento mockTipoDocumentoCompaniaDestino;

    @Mock
    private TipoDocumento mockTipoDocumentoRemitente;

    @Mock
    private TipoDocumento mockTipoDocumentoDestinatario;

    @Mock
    private TipoDocumento mockTipoDocumentoRepresentanteOrigen;

    @Mock
    private TipoDocumento mockTipoDocumentoRepresentanteDestino;

    @Mock
    private Direccion mockDireccionCompaniaOrigen;

    @Mock
    private Direccion mockDireccionCompaniaDestino;

    @Mock
    private Direccion mockDireccionRemitente;

    @Mock
    private Direccion mockDireccionDestinatario;

    @Mock
    private Direccion mockDireccionOficinaOrigen;

    @Mock
    private Direccion mockDireccionOficinaDestino;

    @Mock
    private Direccion mockDireccionRepresentanteOrigen;

    @Mock
    private Direccion mockDireccionRepresentanteDestino;

    @Mock
    private TransaccionExterna mockTransaccionExterna;

    @Mock
    private Ubicacion mockUbicacionOrigen;

    @Mock
    private Ubicacion mockUbicacionDestino;

    @Mock
    private Persona mockCompaniaOrigen;

    @Mock
    private Persona mockCompaniaDestino;

    @Mock
    private Persona mockRemitente;

    @Mock
    private Persona mockDestinatario;

    @Mock
    private Persona mockRepresentanteOrigen;

    @Mock
    private Persona mockRepresentanteDestino;

    @Mock
    private Movimiento mockMovimiento;

    @Before
    public void setup(){
        cargaDatosPrueba();
    }


    @Test
    public void testCuandoEsUnaTransaccionExternaValidaEntoncesLaRespuestaDebeSer(){
        Transaccion resultado = GiroDAOMapeador.mapear(mockTransaccionExterna);

        assertNotNull(resultado.getUbicacionOrigen());
        assertNotNull(resultado.getUbicacionDestino());
        assertNotNull(resultado.getCompaniaOrigen());
        assertNotNull(resultado.getCompaniaDestino());
        assertNotNull(resultado.getRemitente());
        assertNotNull(resultado.getDestinatario());
        assertNotNull(resultado.getFecha());
        assertNotNull(resultado.getTipoEstado());
        assertNotNull(resultado.getValor());
    }

    private void cargaDatosPrueba() {
        //ubicacion origen
        when(mockUbicacionOrigen.getIdentificador()).thenReturn("1234");
        when(mockUbicacionOrigen.getNombre()).thenReturn("MEDELLIN");
        when(mockUbicacionOrigen.getTipoUbicacion()).thenReturn(TipoUbicacion.CIUDAD);

        //ubicacion destino
        when(mockUbicacionDestino.getIdentificador()).thenReturn("1234");
        when(mockUbicacionDestino.getNombre()).thenReturn("CALI");
        when(mockUbicacionDestino.getTipoUbicacion()).thenReturn(TipoUbicacion.CIUDAD);

        //--------- compania origen ---------//

        //tipo documento
        when(mockTipoDocumentoCompaniaOrigen.getCodigo()).thenReturn("123");
        when(mockTipoDocumentoCompaniaOrigen.getDescripcion()).thenReturn("NIT");

        //direccion
        when(mockDireccionCompaniaOrigen.getIdentificador()).thenReturn("1234");
        when(mockDireccionCompaniaOrigen.getDescripcion()).thenReturn("CALLE 45 # 30 - 20");
        when(mockDireccionCompaniaOrigen.getTipoEstado()).thenReturn(TipoEstado.DISPONIBLE);

        when(mockCompaniaOrigen.getTipoDocumento()).thenReturn(mockTipoDocumentoCompaniaOrigen);
        when(mockCompaniaOrigen.getIdentificador()).thenReturn("123.222.777-8");
        when(mockCompaniaOrigen.getRazonSocial()).thenReturn("GIROS NACIONALES S.A");
        when(mockCompaniaOrigen.getDireccion()).thenReturn(mockDireccionCompaniaOrigen);

        //--------- compania destino ---------//

        //tipo documento
        when(mockTipoDocumentoCompaniaDestino.getCodigo()).thenReturn("123");
        when(mockTipoDocumentoCompaniaDestino.getDescripcion()).thenReturn("NIT");

        //direccion
        when(mockDireccionCompaniaDestino.getIdentificador()).thenReturn("5678");
        when(mockDireccionCompaniaDestino.getDescripcion()).thenReturn("CRA 53 A # 45 - 10");
        when(mockDireccionCompaniaDestino.getTipoEstado()).thenReturn(TipoEstado.DISPONIBLE);

        when(mockCompaniaDestino.getTipoDocumento()).thenReturn(mockTipoDocumentoCompaniaDestino);
        when(mockCompaniaDestino.getIdentificador()).thenReturn("456.222.333-8");
        when(mockCompaniaDestino.getRazonSocial()).thenReturn("MEDELLIN GIROS S.A");
        when(mockCompaniaDestino.getDireccion()).thenReturn(mockDireccionCompaniaDestino);

        //--------- remitente ---------//

        //tipo documento
        when(mockTipoDocumentoRemitente.getCodigo()).thenReturn("456");
        when(mockTipoDocumentoRemitente.getDescripcion()).thenReturn("CEDULA");

        //direccion
        when(mockDireccionRemitente.getIdentificador()).thenReturn("12345");
        when(mockDireccionRemitente.getDescripcion()).thenReturn("CALLE 8 # 10 - 10");
        when(mockDireccionRemitente.getTipoEstado()).thenReturn(TipoEstado.DISPONIBLE);

        when(mockRemitente.getIdentificador()).thenReturn("1234");
        when(mockRemitente.getNombres()).thenReturn("JOHAN");
        when(mockRemitente.getApellidos()).thenReturn("BELTRAN");
        when(mockRemitente.getGenero()).thenReturn("M");
        when(mockRemitente.getTipoDocumento()).thenReturn(mockTipoDocumentoRemitente);
        when(mockRemitente.getDireccion()).thenReturn(mockDireccionRemitente);

        //--------- destinatario ---------//

        //tipo documento
        when(mockTipoDocumentoDestinatario.getCodigo()).thenReturn("456");
        when(mockTipoDocumentoDestinatario.getDescripcion()).thenReturn("CEDULA");

        //direccion
        when(mockDireccionDestinatario.getIdentificador()).thenReturn("98098");
        when(mockDireccionDestinatario.getDescripcion()).thenReturn("CALLE 30 # 20 - 10");
        when(mockDireccionDestinatario.getTipoEstado()).thenReturn(TipoEstado.DISPONIBLE);

        when(mockDestinatario.getIdentificador()).thenReturn("56789");
        when(mockDestinatario.getNombres()).thenReturn("JENNIFER");
        when(mockDestinatario.getApellidos()).thenReturn("PEREZ");
        when(mockDestinatario.getGenero()).thenReturn("F");
        when(mockDestinatario.getTipoDocumento()).thenReturn(mockTipoDocumentoDestinatario);
        when(mockDestinatario.getDireccion()).thenReturn(mockDireccionDestinatario);

        //--------- historial movimiento ---------//

        //oficina origen
        when(mockDireccionRepresentanteOrigen.getIdentificador()).thenReturn("71717");
        when(mockDireccionRepresentanteOrigen.getDescripcion()).thenReturn("CALLE EL POBLADO");
        when(mockDireccionRepresentanteOrigen.getTipoEstado()).thenReturn(TipoEstado.DISPONIBLE);

        when(mockTipoDocumentoRepresentanteOrigen.getCodigo()).thenReturn("456");
        when(mockTipoDocumentoRepresentanteOrigen.getDescripcion()).thenReturn("CEDULA");

        when(mockRepresentanteOrigen.getIdentificador()).thenReturn("22121212");
        when(mockRepresentanteOrigen.getNombres()).thenReturn("ERNESTO");
        when(mockRepresentanteOrigen.getApellidos()).thenReturn("PEREA");
        when(mockRepresentanteOrigen.getGenero()).thenReturn("M");
        when(mockRepresentanteOrigen.getTipoDocumento()).thenReturn(mockTipoDocumentoRepresentanteOrigen);
        when(mockRepresentanteOrigen.getDireccion()).thenReturn(mockDireccionRepresentanteOrigen);

        when(mockGrupoOrigen.getIdentificador()).thenReturn("1111");
        when(mockGrupoOrigen.getNombre()).thenReturn("GRUPO MEDELLIN S.A");
        when(mockGrupoOrigen.getRepresentante()).thenReturn(mockRepresentanteOrigen);

        when(mockDireccionOficinaOrigen.getIdentificador()).thenReturn("324234");
        when(mockDireccionOficinaOrigen.getDescripcion()).thenReturn("AV 80 # 1");
        when(mockDireccionOficinaOrigen.getTipoEstado()).thenReturn(TipoEstado.DISPONIBLE);

        when(mockOficinaOrigen.getIdentificador()).thenReturn("1234");
        when(mockOficinaOrigen.getNombre()).thenReturn("MEDELLIN LA 80");
        when(mockOficinaOrigen.getDireccion()).thenReturn(mockDireccionOficinaOrigen);
        when(mockOficinaOrigen.getGrupo()).thenReturn(mockGrupoOrigen);

        //oficina destino
        when(mockDireccionRepresentanteDestino.getIdentificador()).thenReturn("21313");
        when(mockDireccionRepresentanteDestino.getDescripcion()).thenReturn("CALLE 33 # 4 - 6");
        when(mockDireccionRepresentanteDestino.getTipoEstado()).thenReturn(TipoEstado.DISPONIBLE);

        when(mockTipoDocumentoRepresentanteDestino.getCodigo()).thenReturn("456");
        when(mockTipoDocumentoRepresentanteDestino.getDescripcion()).thenReturn("CEDULA");

        when(mockRepresentanteDestino.getIdentificador()).thenReturn("1123123");
        when(mockRepresentanteDestino.getNombres()).thenReturn("VIVIANA");
        when(mockRepresentanteDestino.getApellidos()).thenReturn("GOMEZ");
        when(mockRepresentanteDestino.getGenero()).thenReturn("F");
        when(mockRepresentanteDestino.getTipoDocumento()).thenReturn(mockTipoDocumentoRepresentanteDestino);
        when(mockRepresentanteDestino.getDireccion()).thenReturn(mockDireccionRepresentanteDestino);

        when(mockGrupoDestino.getIdentificador()).thenReturn("111115");
        when(mockGrupoDestino.getNombre()).thenReturn("GRUPO DE CALI S.A");
        when(mockGrupoDestino.getRepresentante()).thenReturn(mockRepresentanteDestino);

        when(mockDireccionOficinaDestino.getIdentificador()).thenReturn("22242342");
        when(mockDireccionOficinaDestino.getDescripcion()).thenReturn("CALLE 14 # 50 - 50");
        when(mockDireccionOficinaDestino.getTipoEstado()).thenReturn(TipoEstado.DISPONIBLE);

        when(mockOficinaDestino.getIdentificador()).thenReturn("232342");
        when(mockOficinaDestino.getNombre()).thenReturn("CALI EL GUABAL");
        when(mockOficinaDestino.getDireccion()).thenReturn(mockDireccionOficinaDestino);
        when(mockOficinaDestino.getGrupo()).thenReturn(mockGrupoDestino);

        when(mockMovimiento.getFechaInicio()).thenReturn("2018-07-18");
        when(mockMovimiento.getFechaFin()).thenReturn("2018-07-18");
        when(mockMovimiento.getEstadoInicio()).thenReturn(TipoEstado.BORRADOR);
        when(mockMovimiento.getEstadoFin()).thenReturn(TipoEstado.CREADO);
        when(mockMovimiento.getOficinaOrigen()).thenReturn(mockOficinaOrigen);
        when(mockMovimiento.getOficinaDestino()).thenReturn(mockOficinaDestino);
        when(mockMovimiento.getCliente()).thenReturn(null);

        //
        when(mockTransaccionExterna.getFecha()).thenReturn("2018-07-18");
        when(mockTransaccionExterna.getTipoEstado()).thenReturn(TipoEstado.DISPONIBLE);
        when(mockTransaccionExterna.getValor()).thenReturn(100000);
        when(mockTransaccionExterna.getUbicacionOrigen()).thenReturn(mockUbicacionOrigen);
        when(mockTransaccionExterna.getUbicacionDestino()).thenReturn(mockUbicacionDestino);
        when(mockTransaccionExterna.getCompaniaOrigen()).thenReturn(mockCompaniaOrigen);
        when(mockTransaccionExterna.getCompaniaDestino()).thenReturn(mockCompaniaDestino);
        when(mockTransaccionExterna.getRemitente()).thenReturn(mockRemitente);
        when(mockTransaccionExterna.getDestinatario()).thenReturn(mockDestinatario);
        when(mockTransaccionExterna.getHistorialMovimientos()).thenReturn(Arrays.asList(mockMovimiento));
    }

}
