package ar.edu.unju.fi.tp8.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp8.model.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Long>{
	
	public List<Producto> findAll();
	public Optional<Producto> findById(Long codigo);
}
