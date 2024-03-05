package com.gapsi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gapsi.demo.service.SrvProveedores;
import com.gapsi.demo.vo.WelcomeVO;

@RestController
@RequestMapping("/")
public class CtrlWelcome {

	@Autowired
	SrvProveedores proveedoresService;
	
	@GetMapping("/home")
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView();
		WelcomeVO welcome = new WelcomeVO();
		welcome.setTitle("e-Commerce Gapsi");
		welcome.setTitleFooter("e-Commerce Gapsi - Marzo 2024");
		welcome.setTitleWelcome("Bienvenido Candidato 01");
		welcome.setTitleVersion("Version 1.0.0");
		welcome.setTitleWelcomeButton("Continuar");
		model.addObject("welcome", welcome);
		model.setViewName("welcome");
		return model;
	}
	
	@GetMapping("/proveedores")
	public ModelAndView openProveedores(@RequestParam(defaultValue = "0") int page) {
		ModelAndView model = new ModelAndView();
		WelcomeVO welcome = new WelcomeVO();
		welcome.setTitle("e-Commerce Gapsi");
		model.addObject("welcome", welcome);
		model.setViewName("catalogos/proveedores/proveedores");
		welcome.setTitleFooter("e-Commerce Gapsi - Marzo 2024");
		welcome.setTitleVersion("Version 1.0.0");
		model.addObject("listaProveedores", proveedoresService.buscarProveedores(page));
		model.addObject("currentPage", page);
		return model;
		
	}
}
