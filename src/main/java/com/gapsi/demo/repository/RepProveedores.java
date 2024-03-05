package com.gapsi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapsi.demo.entity.ProveedoresEntity;


public interface RepProveedores extends JpaRepository<ProveedoresEntity, Long> {
		
	List<ProveedoresEntity> findByNbProveedor(String nbProveedor);

}
