package ar.edu.unju.fi.tp8.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Cuenta;
import ar.edu.unju.fi.tp8.repository.ICuentaRepository;
import ar.edu.unju.fi.tp8.service.ICuentaService;

@Service("cuentaServiceMysql")
public class CuentaServiceMysqlImp implements ICuentaService {
	
	@Autowired
	ICuentaRepository cuentaRepository;
	
	@Autowired
	Cuenta cuenta;

	@Override
	public void addCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuentaRepository.save(cuenta);
	}

	@Override
	public Cuenta getCuenta() {
		// TODO Auto-generated method stub
		return cuenta;
	}

	@Override
	public List<Cuenta> getCuentas() {
		// TODO Auto-generated method stub
		List<Cuenta> cuentas = cuentaRepository.findAll();
		return cuentas;
	}

	@Override
	public Optional<Cuenta> obtenerCuenta(Long id) {
		// TODO Auto-generated method stub
		return cuentaRepository.findById(id);
	}

	@Override
	public void eliminarCuenta(Long id) {
		// TODO Auto-generated method stub
		cuentaRepository.deleteById(id);
	}


}
