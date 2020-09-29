package com.coomeva.superantojitos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coomeva.superantojitos.domain.TestProducto;
import com.coomeva.superantojitos.repo.TestProductoDao;
import com.coomeva.superantojitos.service.TestProductoService;

@Service(value = "testProductoService")
public class TestProductoServiceImpl implements TestProductoService {

	@Autowired
	private TestProductoDao productoDao;

	@Override
	public List<TestProducto> findAll() {
		return (List<TestProducto>) productoDao.findAll();
	}
}
