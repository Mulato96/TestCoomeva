package com.coomeva.superantojitos.dto;

import java.util.Date;

import com.coomeva.superantojitos.domain.TestCliente;

import lombok.Data;

@Data
public class VentaDTO {

	private LinesVentaDTO[] linesVenta;

	private TestCliente cliente;

	private String valorTotalVenta;

	private Date fechaVenta;
}
