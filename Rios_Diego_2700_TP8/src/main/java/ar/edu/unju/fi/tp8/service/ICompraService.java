package ar.edu.unju.fi.tp8.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp8.model.Compra;

public interface ICompraService {
	public Compra getCompra();
	public void addCompra(Compra compra);
	public List<Compra> getCompras();
	Optional<Compra> getCompra(Long id);
	public void eliminarCompra(Long id);
	public List<Compra> buscarCompras(String nombre, double total);
}
