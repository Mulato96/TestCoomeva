package com.coomeva.superantojitos.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coomeva.superantojitos.domain.TestFactura;
import com.coomeva.superantojitos.domain.TestFacturaDetalle;
import com.coomeva.superantojitos.dto.TestFacturaDTO;
import com.coomeva.superantojitos.dto.VentaDTO;
import com.coomeva.superantojitos.repo.TestFacturaDao;
import com.coomeva.superantojitos.repo.TestFacturaDetalleDao;
import com.coomeva.superantojitos.service.TestFacturaService;

@Service(value = "testFacturaService")
public class TestFacturaServiceImpl implements TestFacturaService {

	@Autowired
	private TestFacturaDao facturaDao;

	@Autowired
	private TestFacturaDetalleDao facturaDetalleDao;

	@Override
	public List<TestFacturaDTO> findAll() {
		List<TestFactura> lstFacturas = facturaDao.findAll();
		List<TestFacturaDTO> lstFacturasDTO = new ArrayList<TestFacturaDTO>();

		for (int i = 0; i < lstFacturas.size(); i++) {
			TestFacturaDTO testFacturaDTO = new TestFacturaDTO();
			testFacturaDTO.setIdFactura(lstFacturas.get(i).getIdFactura());
			testFacturaDTO.setFechaVenta(lstFacturas.get(i).getFechaVenta());
			testFacturaDTO.setValorTotal(lstFacturas.get(i).getValorTotal());
			testFacturaDTO.setCliente(lstFacturas.get(i).getCliente());			
			lstFacturasDTO.add(testFacturaDTO);
		}

		return lstFacturasDTO;
	}

	@Override
	public TestFactura saveVenta(VentaDTO data) {
		TestFactura entity = new TestFactura();
		entity.setFechaVenta(data.getFechaVenta());
		entity.setValorTotal(Integer.parseInt(data.getValorTotalVenta()));
		entity.setCliente(data.getCliente());
		facturaDao.save(entity);
		for (int i = 0; i < data.getLinesVenta().length; i++) {
			TestFacturaDetalle entityDetalle = new TestFacturaDetalle();
			entityDetalle.setCantidad(Integer.parseInt(data.getLinesVenta()[i].getCantidad()));
			entityDetalle.setFactura(entity);
			entityDetalle.setProducto(data.getLinesVenta()[i].getProducto());
			entityDetalle.setValorTotal(Integer.parseInt(data.getLinesVenta()[i].getValorTotalProd()));
			entityDetalle.setValorUnidad(Integer.parseInt(data.getLinesVenta()[i].getValorUnidad()));
			facturaDetalleDao.save(entityDetalle);
		}

		return entity;

	}

}
