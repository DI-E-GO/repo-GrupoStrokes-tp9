package ar.edu.unju.fi.tp8.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Producto;
import ar.edu.unju.fi.tp8.service.IProductoService;

@Service("productoService")
public class ProductoServiceImp implements IProductoService {
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	@Autowired
	@Qualifier("unProducto")
	private Producto producto;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	List<Producto> productos = new ArrayList<Producto>();
	@Override
	public Producto getProducto() {
		LOGGER.info("SERVICE: IProductoService -> ProductoServiceImp");
		LOGGER.info("METHOD: getProducto()");
		LOGGER.info("RESULT: a object Producto");
		return producto;
	}
	@Override
	public Producto getUltimoProducto() {
		int indiceUltimoProducto = productos.size()-1;
		Producto producto = productos.get(indiceUltimoProducto);
		LOGGER.info("SERVICE: IProductoService -> ProductoServiceImp");
		LOGGER.info("METHOD: getUltimoProducto()");
		LOGGER.info("RESULT: a object Producto, the last element of a list of type Producto");
		LOGGER.info(producto);
		return producto;
	}
	@Override
	public void addProducto(Producto producto) {
		LOGGER.info("SERVICE: IProductoService -> ProductoServiceImp");
		LOGGER.info("METHOD: addProducto()");
		LOGGER.info("RESULT: add a new object to list of type Producto");
		LOGGER.info(producto);
		this.productos.add(producto);
	}
	@Override
	public List<Producto> listaProductos(){
		return this.productos;
	}
	@Override
	public void eliminarProducto(Long codigo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<Producto> getProducto(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
