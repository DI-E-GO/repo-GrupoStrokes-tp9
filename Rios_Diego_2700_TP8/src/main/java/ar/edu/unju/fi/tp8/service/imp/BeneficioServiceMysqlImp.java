package ar.edu.unju.fi.tp8.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Beneficio;
import ar.edu.unju.fi.tp8.repository.IBeneficioRepository;
import ar.edu.unju.fi.tp8.service.IBeneficioService;
@Service("beneficioServiceMysql")
public class BeneficioServiceMysqlImp implements IBeneficioService {
	@Autowired
	IBeneficioRepository beneficioRepository;
	
	@Autowired
	Beneficio beneficio;
	
	List<Beneficio> beneficiosAgregados = new ArrayList<Beneficio>();
	
	@Override
	public Beneficio getBeneficio() {
		// TODO Auto-generated method stub
		return beneficio;
	}

	@Override
	public List<Beneficio> getBeneficios() {
		List<Beneficio> beneficios = beneficioRepository.findAll();
		return beneficios;
	}

	@Override
	public Optional<Beneficio> getBeneficio(Long id) {
		// TODO Auto-generated method stub
		return beneficioRepository.findById(id);
	}

	@Override
	public List<Beneficio> listaBeneficiosAgregados() {
		// TODO Auto-generated method stub
		return beneficiosAgregados;
	}

	@Override
	public void agregarBeneficioListaBeneficiosAgregados(Beneficio beneficio) {
		// TODO Auto-generated method stub
		boolean repetido=false;
		for (int i = 0; i < beneficiosAgregados.size(); i++) {
			if (beneficiosAgregados.get(i).getId()==beneficio.getId()) {
				repetido=true;
			}
		}
		if (!repetido) {
			beneficiosAgregados.add(beneficio);
		}
	}

	@Override
	public Beneficio getBeneficioPorDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return beneficioRepository.findByDescripcion(descripcion);
	}

	@Override
	public void quitarBeneficioListaBeneficiosAgregados(Long id) {
		for (int i = 0; i < beneficiosAgregados.size(); i++) {
			if (beneficiosAgregados.get(i).getId()==id) {
				beneficiosAgregados.remove(i);
			}
		}
	}
}
