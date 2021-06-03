package ar.edu.unju.fi.tp8.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp8.model.Cuenta;

public interface ICuentaRepository extends CrudRepository<Cuenta, Long>{
	
	public List<Cuenta> findAll();
	public Optional<Cuenta> findById(Long id);

}
