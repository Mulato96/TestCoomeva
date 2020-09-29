package com.coomeva.superantojitos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coomeva.superantojitos.domain.TestFacturaDetalle;
import com.coomeva.superantojitos.dto.VentaDTO;
import com.coomeva.superantojitos.repo.TestFacturaDetalleDao;
import com.coomeva.superantojitos.service.TestFacturaDetalleService;

@Service(value = "testFacturaDetalleService")
public class TestFacturaDetalleServiceImpl implements TestFacturaDetalleService {

	@Autowired
	private TestFacturaDetalleDao detalleFacturaDao;

	@Override
	public List<TestFacturaDetalle> findAll() {
		return (List<TestFacturaDetalle>) detalleFacturaDao.findAll();
	}

	@Override
	public TestFacturaDetalle save(VentaDTO data) {
		TestFacturaDetalle testFacturaDetalle = new TestFacturaDetalle();

		return detalleFacturaDao.save(testFacturaDetalle);
	}
}
