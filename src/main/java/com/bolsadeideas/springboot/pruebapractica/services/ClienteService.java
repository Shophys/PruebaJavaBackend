package com.bolsadeideas.springboot.pruebapractica.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.pruebapractica.ClienteBadRequest;
import com.bolsadeideas.springboot.pruebapractica.ClienteInternalError;
import com.bolsadeideas.springboot.pruebapractica.ClienteNotFound;
import com.bolsadeideas.springboot.pruebapractica.models.Cliente;
import com.bolsadeideas.springboot.pruebapractica.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ArrayList<Cliente> obtenerClientes() {
		return (ArrayList<Cliente>) clienteRepository.findAll();
	}
	
	public Cliente guardarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> obtenerPorId (Long id) {
		return clienteRepository.findById(id);
	}
	
	public boolean eliminarCliente (Long id) {
		try {
			clienteRepository.deleteById(id);
			return true;
		}
		catch (Exception err) {
			return false;
		}
	}

	@Transactional (readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	public Cliente obtenerCliente(String tipoDocumento, long numeroDocumento) {
				
			if(!(tipoDocumento.equals("C") || tipoDocumento.equals("P"))) {
				throw new ClienteBadRequest("Error tipo Documento");
					// Retornar bad request 400
			}
			if (numeroDocumento == 23445322 && tipoDocumento.equals("C")) {
				Cliente cliente = new Cliente();
				cliente.setNumeroDocumento((long) 23445322);
				cliente.setPrimerNombre("Maria");
				cliente.setSegundoNombre("José");
				cliente.setPrimerApellido("Alvarez");
				cliente.setSegundoApellido("Triana");
				cliente.setCiudadResidencia("Bogotá");
				cliente.setTelefono(1234567912);
				cliente.setDireccion("Carrera 56 No. 4C-25");
				cliente.setTipoDocumento("C");
				
				return cliente;
			}
			throw new ClienteNotFound("Cliente No Encontrado");
					//Retornar Resource not found 404
			}

}
