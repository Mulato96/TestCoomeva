package com.coomeva.superantojitos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coomeva.superantojitos.domain.TestCliente;

@Repository
public interface TestClienteDao extends JpaRepository<TestCliente, Long> {

}
