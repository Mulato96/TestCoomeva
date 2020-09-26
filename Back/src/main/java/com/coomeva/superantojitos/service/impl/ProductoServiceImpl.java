package com.coomeva.superantojitos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coomeva.superantojitos.domain.TestProducto;
import com.coomeva.superantojitos.repo.ProductoDao;
import com.coomeva.superantojitos.service.ProductoService;

@Service(value = "productoService")
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;

	@Override
	public List<TestProducto> findAll() {
		return (List<TestProducto>) productoDao.findAll();
	}
}
