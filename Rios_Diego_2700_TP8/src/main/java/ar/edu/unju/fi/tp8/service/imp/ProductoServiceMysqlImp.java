package ar.edu.unju.fi.tp8.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Producto;
import ar.edu.unju.fi.tp8.repository.IProductoRepository;
import ar.edu.unju.fi.tp8.service.IProductoService;

@Service("productoServiceMysql")
public class ProductoServiceMysqlImp implements IProductoService{
	
	@Autowired
	IProductoRepository productoRepository;
	
	@Autowired
	Producto producto;

	@Override
	public void addProducto(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(producto);
	}

	@Override
	public Producto getUltimoProducto() {
		// TODO Auto-generated method stub
		List<Producto> listaProductos = productoRepository.findAll();
		int i = listaProductos.size();
		return listaProductos().get(i-1);
	}

	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return producto;
	}

	@Override
	public List<Producto> listaProductos() {
		// TODO Auto-generated method stub
		List<Producto> productos = productoRepository.findAll();
		return productos;
	}

	@Override
	public void eliminarProducto(Long codigo) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(codigo);
	}

	@Override
	public Optional<Producto> getProducto(Long codigo){
		return productoRepository.findById(codigo);
	}
}
