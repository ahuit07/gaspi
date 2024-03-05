package com.gapsi.demo.controller.catalgos.proveedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gapsi.demo.service.SrvProveedores;
import com.gapsi.demo.vo.ProveedorVO;
import com.gapsi.demo.vo.WelcomeVO;

@RestController
public class CtrlPeveedores {

	@Autowired
	SrvProveedores proveedoresService;
	
	@GetMapping("nuevoProveedor")
	public ModelAndView openNuevoProveedor() {
		ModelAndView model = new ModelAndView();
		model.addObject("mensajeExito", null);
		WelcomeVO welcome = new WelcomeVO();
		welcome.setTitle("e-Commerce Gapsi");
		model.addObject("welcome", welcome);
		welcome.setTitleWelcomeButton("Regresar");
		welcome.setTitleVersion("Version 1.0.0");
		model.addObject("proveedorVO", new ProveedorVO());
		model.setViewName("catalogos/proveedores/nuevoProveedor");
		welcome.setTitleFooter("e-Commerce Gapsi - Marzo 2024");
		return model;
	}
	
	@PostMapping("/guardarProveedor")
	public ModelAndView guardarProveedor(@ModelAttribute ProveedorVO proveedor) {
		ModelAndView model = new ModelAndView();
		WelcomeVO welcome = new WelcomeVO();
		welcome.setTitle("e-Commerce Gapsi");
		model.addObject("welcome", welcome);
		welcome.setTitleWelcomeButton("Regresar");
		welcome.setTitleVersion("Version 1.0.0");
		model.addObject("proveedorVO", new ProveedorVO());
		model.addObject("mensajeExito", null);
		model.addObject("mensajeDuplicidad", null);
		if(!proveedor.getNombre().isEmpty()) {
			boolean exito = proveedoresService.guardarProveedor(proveedor);
			if(exito) {
				model.addObject("mensajeExito", "Proveedor registrado con éxito.");
			} else {
				model.addObject("mensajeDuplicidad", "El proveedor ya existe.");
			}
			model.setViewName("catalogos/proveedores/nuevoProveedor");
			welcome.setTitleFooter("e-Commerce Gapsi - Marzo 2024");
		} 
		return model;
		
	}
	
	@GetMapping("/eliminarProveedor/{id}")
	public ModelAndView eliminarProveedor(@PathVariable int id) {
		proveedoresService.eliminarProveedor(new ProveedorVO(id, null, null, null));
		ModelAndView model = new ModelAndView();
		WelcomeVO welcome = new WelcomeVO();
		welcome.setTitle("e-Commerce Gapsi");
		model.addObject("welcome", welcome);
		welcome.setTitleVersion("Version 1.0.0");
		model.addObject("mensajeExito", "Proveedor Eliminado");
		model.setViewName("catalogos/proveedores/proveedores");
		welcome.setTitleFooter("e-Commerce Gapsi - Marzo 2024");
		model.addObject("listaProveedores", proveedoresService.buscarProveedores(0));
		model.addObject("currentPage",0);
		return model;
	}
	
}
