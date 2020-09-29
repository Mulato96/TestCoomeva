package com.coomeva.superantojitos.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coomeva.superantojitos.service.TestClienteService;
import com.coomeva.superantojitos.utilities.Constants;
import com.coomeva.superantojitos.utilities.ResponseService;
import com.coomeva.superantojitos.utilities.Status;

@RestController
public class TestClientesController {
	static final Logger logger = Logger.getLogger(TestClientesController.class);

	@Autowired
	private TestClienteService clienteService;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/getClientes")
	public ResponseService getAllClientes() {
		ResponseService response = new ResponseService();
		try {
			response.setData(clienteService.findAll());
			response.setStatus(Status.OK);
		} catch (Exception e) {
			logger.error(Constants.ERROR_GET_PARAMETER, e);
			response.setMessageError(Constants.ERROR_GET_PARAMETER);
			response.setStatus(Status.FAILURE);
		}
		return response;

	}
}
