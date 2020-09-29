package com.coomeva.superantojitos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coomeva.superantojitos.domain.TestCliente;
import com.coomeva.superantojitos.repo.TestClienteDao;
import com.coomeva.superantojitos.service.TestClienteService;

@Service(value = "testClienteService")
public class TestClienteServiceImpl implements TestClienteService {

	@Autowired
	private TestClienteDao clienteDao;

	@Override
	public List<TestCliente> findAll() {
		return (List<TestCliente>) clienteDao.findAll();
	}
}
