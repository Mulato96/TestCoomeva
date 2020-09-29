package com.coomeva.superantojitos.service;

import java.util.List;

import com.coomeva.superantojitos.domain.TestFactura;
import com.coomeva.superantojitos.dto.TestFacturaDTO;
import com.coomeva.superantojitos.dto.VentaDTO;

public interface TestFacturaService {

	List<TestFacturaDTO> findAll();

	public TestFactura saveVenta(VentaDTO data);
}
