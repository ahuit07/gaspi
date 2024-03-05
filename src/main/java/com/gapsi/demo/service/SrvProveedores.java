package com.gapsi.demo.service;

import org.springframework.data.domain.Page;

import com.gapsi.demo.entity.ProveedoresEntity;
import com.gapsi.demo.vo.ProveedorVO;

public interface SrvProveedores {
	
	boolean guardarProveedor(ProveedorVO proveedor);
	
	void eliminarProveedor(ProveedorVO proveedor);
	
	Page<ProveedoresEntity> buscarProveedores(int page);
}
