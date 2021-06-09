package ar.edu.unju.fi.tp8.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Cliente;
import ar.edu.unju.fi.tp8.repository.IClienteRepository;
import ar.edu.unju.fi.tp8.service.IClienteService;

@Service("clienteServiceMysql")
public class ClienteServiceMysqlImp implements IClienteService{
	
	@Autowired
	IClienteRepository clienteRepository;
	
	@Autowired
	Cliente cliente;


	@Override
	public void addCliente(Cliente cliente) {
		/*
		 * BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		 * cliente.setPassword(bCryptPasswordEncoder.encode(cliente.getPassword()));
		 */
		clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}

	@Override
	public void generateTableClientes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Cliente> getCliente(Long id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return cliente;
	}

	@Override
	public void eliminarCliente(Long id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	

}
