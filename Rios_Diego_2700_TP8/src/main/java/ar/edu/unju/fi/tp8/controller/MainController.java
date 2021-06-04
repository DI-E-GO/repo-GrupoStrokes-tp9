package ar.edu.unju.fi.tp8.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp8.model.Cliente;
import ar.edu.unju.fi.tp8.model.Producto;
import ar.edu.unju.fi.tp8.service.IClienteService;
import ar.edu.unju.fi.tp8.service.IProductoService;
@Controller
public class MainController {
	@Autowired
	@Qualifier("clienteServiceMysql")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("productoServiceMysql")
	private IProductoService productoService;
	
	@GetMapping("/home")
	public String getIndex(Model model) {
		model.addAttribute(model);
		return "index";
	}
	
	@GetMapping("/cliente/nuevo")
	public String getNuevoClientePage(Model model) {
		model.addAttribute("productos", productoService.listaProductos());
		model.addAttribute(clienteService.getCliente());
		return "nuevo-cliente";
	}
	@PostMapping("/cliente/guardar")
	public ModelAndView proccesFormCliente(@Valid @ModelAttribute("cliente") Cliente unCliente, BindingResult resultadoValidacion) {
		ModelAndView modelView;
		if (resultadoValidacion.hasErrors()) {
			modelView = new ModelAndView("nuevo-cliente");
			return modelView;
		} else {
			modelView = new ModelAndView("resultado-cliente");
			long edad = ChronoUnit.YEARS.between(unCliente.getFechaNacimiento(), LocalDate.now());
			unCliente.setEdad((int)edad);
			clienteService.addCliente(unCliente);
			return modelView;
		}
	}
	@GetMapping("/cliente/listado")
	public ModelAndView getClientesPage() {
		ModelAndView model = new ModelAndView("table-clientes");
		if (clienteService.getClientes()==null) {
			clienteService.generateTableClientes();
		}
		model.addObject("clientes",clienteService.getClientes());
		return model;
	}
	@GetMapping("/cliente/editar/{id}")
	public String editarCliente(@PathVariable Long id, Model model) {
		Optional<Cliente> cliente = clienteService.getCliente(id);
		model.addAttribute("cliente", cliente);
		return "nuevo-cliente";
	}
	@GetMapping("/cliente/borrar/{id}")
	public String borrarCliente(@PathVariable Long id, Model model) {
		clienteService.eliminarCliente(id);
		return "redirect:/cliente/listado";
	}
	
	
	
	/*
	 * Producto Controller
	 */
	@GetMapping("/producto/nuevo")
	public String getNuevoPage(Model model) {
		model.addAttribute(productoService.getProducto());
		return "nuevo-producto";
	}
	
	@PostMapping("/producto/guardar")
	public ModelAndView proccesForm(@Valid @ModelAttribute("producto") Producto unProducto, BindingResult resultadoValidacion) {
		ModelAndView modelView;
		if (resultadoValidacion.hasErrors()) {
			modelView = new ModelAndView("nuevo-producto");
			return modelView;
		} else {
			modelView = new ModelAndView("resultado-producto");
			productoService.addProducto(unProducto);
			return modelView;
		}
	}
	
	@GetMapping("/producto/ultimo")
	public ModelAndView getUltimoProductoPage() {
		ModelAndView modelView = new ModelAndView("ultimo-producto");
		
		  if (productoService.listaProductos().isEmpty()) { 
			  Producto primero = new Producto(0, null, 0, null, 0);
			  productoService.addProducto(primero);
		  }
		 
		modelView.addObject("producto", productoService.getUltimoProducto());
		return modelView;
	}
}
