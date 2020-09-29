package com.coomeva.superantojitos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coomeva.superantojitos.domain.TestFacturaDetalle;

@Repository
public interface TestFacturaDetalleDao extends JpaRepository<TestFacturaDetalle, Long> {

}
