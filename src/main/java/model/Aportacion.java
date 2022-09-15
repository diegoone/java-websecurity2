package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the aportacion database table.
 * 
 */
@Entity
@NamedQuery(name="Aportacion.findAll", query="SELECT a FROM Aportacion a")
public class Aportacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private BigDecimal monto;

	//bi-directional many-to-one association to Asociado
	@ManyToOne
	@JoinColumn(name="\"idAsociado\"")
	private Asociado asociado;

	public Aportacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Asociado getAsociado() {
		return this.asociado;
	}

	public void setAsociado(Asociado asociado) {
		this.asociado = asociado;
	}

}