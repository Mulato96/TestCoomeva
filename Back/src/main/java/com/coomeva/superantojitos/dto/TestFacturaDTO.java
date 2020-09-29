package com.coomeva.superantojitos.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.coomeva.superantojitos.domain.TestCliente;
import com.coomeva.superantojitos.domain.TestFacturaDetalle;

import lombok.Data;

@Data
public class TestFacturaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long idFactura;
	private Date fechaVenta;
	private int valorTotal;
	private TestCliente cliente;
	private List<TestFacturaDetalle> items;

}
