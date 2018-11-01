package co.com.devco.serviciobase.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

import co.com.devco.serviciobase.dao.GiroDAO;
import co.com.devco.serviciobase.dao.mapeador.GiroDAOMapeador;
import co.com.devco.serviciobase.dao.modelo.TransaccionExterna;
import co.com.devco.serviciobase.modelo.Transaccion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GiroDAOImpl.class, GiroDAOMapeador.class})
public class GiroDAOImplTest {

    @Mock
    private TransaccionExterna mockTransaccionExterna;

    @Mock
    private Transaccion mockTransaccion;

    private GiroDAO giroDAO = spy(new GiroDAOImpl());

    @Before
    public void setup() {
        mockStatic(GiroDAOImpl.class, GiroDAOMapeador.class);
    }

    @Test
    public void testCuandoUnaTransaccionExternaEsNullEntoncesElResultadoDeLaTransaccionEsNulo() throws Exception {
        when(giroDAO, "consultarGiroExterno").thenReturn(null);
        when(GiroDAOMapeador.mapear(any())).thenReturn(null);
        Transaccion resultado = giroDAO.consultarGiro();
        assertNull(resultado);
    }

    @Test
    public void testCuandoLaTransaccionExternaNoEsNuloEntoncesElResultadoDeLaTransaccionNoEsNulo() throws Exception {
        when(giroDAO, "consultarGiroExterno").thenReturn(mockTransaccionExterna);
        when(GiroDAOMapeador.mapear(any())).thenReturn(mockTransaccion);
        Transaccion resultado = giroDAO.consultarGiro();
        assertNotNull(resultado);
    }
}
