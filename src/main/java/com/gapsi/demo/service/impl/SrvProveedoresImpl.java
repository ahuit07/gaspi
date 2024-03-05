package com.gapsi.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gapsi.demo.entity.ProveedoresEntity;
import com.gapsi.demo.repository.RepProveedores;
import com.gapsi.demo.service.SrvProveedores;
import com.gapsi.demo.vo.ProveedorVO;

@Service
public class SrvProveedoresImpl implements SrvProveedores {

	@Autowired
	RepProveedores proveedoresRepo;

	@Override
	public boolean guardarProveedor(ProveedorVO proveedor) {
		boolean exito = true;
		List<ProveedoresEntity> lista = proveedoresRepo.findByNbProveedor(proveedor.getNombre());

		if (lista != null && lista.isEmpty()) {
			ProveedoresEntity proveedoresEntity = new ProveedoresEntity(proveedor.getNombre(),
					proveedor.getRazonSocial(), proveedor.getDireccion(), true);
			proveedoresRepo.save(proveedoresEntity);
		} else {
			exito = false;
		}
		return exito;
	}

	@Override
	public void eliminarProveedor(ProveedorVO proveedor) {
		proveedoresRepo.deleteById(proveedor.getId());
	}

	@Override
	public Page<ProveedoresEntity> buscarProveedores(int page) {
		return proveedoresRepo.findAll(PageRequest.of(page, 8));
	}

}
