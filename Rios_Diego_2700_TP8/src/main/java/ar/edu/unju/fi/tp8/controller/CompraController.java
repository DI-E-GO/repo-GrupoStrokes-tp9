package ar.edu.unju.fi.tp8.controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp8.model.Compra;
import ar.edu.unju.fi.tp8.model.Producto;
import ar.edu.unju.fi.tp8.service.ICompraService;
import ar.edu.unju.fi.tp8.service.IProductoService;

@Controller
public class CompraController {
	@Autowired
	@Qualifier("compraServiceMysql")
	private ICompraService compraService;
	
	@Autowired
	@Qualifier("productoServiceMysql")
	private IProductoService productoService;
	List<Producto> productos = new ArrayList<>();
	
	@GetMapping("/compra/nuevo")
	public String getNuevaCompraPage(Model model) {
		this.productos=productoService.listaProductos();
		model.addAttribute(compraService.getCompra());
		model.addAttribute("productos", productos);
		return "nueva-compra";
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView proccesFormCompra(Model model, @Valid @ModelAttribute("compra") Compra unaCompra, BindingResult resultadoValidacion) {
		ModelAndView modelView;
		if (resultadoValidacion.hasErrors()) {
			model.addAttribute("productos", productoService.listaProductos());
			modelView = new ModelAndView("nueva-compra");
			return modelView;
		} else {
			modelView = new ModelAndView("resultado-compra");
			Producto aux = new Producto();
			for (Producto producto : productos) {
				if (unaCompra.getProducto().getCodigo()==producto.getCodigo()) {
					aux=producto;
				}
			}
			unaCompra.setProducto(aux);
			unaCompra.setTotal(unaCompra.getCantidad()*unaCompra.getProducto().getPrecio());
			compraService.addCompra(unaCompra);
			return modelView;
		}
	}
	
	@GetMapping("/compra/lista")
	public String getListaComprasPage(Model model) {
		model.addAttribute("compra", compraService.getCompra());
		model.addAttribute("compras", compraService.getCompras());
		return "table-compras";
	}
	
	@GetMapping("/compra/editar/{id}")
	public ModelAndView editarCompra(@PathVariable Long id, Model model) {
		this.productos=productoService.listaProductos();
		Optional<Compra> compra = compraService.getCompra(id);
		model.addAttribute("compra", compra);
		ModelAndView editCompra = new ModelAndView("nueva-compra");
		editCompra.addObject("productos",productos);
		return editCompra;
	}
	
	@GetMapping("/compra/borrar/{id}")
	public String borrarCompra(@PathVariable Long id, Model model) {
		compraService.eliminarCompra(id);
		return "redirect:/compra/lista";
	}
	
	@GetMapping("/compra/busqueda")
	public String getComprasFiltradas(@RequestParam(name="total") double total, Model model, @ModelAttribute(name="compra")Compra compra) {
		model.addAttribute("compra",compraService.getCompra());
		model.addAttribute("compras", compraService.buscarCompras(compra.getProducto().getNombre(), total));
		return "table-compras";
	}
}
