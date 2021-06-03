/**
 * 
 */
package ar.edu.unju.fi.tp8.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**
 * @author Diego
 *
 */
@Entity
@Table(name = "PRODUCTOS")
@Component("unProducto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;
	
	@NotEmpty(message = "Ingrese el nombre del producto")
	@Size(min = 4, max = 50, message = "El nombre debe tener entre 4 y 50 caracteres")
	@Column(name = "nombre_producto")
	private String nombre;
	
	@NotNull(message = "Ingrese el precio del producto")
	@Min(value = 1, message = "No se permiten numeros negativos o cero")
	@Column(name = "precio")
	private double precio;
	
	@NotEmpty(message = "Ingrese la marca del producto")
	@Size(min = 2, max = 50, message = "Debe ingresar el nombre de la marca de 2 a 50 caracteres")
	@Column(name = "marca")
	private String marca;
	
	@NotNull(message = "Ingrese numero de stock")
	@Min(value = 0, message = "No se permiten numeros negativos")
	@Column(name = "stock")
	private int stock;
	
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codigo
	 * @param nombre
	 * @param precio
	 * @param marca
	 * @param stock
	 */
	public Producto(long codigo, String nombre, double precio, String marca, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", marca=" + marca
				+ ", stock=" + stock + "]";
	}
	
}
