package DTO;


import java.io.Serializable;

public class PagosDTO implements Serializable {

	/**
	 * Clase UsuarioDTO que contiene todos los atributos de los pagos
	 */
	private static final long serialVersionUID = 1370979328122585637L;

	private String telefono;
	private String nombre;
	private String cantidad;
	private String pais;
	private String Mensaje;
	

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return Mensaje;
	}

	/**
	 * @param resultado the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "pagosDTO [telefono=" + telefono + ", nombre=" + nombre + ", cantidad=" + cantidad + ","
				+ "pais=" + pais + ", getClass()=" + getClass()	+ ", hashCode()=" + hashCode() 
				+ ", toString()=" + super.toString() + "]";
	}

}
