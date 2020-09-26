package com.coomeva.superantojitos.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "TEST_PRODUCTO")
@Data
public class TestProducto implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_PRODUCTO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProducto;

	@Basic(optional = false)
	@NotNull
	@Size(max = 30)
	@Column(name = "CODIGO")
	private String codigo = "";

	@Basic(optional = false)
	@NotNull
	@Size(max = 100)
	@Column(name = "NOMBRE")
	private String nombre = "";

	@Basic(optional = false)
	@NotNull
	@Column(name = "VALOR_UNIDAD")
	private int valorUnidad;

	@Basic(optional = false)
	@NotNull
	@Column(name = "STOCK")
	private int stock;

}
