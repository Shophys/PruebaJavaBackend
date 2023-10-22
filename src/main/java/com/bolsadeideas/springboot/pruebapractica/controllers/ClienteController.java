package com.bolsadeideas.springboot.pruebapractica.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.pruebapractica.ClienteBadRequest;
import com.bolsadeideas.springboot.pruebapractica.ClienteInternalError;
import com.bolsadeideas.springboot.pruebapractica.ClienteNotFound;
import com.bolsadeideas.springboot.pruebapractica.models.Cliente;
import com.bolsadeideas.springboot.pruebapractica.models.TipoDocumento;
import com.bolsadeideas.springboot.pruebapractica.services.ClienteService;

@Controller
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	//Logger logger = LoggerFactory.getLogger(ClienteController.class);
	private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	
	@GetMapping("/detalle")
	public String detalle(Model model) {
		
		Cliente cliente = new Cliente();
		cliente.setPrimerNombre("Maria");
		cliente.setSegundoNombre("José");
		cliente.setPrimerApellido("Alvarez");
		cliente.setSegundoApellido("Triana");
		cliente.setCiudadResidencia("Bogotá");
		cliente.setTelefono(1234567912);
		cliente.setDireccion("Carrera56No.4C-25");
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Detalle Información: ".concat(cliente.getPrimerNombre()));
		
		return "detalle";		
		
	}
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
	@GetMapping()
	public Cliente obtenerCliente(String tipoDocumento, Long numeroDocumento) {
		
		logger.info("Llamado al método obtener cliente");
		
		try {
			
			ClienteService clienteService = new ClienteService();
			return clienteService.obtenerCliente(tipoDocumento, numeroDocumento);
		}
		catch (ClienteBadRequest e) {
			throw e;
		}
		
		catch (ClienteNotFound e) {
			throw new ClienteNotFound("Cliente No Encontrado");
		}
		catch (Exception e) {
			throw new ClienteInternalError("Se ha presentado un error");
			//Return 500 server error
		}
	} 
		
	@ModelAttribute("TipoDocumento")
	public List<TipoDocumento> tipoDocumento() {
		TipoDocumento cedula= new TipoDocumento();
		cedula.setCodigo("C");
		cedula.setNombre("Cédula de Ciudadanía");
		TipoDocumento pasaporte= new TipoDocumento();
		pasaporte.setCodigo("P");
		pasaporte.setNombre("Pasaporte");
		
		List<TipoDocumento> lista = new ArrayList<>();
		lista.add(cedula);
		lista.add(pasaporte);
		return lista;
	}
	
		
	}
