package com.coomeva.superantojitos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coomeva.superantojitos.domain.TestFactura;

@Repository
public interface TestFacturaDao extends JpaRepository<TestFactura, Long> {

}
