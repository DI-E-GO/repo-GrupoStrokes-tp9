package ar.edu.unju.fi.tp8.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp8.model.Beneficio;

public interface IBeneficioService {
	public Beneficio getBeneficio();
	public List<Beneficio> getBeneficios();
	Optional<Beneficio> getBeneficio(Long id);
	public Beneficio getBeneficioPorDescripcion(String descripcion);
	public List<Beneficio> listaBeneficiosAgregados();
	public void agregarBeneficioListaBeneficiosAgregados(Beneficio beneficio);
	public void quitarBeneficioListaBeneficiosAgregados(Long id);
}
