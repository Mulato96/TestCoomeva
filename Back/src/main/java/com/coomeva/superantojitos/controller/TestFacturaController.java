package com.coomeva.superantojitos.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coomeva.superantojitos.dto.TestFacturaDTO;
import com.coomeva.superantojitos.dto.VentaDTO;
import com.coomeva.superantojitos.service.TestFacturaService;
import com.coomeva.superantojitos.utilities.Constants;
import com.coomeva.superantojitos.utilities.ResponseService;
import com.coomeva.superantojitos.utilities.Status;

@RestController
public class TestFacturaController {

	static final Logger logger = Logger.getLogger(TestFacturaController.class);

	@Autowired
	private TestFacturaService facturaService;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/getFacturas")
	public ResponseService getAllFacturas() {
		ResponseService response = new ResponseService();
		try {
			List<TestFacturaDTO> lstFacturaDTO = facturaService.findAll();
			response.setData(lstFacturaDTO);
			response.setStatus(Status.OK);
		} catch (Exception e) {
			logger.error(Constants.ERROR_GET_PARAMETER, e);
			response.setMessageError(Constants.ERROR_GET_PARAMETER);
			response.setStatus(Status.FAILURE);
		}
		return response;

	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/saveVenta", method = RequestMethod.POST)
	public ResponseEntity<?> saveVenta(@RequestBody VentaDTO data) {
		ResponseService response = new ResponseService();
		try {
			response.setData(facturaService.saveVenta(data));
			response.setStatus(Status.OK);
			return ResponseEntity.ok(response);

		} catch (Exception e) {
			logger.error(Constants.ERROR_SAVE, e);
			response.setStatus(Status.FAILURE);
			response.setMessageError(Constants.ERROR_SAVE);
			return ResponseEntity.ok(response);
		}
	}
}
