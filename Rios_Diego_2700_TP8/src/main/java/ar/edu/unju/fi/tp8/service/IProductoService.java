package ar.edu.unju.fi.tp8.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp8.model.Producto;

public interface IProductoService {
	public void addProducto(Producto producto);
	public Producto getUltimoProducto();
	public Producto getProducto();
	public List<Producto> listaProductos();
	public void eliminarProducto(Long codigo);
	Optional<Producto> getProducto(Long codigo);
}
