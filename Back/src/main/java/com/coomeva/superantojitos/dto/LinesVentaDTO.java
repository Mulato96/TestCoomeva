package com.coomeva.superantojitos.dto;

import com.coomeva.superantojitos.domain.TestProducto;

import lombok.Data;

@Data
public class LinesVentaDTO {

	private String valorTotalProd;

	private String valorUnidad;

	private TestProducto producto;

	private String cantidad;
}
