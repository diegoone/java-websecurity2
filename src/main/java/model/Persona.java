package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String apellidos;

	@Column(name="\"codigoUbicacion\"")
	private String codigoUbicacion;

	private String dui;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaNacimiento\"")
	private Date fechaNacimiento;

	private String genero;

	private String nombres;

	private String ocupacion;

	//bi-directional many-to-one association to Asociado
	@OneToMany(mappedBy="persona")
	private List<Asociado> asociados;

	public Persona() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCodigoUbicacion() {
		return this.codigoUbicacion;
	}

	public void setCodigoUbicacion(String codigoUbicacion) {
		this.codigoUbicacion = codigoUbicacion;
	}

	public String getDui() {
		return this.dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public List<Asociado> getAsociados() {
		return this.asociados;
	}

	public void setAsociados(List<Asociado> asociados) {
		this.asociados = asociados;
	}

	public Asociado addAsociado(Asociado asociado) {
		getAsociados().add(asociado);
		asociado.setPersona(this);

		return asociado;
	}

	public Asociado removeAsociado(Asociado asociado) {
		getAsociados().remove(asociado);
		asociado.setPersona(null);

		return asociado;
	}

}