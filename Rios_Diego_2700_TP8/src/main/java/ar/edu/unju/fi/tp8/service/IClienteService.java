/**
 * 
 */
package ar.edu.unju.fi.tp8.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp8.model.Cliente;

/**
 * @author Diego
 *
 */
public interface IClienteService {
	public Cliente getCliente();
	public void addCliente(Cliente cliente);
	public List<Cliente> getClientes();
	public void generateTableClientes();
	Optional<Cliente> getCliente(Long id);
	public void eliminarCliente(Long id);
}
