package DTO;
import java.io.Serializable;

//private PagosDTO certificado;	
public class AutenticacionDTO implements Serializable {

	/**
	 * Clase autenticacionDTO que contiene todos los atributos de un usuario y contraseñas
	 */
	//aca dentro debe ir lo de pagos
	private static final long serialVersionUID = 1370979328122585637L;


	private String id;
	private String usuario;
	private String clave;
	private String mensaje;
	private String Orientacion;
	private String Resultado;
	//private EvidenciaDTO evidenciaDTO;
	private PagosDTO pagos;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	
	/**
	 * @return the orientacion
	 */
	public String getOrientacion() {
		return Orientacion;
	}

	/**
	 * @param orientacion the orientacion to set
	 */
	public void setOrientacion(String orientacion) {
		Orientacion = orientacion;
	}


	/**
	 * @return the evidenciaDTO

	public EvidenciaDTO getEvidenciaDTO() {
		return evidenciaDTO;
	}

	/**
	 * @param evidenciaDTO the evidenciaDTO to set

	public void setEvidenciaDTO(EvidenciaDTO evidenciaDTO) {
		this.evidenciaDTO = evidenciaDTO;
	}	 */


	/**
	 * @return the certificado
	 */
	public PagosDTO getPagos() {
		if (pagos == null) {
			pagos = new PagosDTO();
		}
		return pagos;
	}

	/**
	 * @param certificado the certificado to set
	 */
	public void setPagos(PagosDTO pagos) {
		this.pagos = pagos;
	}
	
	
	
	
	/**
	 * @return the credencialesSINOK
	 */
	public String getResultado() {
		return Resultado;
	}

	/**
	 * @param credencialesSINOK the credencialesSINOK to set
	 */
	public void setResultado(String credencialesSINOK) {
		Resultado = credencialesSINOK;
	}


	/**
	 * @return the resultadoEsperado
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param resultadoEsperado the resultadoEsperado to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "autenticacionDTO [usuario=" + usuario + ", clave=" + clave + ", mensaje=" + mensaje +
				 ", CredencialesSINOK=" + Resultado +", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";


	}
}
