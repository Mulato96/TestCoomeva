package com.coomeva.superantojitos.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TEST_FACTURA_DETALLE")
@Data
public class TestFacturaDetalle implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_FACTURA_DETALLE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFacturaDetalle;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CANTIDAD")
	private int cantidad;

	@Basic(optional = false)
	@NotNull
	@Column(name = "VALOR_UNIDAD")
	private int valorUnidad;

	@Basic(optional = false)
	@NotNull
	@Column(name = "VALOR_TOTAL")
	private int valorTotal;

	@JoinColumn(name = "ID_PRODUCTO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private TestProducto producto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FACTURA", nullable = false, updatable = false)
	private TestFactura factura;

}
