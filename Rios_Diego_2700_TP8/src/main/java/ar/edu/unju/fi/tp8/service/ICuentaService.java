package ar.edu.unju.fi.tp8.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp8.model.Cuenta;

public interface ICuentaService {
	
	public void addCuenta(Cuenta cuenta);
	public Cuenta getCuenta();
	public List<Cuenta> getCuentas();
	Optional<Cuenta> obtenerCuenta(Long id);
	public void eliminarCuenta(Long id);
}
