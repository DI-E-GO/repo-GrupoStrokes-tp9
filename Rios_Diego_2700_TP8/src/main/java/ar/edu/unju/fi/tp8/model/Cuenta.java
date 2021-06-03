/**
 * 
 */
package ar.edu.unju.fi.tp8.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * @author Diego
 *
 */
@Entity
@Table(name = "CUENTAS")
@Component("unaCuenta")
public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Max(value = 25000, message = "El valor maximo es de 25000 pesos")
	@Column(name = "saldo")
	private double saldo;
	
	@NotNull(message = "Seleccione una fecha de creacion de la cuenta")
	@Column(name = "fecha_creacion")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCreacion;
	
	@NotEmpty(message = "Ingrese el estado de su cuenta ACTIVA/INACTIVA")
	@Column(name = "estado")
	private String estado;
	
	@OneToOne(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private Cliente cliente;
	
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param saldo
	 * @param fechaCreacion
	 * @param estado
	 * @param cliente
	 */
	public Cuenta(Long id, double saldo, LocalDate fechaCreacion, String estado, Cliente cliente) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.cliente = cliente;
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
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	/**
	 * @return the fechaCreacion
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", saldo=" + saldo + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado
				+ ", cliente=" + cliente + "]";
	}
	
}
