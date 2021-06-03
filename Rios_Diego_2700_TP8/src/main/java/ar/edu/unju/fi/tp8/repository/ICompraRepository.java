package ar.edu.unju.fi.tp8.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp8.model.Compra;

public interface ICompraRepository extends CrudRepository<Compra, Long> {

	
	public List<Compra> findAll();
	Optional<Compra> findById(Long id);
	//Funcion para buscar por nombre y monto
	public List<Compra> findByProductoNombreAndTotalGreaterThanEqual(String nombre, double total);
	//Funcion para buscar compras por monto
	public List<Compra> findByTotalGreaterThanEqual(double total);
}	
