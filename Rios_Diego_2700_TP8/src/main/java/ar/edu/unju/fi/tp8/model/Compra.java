/**
 * 
 */
package ar.edu.unju.fi.tp8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * @author Diego
 *
 */
@Entity
@Table(name = "COMPRAS")
@Component("unaCompra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull(message = "Seleccione un producto")
	@ManyToOne
	private Producto producto;
	
	@Min(value = 1, message = "Ingrese cantidad mayor a cero")
	@Column(name = "cantidad")
	private int cantidad;
	
	@Min(value = 0, message = "La suma total no debe ser un numero negativo")
	@Column(name = "total")
	private double total;
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param producto
	 * @param cantidad
	 * @param total
	 */
	public Compra(Long id, Producto producto, int cantidad, double total) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Compra [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	
}
