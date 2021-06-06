package ar.edu.unju.fi.tp8.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp8.model.Beneficio;
import ar.edu.unju.fi.tp8.model.Cliente;
import ar.edu.unju.fi.tp8.model.Cuenta;
import ar.edu.unju.fi.tp8.service.IBeneficioService;

@Controller
public class BeneficioController {
	@Autowired
	Cliente cliente;
	
	@Autowired
	Cuenta cuenta;
	
	@Autowired
	Beneficio beneficio;
	
	@Autowired
	@Qualifier("beneficioServiceMysql")
	IBeneficioService beneficioService;
	
	@GetMapping("/beneficio/agregar")
	public String agregarBeneficios(@RequestParam( name = "descripcion")String descripcion, Model model, @ModelAttribute(name = "beneficio")Beneficio beneficio) {
		Beneficio beneficioParaAgegar = beneficioService.getBeneficioPorDescripcion(descripcion);
		beneficioService.agregarBeneficioListaBeneficiosAgregados(beneficioParaAgegar);
		model.addAttribute("beneficiosAgregados", beneficioService.listaBeneficiosAgregados());
		model.addAttribute("beneficios", beneficioService.getBeneficios());
		model.addAttribute("cliente", cliente);
		return "nuevo-cliente";
	}
	
	@GetMapping("/beneficio/quitaropcion/{id}")
	public ModelAndView quitarOpcionListaBeneficios(@PathVariable(name = "id")Long id) {
		ModelAndView modelView = new ModelAndView("nuevo-cliente");
		beneficioService.quitarBeneficioListaBeneficiosAgregados(id);
		modelView.addObject("beneficio", beneficio);
		modelView.addObject("cliente", cliente);
		modelView.addObject("cuenta", cuenta);
		modelView.addObject("beneficios", beneficioService.getBeneficios());
		modelView.addObject("beneficiosAgregados", beneficioService.listaBeneficiosAgregados());
		return modelView;
	}
}
