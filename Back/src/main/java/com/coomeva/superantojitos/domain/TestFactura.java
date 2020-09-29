package com.coomeva.superantojitos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TEST_FACTURA")
@Data
public class TestFactura implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_FACTURA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFactura;

	@Column(name = "FECHA_VENTA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaVenta = new Date();

	@Basic(optional = false)
	@NotNull
	@Column(name = "VALOR_TOTAL")
	private int valorTotal;

	@JoinColumn(name = "ID_CLIENTE", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private TestCliente cliente;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
	private List<TestFacturaDetalle> items;

}
