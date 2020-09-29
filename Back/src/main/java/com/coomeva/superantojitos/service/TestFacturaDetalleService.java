package com.coomeva.superantojitos.service;

import java.util.List;

import com.coomeva.superantojitos.domain.TestFacturaDetalle;
import com.coomeva.superantojitos.dto.VentaDTO;

public interface TestFacturaDetalleService {
	List<TestFacturaDetalle> findAll();

	TestFacturaDetalle save(VentaDTO data);
}
