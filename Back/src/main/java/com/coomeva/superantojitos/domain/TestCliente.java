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
@Table(name = "TEST_CLIENTE")
@Data
public class TestCliente implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_CLIENTE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCliente;

	@Basic(optional = false)
	@NotNull
	@Column(name = "IDENTIFICACION")
	private int identificacion;

	@Basic(optional = false)
	@NotNull
	@Size(max = 100)
	@Column(name = "NOMBRES")
	private String nombres = "";

	@Basic(optional = false)
	@NotNull
	@Size(max = 100)
	@Column(name = "APELLIDOS")
	private String apellidos = "";

	@Basic(optional = false)
	@NotNull
	@Size(max = 100)
	@Column(name = "DIRECCION")
	private String direccion = "";

	@Size(max = 100)
	@Column(name = "TELEFONO")
	private String telefono = "";

	@Size(max = 100)
	@Column(name = "EMAIL")
	private String email = "";

}
