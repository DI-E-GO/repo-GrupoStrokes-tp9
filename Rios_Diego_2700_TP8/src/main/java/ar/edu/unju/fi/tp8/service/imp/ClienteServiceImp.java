/**
 * 
 */
package ar.edu.unju.fi.tp8.service.imp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Cliente;
import ar.edu.unju.fi.tp8.service.IClienteService;
import ar.edu.unju.fi.tp8.util.TableClientes;

/**
 * @author Diego
 *
 */
@Service("clienteUtilService")
public class ClienteServiceImp implements IClienteService {
	private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);
	@Autowired
	@Qualifier("unCliente")
	private Cliente cliente;
	
	private List<Cliente> clientes;
	@Override
	public Cliente getCliente() {
		LOGGER.info("SERVICE: IClienteService -> ClienteServiceImp");
		LOGGER.info("METHOD: getCliente()");
		LOGGER.info("RESULT: a object Cliente");
		// TODO Auto-generated method stub
		return cliente;
	}
	@Override
	public void addCliente(Cliente cliente) {
		clientes=TableClientes.registros;
		clientes.add(cliente);
		LOGGER.info("SERVICE: IClienteService -> ClienteServiceImp");
		LOGGER.info("METHOD: addCliente(Cliente cliente)");
		LOGGER.info("RESULT: add a new object to list of type Cliente");
		LOGGER.info(cliente);
	}
	@Override
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		LOGGER.info("SERVICE: IClienteService -> ClienteServiceImp");
		LOGGER.info("METHOD: getClientes()");
		LOGGER.info("RESULT: a list of Cliente");
		return clientes;
	}
	@Override
	public void generateTableClientes() {
		clientes=TableClientes.registros;
		//clientes.add(new Cliente("DNI", (long) 45433210,"Diego Rios" , "diego@gmail.com", "1234cinco", LocalDate.of(1990, 8, 20), 30, 388, 562134, LocalDate.of(2020, 12, 12), null));
	}
	@Override
	public Optional<Cliente> getCliente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarCliente(Long id) {
		// TODO Auto-generated method stub
		
	}

}
