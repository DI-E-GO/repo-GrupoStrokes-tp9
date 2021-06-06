package ar.edu.unju.fi.tp8.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Beneficio;
import ar.edu.unju.fi.tp8.service.IBeneficioService;
@Service("beneficioUtilService")
public class BeneficioServiceImp implements IBeneficioService {

	@Override
	public Beneficio getBeneficio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beneficio> getBeneficios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Beneficio> getBeneficio(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beneficio> listaBeneficiosAgregados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarBeneficioListaBeneficiosAgregados(Beneficio beneficio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Beneficio getBeneficioPorDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void quitarBeneficioListaBeneficiosAgregados(Long id) {
		// TODO Auto-generated method stub
		
	}
}
