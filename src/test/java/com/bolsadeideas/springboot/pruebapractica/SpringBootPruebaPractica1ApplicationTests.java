package com.bolsadeideas.springboot.pruebapractica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.bolsadeideas.springboot.pruebapractica.models.Cliente;
import com.bolsadeideas.springboot.pruebapractica.services.ClienteService;

@SpringBootTest
class SpringBootPruebaPractica1ApplicationTests {

	@Test
	void contextLoads() {
	}
 
	@Autowired
	private ClienteService clienteService;
	
	
	@Test
    public void testObtenerClienteExistente() {
        String tipoDocumento = "C";
        long numeroDocumento = 23445322;
        
        Cliente resultado = clienteService.obtenerCliente(tipoDocumento, numeroDocumento);

        // Realizar aserciones sobre el resultado
        Assertions.assertEquals(23445322, resultado.getNumeroDocumento());
        Assertions.assertEquals("Maria", resultado.getPrimerNombre());
       
    }
	
	
	@Test
    public void testObtenerClienteNoExistente() {
        String tipoDocumento = "P";
        long numeroDocumento = 12345678;
        
        Assertions.assertThrows(ClienteNotFound.class, () -> {
            clienteService.obtenerCliente(tipoDocumento, numeroDocumento);
        });
    }

}
