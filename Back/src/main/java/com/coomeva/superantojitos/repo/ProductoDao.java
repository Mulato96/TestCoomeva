package com.coomeva.superantojitos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coomeva.superantojitos.domain.TestProducto;

@Repository
public interface ProductoDao extends JpaRepository<TestProducto, Long> {

}
